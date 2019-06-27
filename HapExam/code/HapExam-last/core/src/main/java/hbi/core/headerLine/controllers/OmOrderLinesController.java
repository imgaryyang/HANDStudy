package hbi.core.headerLine.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.headerLine.dto.OmOrderLines;
import hbi.core.headerLine.service.IOmOrderLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import java.util.List;

@Controller
public class OmOrderLinesController extends BaseController{

    @Autowired
    private IOmOrderLinesService service;

    /**
     *  重写query方法,绑定query的查询
     * @param dto
     * @param page
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping(value = "/hap/om/order/lines/query")
    @ResponseBody
    public ResponseData queryLine(OmOrderLines dto,
                                  @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                  @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
                                  HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);

        System.out.println("对象"+dto);

        //查询订单详情
        List<OmOrderLines> orderLinesList = service.selectOrderDetails(requestContext, dto, page, pageSize);
        System.out.println("===="+orderLinesList.size());
        return new ResponseData(orderLinesList);
    }

    /*@RequestMapping(value = "/hap/om/order/lines/query")
    @ResponseBody
    public ResponseData query(OmOrderLines dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }*/

    @RequestMapping(value = "/hap/om/order/lines/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<OmOrderLines> dto,
                               BindingResult result,
                               HttpServletRequest request){
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
            ResponseData responseData = new ResponseData(false);
            responseData.setMessage(getErrorMessage(result, request));
            return responseData;
        }
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/hap/om/order/lines/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,
                               @RequestBody List<OmOrderLines> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
}