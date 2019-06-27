package hbi.core.headerLine.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.code.rule.service.ISysCodeRuleProcessService;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.headerLine.dto.OmOrderLines;
import hbi.core.headerLine.mapper.OmOrderHeadersMapper;
import hbi.core.headerLine.mapper.OmOrderLinesMapper;
import hbi.core.headerLine.service.IOmOrderLinesService;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hbi.core.headerLine.dto.OmOrderHeaders;
import hbi.core.headerLine.service.IOmOrderHeadersService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderHeadersServiceImpl extends BaseServiceImpl<OmOrderHeaders> implements IOmOrderHeadersService{

    private static final String ENCODING = "UTF-8";

    @Autowired
    private OmOrderHeadersMapper omOrderHeadersMapper;

    @Autowired
    private IOmOrderLinesService omOrderLinesService;

    @Autowired
    private OmOrderLinesMapper linesMapper;

    /**
     * 查询订单头
     * @param request
     * @param orderHeader
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OmOrderHeaders> selectOrderHeader(IRequest request, OmOrderHeaders orderHeader, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //查询订单头信息
        return omOrderHeadersMapper.selectOrderHeader(orderHeader);
    }



    /**
     * 重写批量更新方法
     *  手动输入lineNumber
     * @param requestContext
     * @param orderHeader
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OmOrderHeaders> batchUpdate(IRequest requestContext, List<OmOrderHeaders> orderHeader) {
        for (OmOrderHeaders header: orderHeader) {
            if (header.getHeaderId() == null) {
                self().createLineNumber(header);
            } else if (header.getHeaderId()  != null) {
                self().updateLineNumber(header);
            }
        }
        return orderHeader;
    }

    /**
     * 更新行号操作
     * @param header
     * @return
     */
    @Override
    public OmOrderHeaders updateLineNumber(OmOrderHeaders header) {

        int count = omOrderHeadersMapper.updateByPrimaryKey(header);
        checkOvn(count,header);
        // 判断如果行不为空，则迭代循环插入
        if (header.getOrderLines() != null) {
            processLines(header);
        }
        return header;

    }

    /**
     * 创建LineNumber
     * @param header
     * @return
     */
    @Override
    public OmOrderHeaders createLineNumber(OmOrderHeaders header) {
        // 插入头
        omOrderHeadersMapper.insertSelective(header);
        // 判断如果行不为空，则迭代循环插入
        if (header.getOrderLines() != null) {
            processLines(header);
        }

        return null;
    }

    /**
     * 批量操作头行数据.
     *
     * @param header
     *            头行数据
     */
    private void processLines(OmOrderHeaders header) {
        for (OmOrderLines line : header.getOrderLines()) {
            if (line.getHeaderId() == null) {
                line.setHeaderId(header.getHeaderId()); //设置头ID跟行ID一致
                line.setCompanyId(header.getCompanyId());//设置CompanyID
                linesMapper.insertSelective(line);
            } else if (line.getHeaderId() != null) {
                int updateCount = linesMapper.updateByPrimaryKeySelective(line);
                checkOvn(updateCount,header);
            }
        }
    }


    /**
     * 导出Excel
     * @param requestContext
     * @param dto
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public SXSSFWorkbook exportOrderExcel(IRequest requestContext, OmOrderHeaders dto, int page, int pageSize) {
        if (dto.getOrderNumber().equals("null")) {
            dto.setOrderNumber(null);
        }
        if (dto.getOrderStatus().equals("null")) {
            dto.setOrderStatus(null);
        }

        //查询获取订单头信息
        List<OmOrderHeaders> orders = selectOrderHeader(requestContext, dto, page, pageSize);
        for (OmOrderHeaders order : orders) {
            OmOrderLines temOrderLines = new OmOrderLines();
            temOrderLines.setHeaderId(order.getHeaderId() == null ? 0 : order.getHeaderId());
            //获取订单详情信息
            order.setOrderLines(omOrderLinesService.selectOrderDetails(requestContext, temOrderLines, page, pageSize));
        }

        SXSSFWorkbook workbook = new SXSSFWorkbook(50);
        SXSSFSheet sheet = workbook.createSheet("Order Page");

        //创建Excel的头部
        createOrderHeaderRow(workbook, sheet);

        // 定义一个row计数器
        final AtomicInteger count = new AtomicInteger(1);
        // sheet页row索引
        final AtomicInteger rowIndex = new AtomicInteger(1);

        //创建Excel的内容
        createOrderExcelContent(workbook, sheet,orders,rowIndex);
        return workbook;
    }

    /**
     * 创建Excel文件的头部
     */
    //定义Excel的标题栏
    private static String[] titles = new String[]{"销售订单号", "公司名称", "客户名称", "订单日期	", "订单状态", "物料编码", "物料描述", "数量", "销售单价", "金额"};
    private void createOrderHeaderRow(SXSSFWorkbook wb,SXSSFSheet sheet) {
        //创建Row对象
        SXSSFRow titleRow = sheet.createRow(0);
        //给单元格设置样式
        CellStyle cellStyle = wb.createCellStyle();
        //设置对其方式
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        for (int i = 0; i < titles.length; i++) {
            SXSSFCell firstCell = titleRow.createCell(i);
            firstCell.setCellValue(titles[i]);

            // 设置列宽度
            sheet.setColumnWidth(i, titles[i].length() * 1200);
            firstCell.setCellStyle(cellStyle);
        }

    }


    /**
     * 创建Excel主题内容
     */
    private void createOrderExcelContent(SXSSFWorkbook workbook, SXSSFSheet sheet, List<OmOrderHeaders> orders, AtomicInteger rowIndex) {
        if (orders != null) {
            CellStyle dateFormat = workbook.createCellStyle();
            dateFormat.setDataFormat(workbook.createDataFormat().getFormat("yyyy-MM-DD HH:mm:ss"));
            for (OmOrderHeaders order : orders) {
                if (order.getOrderLines() != null && order.getOrderLines().size() > 0) {
                    for (OmOrderLines orderLine : order.getOrderLines()) {
                        createRow(order, orderLine, sheet.createRow(rowIndex.getAndIncrement()), dateFormat);
                    }
                } else {
                    createRow(order, null,sheet.createRow(rowIndex.getAndIncrement()), dateFormat);
                }
            }
        }
    }

    /**
     * 循环创建订单头对应的订单行
     */
    private void createRow(OmOrderHeaders orderHeader, OmOrderLines orderLine, SXSSFRow row, CellStyle dateFormat) {
        //创建单元格
        SXSSFCell cell0 = row.createCell(0);
        cell0.setCellType(CellType.NUMERIC);
        cell0.setCellValue(orderHeader.getOrderNumber());

        SXSSFCell cell1 = row.createCell(1);
        cell1.setCellType(CellType.STRING);
        cell1.setCellValue(orderHeader.getCompanyName());

        SXSSFCell cell2 = row.createCell(2);
        cell2.setCellType(CellType.STRING);
        cell2.setCellValue(orderHeader.getCustomerName());

        SXSSFCell cell3 = row.createCell(3);
        cell3.setCellStyle(dateFormat);
        cell3.setCellValue(orderHeader.getCustomerName());

        SXSSFCell cell4 = row.createCell(4);
        cell4.setCellType(CellType.STRING);
        cell4.setCellValue(orderHeader.getOrderStatus());

        //订单行数据开始
        if (orderLine == null) {
            return;
        }
        SXSSFCell cell5 = row.createCell(5);
        cell5.setCellType(CellType.STRING);
        cell5.setCellValue(orderLine.getItemCode());

        SXSSFCell cell6 = row.createCell(6);
        cell6.setCellType(CellType.STRING);
        cell6.setCellValue(orderLine.getItemDescription());

        SXSSFCell cell7 = row.createCell(7);
        cell7.setCellType(CellType.NUMERIC);
        cell7.setCellValue(orderLine.getOrderdQuantity());

        SXSSFCell cell8 = row.createCell(8);
        cell8.setCellType(CellType.NUMERIC);
        cell8.setCellValue(orderLine.getUnitSellingPrice());

        SXSSFCell cell9 = row.createCell(9);
        cell9.setCellType(CellType.NUMERIC);
        //要注意这里需要计算金额
        cell9.setCellValue(orderLine.getUnitSellingPrice()*orderLine.getOrderdQuantity());

        //想通过switch解决冗余
        /*for (int i = 0; i < 100; i++) {

            BeanInfo beanInfo = null;
            BeanInfo beanInfo2 = null;
            try {
                beanInfo = Introspector.getBeanInfo(OmOrderHeaders.class);
                beanInfo2 = Introspector.getBeanInfo(OmOrderLines.class);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            PropertyDescriptor[] propertyDesc = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor fieldObject:propertyDesc){
                System.out.println("==="+fieldObject.getName());
            }
        }*/
    }



    /**
     * 整单删除模块
     *     删除订单头和行
     * @param request
     * @param orderHeaderList
     * @return
     */
    @Override
    public int deleteOrderHeaderAndLines(IRequest request, List<OmOrderHeaders> orderHeaderList,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);

        int i = 0;
        if (orderHeaderList.size()>0) {
            for (OmOrderHeaders orderHeader : orderHeaderList) {
                i += omOrderHeadersMapper.deleteOrderHeaderAndLines(orderHeader);
            }
        }
        return i;
    }


    /**
     * 整单删除
     *  参考hap-parent
     * @param request
     * @param headers
     * @return
     */
    /*@Override
    public boolean batchDelete(IRequest request, List<OmOrderHeaders> headers) {
        // 删除头行
        OmOrderLines line = new OmOrderLines();
        for (OmOrderHeaders header : headers) {
            line.setHeaderId(header.getHeaderId());
            // 删除行
            //lineMapper.deleteByRuleId(line);
            int count = linesMapper.delete(line);
            checkOvn(count,line);
            // 删除头
            int updateCount = omOrderHeadersMapper.deleteByPrimaryKey(header);
            checkOvn(updateCount,header);
        }
        return true;
    }*/
}