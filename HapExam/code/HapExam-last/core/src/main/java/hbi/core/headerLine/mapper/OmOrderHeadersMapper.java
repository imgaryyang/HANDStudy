package hbi.core.headerLine.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hbi.core.headerLine.dto.OmOrderHeaders;

import java.util.List;

public interface OmOrderHeadersMapper extends Mapper<OmOrderHeaders>{

    /**
     * 查询订单头信息
     * @param orderHeader
     * @return
     */
    List<OmOrderHeaders> selectOrderHeader(OmOrderHeaders orderHeader);

    /**
     * 删除订单头行
     * @param orderHeader
     * @return
     */
    int deleteOrderHeaderAndLines(OmOrderHeaders orderHeader);
}