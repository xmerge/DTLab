package com.xmerge.DTLab.services.cloud.transitionService.config.dubbo;

import com.xmerge.DTLab.services.cloud.transitionService.utils.DubboServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.InvokerListener;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.stereotype.Component;

/**
 * @author Xmerge
 */
@Component
@Slf4j
public class ServiceInvokerListener implements InvokerListener {
    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
        log.info("服务引用，serverId: " + invoker.getUrl().getParameter("serverId", ""));
        DubboServiceUtil.INVOKER_MAP.put(invoker.getUrl().getParameter("serverId", ""), invoker);
        log.info("当前INVOKER_MAP: " + DubboServiceUtil.INVOKER_MAP.keySet());
    }

    @Override
    public void destroyed(Invoker<?> invoker) {
        log.info("服务注销, serverId: " + invoker.getUrl().getParameter("serverId", ""));
        DubboServiceUtil.INVOKER_MAP.remove(invoker.getUrl().getParameter("serverId", ""));
        log.info("当前INVOKER_MAP: " + DubboServiceUtil.INVOKER_MAP.keySet());
    }
}
