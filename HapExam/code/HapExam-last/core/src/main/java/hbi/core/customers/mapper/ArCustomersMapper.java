package hbi.core.customers.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.customers.dto.ArCustomers;

import java.util.List;

public interface ArCustomersMapper extends Mapper<ArCustomers>{

    /**
     * 模糊查询客户信息
     * @param customer
     * @return
     */
    List<ArCustomers> queryFuzzy(ArCustomers customer);
}