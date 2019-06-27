package hbi.core.sales.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.sales.mapper.SalesOrderMapper;
import hbi.core.sales.service.ISalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hbi.core.sales.dto.SalesOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Create By legend
 * @date 2019/4/19 19:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SalesOrderServiceImpl  implements ISalesOrderService {

    //extends BaseServiceImpl<SalesOrder>
    @Autowired
    private SalesOrderMapper salesOrderMapper;

    @Override
    public List<SalesOrder> selectSalesOrder(SalesOrder so) {
        return salesOrderMapper.selectSalesOrder(so);
    }


    /*@Override
    public List<SalesOrder> selectSalesOrder(IRequest request, SalesOrder so, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return salesOrderMapper.selectSalesOrder(so);
    }*/
}
