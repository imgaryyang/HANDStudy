package hbi.core.headerLine.controllers;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.hap.excel.dto.ColumnInfo;
import com.hand.hap.excel.dto.ExportConfig;
import com.hand.hap.excel.service.IExportService;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.headerLine.dto.OmOrderHeaders;
import hbi.core.headerLine.service.IOmOrderHeadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OmOrderHeadersController extends BaseController{


    private static final String ENCODING = "UTF-8";

    /**
     * 引进两个变量完成导出excel数据
     * POI excel导出
     */
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IExportService exportService;


    @Autowired
    private IOmOrderHeadersService service;


    /**
     * 整单删除模块
     *  删除订单头和行信息
     * @param dto
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/hap/om/order/headers/deleteOrderHeaderAndLines")
    @ResponseBody
    public ResponseData deleteOrderHeaderAndLines(@RequestBody List<OmOrderHeaders> dto,
                                           @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                           @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
                                           HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        int n = service.deleteOrderHeaderAndLines(requestContext,dto,page,pageSize);
        System.out.println("删除记录数:"+n);

        return new ResponseData(new ArrayList<>());
    }



    /**
     * 重写query方法
     * @param dto
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/hap/om/order/headers/query")
    @ResponseBody
    public ResponseData query(OmOrderHeaders dto,
                              @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
                              HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        //有条件选择
        return new ResponseData(service.selectOrderHeader(requestContext,dto,page,pageSize));
    }



    /**
     * 导出Excel
     *  参考 hap-parent 源码项目
     * @param dto
     * @param page
     * @param pageSize
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping(value = "/hap/om/order/headers/exportOrderExcel")
    public void exportOrderExcel(OmOrderHeaders dto,
                                 @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                 @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse) throws Exception{

        IRequest requestContext = createRequestContext(httpServletRequest);

        //自定义时间戳改变下载的名字
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String strDate = formatter.format(date);
        strDate = strDate.trim();
        strDate = strDate.replace("-","");

        String name = "SalesOrder"+strDate+".xlsx";
        String userAgent = httpServletRequest.getHeader("User-Agent");
        if(userAgent.contains("Firefox")){
            name=new String(name.getBytes("UTF-8"), "ISO8859-1");
        }else{
            name=URLEncoder.encode(name, ENCODING);
        }
        httpServletResponse.addHeader("Content-Disposition",
                "attachment; filename=\"" + name + "\"");
        httpServletResponse.setContentType("application/vnd.ms-excel" + ";charset=" + ENCODING);
        httpServletResponse.setHeader("Accept-Ranges", "bytes");

        //导出Excel方法
        SXSSFWorkbook excelFile = service.exportOrderExcel(requestContext, dto, page, pageSize);

        try (ServletOutputStream outputStream = httpServletResponse.getOutputStream()) {
            excelFile.write(outputStream);
        } finally {
            excelFile.close();
            excelFile.dispose();
        }
    }


    /**
     * 保存投行信息
     * @param dto
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/hap/om/order/headers/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<OmOrderHeaders> dto, BindingResult result, HttpServletRequest request){
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
            ResponseData responseData = new ResponseData(false);
            responseData.setMessage(getErrorMessage(result, request));
            return responseData;
        }
        IRequest requestCtx = createRequestContext(request);

        //重写batchUpdate 同时保存订单头和行
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hap/om/order/headers/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<OmOrderHeaders> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
}