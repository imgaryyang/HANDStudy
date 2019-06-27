package hbi.core.sales.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.companys.dto.OrgCompanys;
import hbi.core.customers.dto.ArCustomers;
import hbi.core.headerLine.dto.OmOrderHeaders;
import hbi.core.headerLine.dto.OmOrderLines;
import hbi.core.inventoryItems.dto.InvInventoryItems;
import hbi.core.sales.dto.SalesOrder;

import java.util.List;

/**
 * @author Create By legend
 * @date 2019/4/19 19:43
 */
public interface ISalesOrderService {

    /**
     * extends IBaseService<SalesOrder>, ProxySelf<ISalesOrderService>
     * OrgCompanys company, ArCustomers customer, InvInventoryItems item, OmOrderHeaders header, OmOrderLines line
     * @return
     */
    /*List<SalesOrder> selectSalesOrder(IRequest request,SalesOrder salesOrder,int page,int pageSize);*/

    List<SalesOrder> selectSalesOrder(SalesOrder so);
}
