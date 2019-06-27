package hbi.core.sales.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import hbi.core.sales.dto.SalesOrder;
import hbi.core.sales.service.ISalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author Create By legend
 * @date 2019/4/19 16:14
 */
@Controller
public class SalesOrderController {
    //extends BaseController
    @Autowired
    private ISalesOrderService salesOrderService;

    @RequestMapping(value = "/salesOrder/query")
    @ResponseBody
    public ResponseData query(SalesOrder salesOrder,
                              HttpServletRequest request){

        System.out.println("进来了");
        System.out.println("前端对象"+salesOrder);
        List<SalesOrder> list = salesOrderService.selectSalesOrder(salesOrder);
        return new ResponseData(list);
    }



    /*@RequestMapping(value = "/salesOrder/query")
    @ResponseBody
    public ResponseData query(SalesOrder salesOrder,
                              @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize,
                              HttpServletRequest request){

        IRequest requestContext = createRequestContext(request);
        System.out.println("进来了");
        System.out.println("前端对象"+salesOrder);
        List<SalesOrder> list = salesOrderService.selectSalesOrder(requestContext,salesOrder,page,pageSize);
        return new ResponseData(list);
    }*/
}
