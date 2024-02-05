package com.xmerge.DTLab.services.cloud.transitionService.config.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.*;
import org.springframework.stereotype.Component;

/**
 * @author Xmerge
 */
@Component
@Slf4j
public class ServiceFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        log.info("ServiceFilter执行了");
        return invoker.invoke(invocation);
    }
}
