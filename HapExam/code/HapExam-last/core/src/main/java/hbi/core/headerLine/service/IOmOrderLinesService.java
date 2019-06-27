package hbi.core.headerLine.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import hbi.core.headerLine.dto.OmOrderHeaders;
import hbi.core.headerLine.dto.OmOrderLines;

import java.util.List;

public interface IOmOrderLinesService extends IBaseService<OmOrderLines>, ProxySelf<IOmOrderLinesService>{

    /**
     * 订单详情
     * @param orderLine
     * @return
     */
    List<OmOrderLines> selectOrderDetails(IRequest request, OmOrderLines orderLine,int page,int pageSize);
}