package hbi.core.sales.mapper;


import com.hand.hap.mybatis.common.Mapper;
import hbi.core.sales.dto.SalesOrder;

import java.util.List;

public interface SalesOrderMapper  {

    /**
     * extends Mapper<SalesOrder>
     * 查找订单头
     * @param salesOrder
     * @return
     */
    List<SalesOrder> selectSalesOrder(SalesOrder salesOrder);

}
