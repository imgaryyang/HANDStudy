package hbi.core.companys.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.companys.dto.OrgCompanys;
import hbi.core.companys.service.IOrgCompanysService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrgCompanysServiceImpl extends BaseServiceImpl<OrgCompanys> implements IOrgCompanysService {

}