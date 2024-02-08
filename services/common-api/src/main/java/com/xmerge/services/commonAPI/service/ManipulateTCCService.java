package com.xmerge.services.commonAPI.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author Xmerge
 */
@LocalTCC
public interface ManipulateTCCService {

    @TwoPhaseBusinessAction(name = "manipulate", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(@BusinessActionContextParameter(paramName = "deviceId") String deviceId,
                 @BusinessActionContextParameter(paramName = "deviceStatus") String deviceStatus);

    boolean commit(BusinessActionContext param);

    boolean rollback(BusinessActionContext param);
}
