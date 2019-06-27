package hbi.core.headerLine.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.headerLine.dto.OmOrderLines;

import java.util.List;

public interface OmOrderLinesMapper extends Mapper<OmOrderLines>{

    /**
     * 查询订单详情
     * @param orderLine
     * @return
     */
    List<OmOrderLines> selectOrderDetails(OmOrderLines orderLine);

}