package hbi.core.headerLine.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.headerLine.dto.OmOrderHeaders;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOmOrderHeadersService extends IBaseService<OmOrderHeaders>, ProxySelf<IOmOrderHeadersService>{

    /**
     * 查询订单头信息
     * @param request
     * @param orderHeader
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OmOrderHeaders> selectOrderHeader(IRequest request, OmOrderHeaders orderHeader,int pageNum,int pageSize);

    /**
     * 保存投行数据
     * 更新订单行信息
     * @param header
     * @return
     */
    OmOrderHeaders updateLineNumber(OmOrderHeaders header);

    /**
     * 保存投行数据
     * 创建行号
     * @param header
     * @return
     */
    OmOrderHeaders createLineNumber(OmOrderHeaders header);

    /**
     * 导出Excel
     * @param requestContext
     * @param header
     * @param page
     * @param pageSize
     * @return
     */
    SXSSFWorkbook exportOrderExcel(IRequest requestContext, OmOrderHeaders header, int page, int pageSize);



    /**
     * 整单删除
     *  删除订单头行信息
     * @param requestContext
     * @param orderHeaderList
     * @return
     */
    int deleteOrderHeaderAndLines(IRequest requestContext,List<OmOrderHeaders> orderHeaderList,int page, int pageSize);

    /**
     * 批量删除 (第二种方法)
     * @param request
     * @param headers
     * @return
     */
    //boolean batchDelete(IRequest request, List<OmOrderHeaders> headers);

}