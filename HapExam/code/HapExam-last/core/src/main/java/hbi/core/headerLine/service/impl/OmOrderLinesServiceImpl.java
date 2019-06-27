package hbi.core.headerLine.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.headerLine.mapper.OmOrderLinesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hbi.core.headerLine.dto.OmOrderLines;
import hbi.core.headerLine.service.IOmOrderLinesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderLinesServiceImpl extends BaseServiceImpl<OmOrderLines> implements IOmOrderLinesService{

    @Autowired
    private OmOrderLinesMapper orderLinesMapper;

    /**
     * 订单详情
     * @param request
     * @param orderLine
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<OmOrderLines> selectOrderDetails(IRequest request, OmOrderLines orderLine,int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return orderLinesMapper.selectOrderDetails(orderLine);
    }
}