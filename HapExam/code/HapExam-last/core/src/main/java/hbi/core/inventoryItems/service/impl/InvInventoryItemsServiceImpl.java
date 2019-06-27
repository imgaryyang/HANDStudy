package hbi.core.inventoryItems.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import hbi.core.inventoryItems.dto.InvInventoryItems;
import hbi.core.inventoryItems.service.IInvInventoryItemsService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class InvInventoryItemsServiceImpl extends BaseServiceImpl<InvInventoryItems> implements IInvInventoryItemsService{

}