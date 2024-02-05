package com.xmerge.DTLab.services.cloud.transitionService.config.dubbo;

import com.xmerge.DTLab.services.cloud.transitionService.common.enums.InvokerStatusEnum;
import com.xmerge.DTLab.services.cloud.transitionService.dto.InvokerServerWrapper;
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
        String serverId = invoker.getUrl().getParameter("serverId", "");
        log.info("服务引用，serverId: " + serverId);
        InvokerServerWrapper invokerServerWrapper = InvokerServerWrapper.builder()
                .invoker(invoker)
                .serverId(serverId)
                .status(InvokerStatusEnum.AVAILABLE)
                .build();
        DubboServiceUtil.INVOKER_SERVER_MAP.put(serverId, invokerServerWrapper);
        log.info("当前INVOKER_MAP: " + DubboServiceUtil.INVOKER_SERVER_MAP.keySet());
    }

    @Override
    public void destroyed(Invoker<?> invoker) {
        String serverId = invoker.getUrl().getParameter("serverId", "");
        log.info("服务注销, serverId: " + serverId);
        InvokerServerWrapper invokerServerWrapper = DubboServiceUtil.INVOKER_SERVER_MAP.get(serverId);
        invokerServerWrapper.setStatus(InvokerStatusEnum.OFFLINE);
        DubboServiceUtil.INVOKER_SERVER_MAP.put(serverId, invokerServerWrapper);
        log.info("当前INVOKER_MAP: " + DubboServiceUtil.INVOKER_SERVER_MAP.keySet());
    }
}
