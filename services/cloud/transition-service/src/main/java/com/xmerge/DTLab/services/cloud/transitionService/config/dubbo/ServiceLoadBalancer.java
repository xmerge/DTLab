package com.xmerge.DTLab.services.cloud.transitionService.config.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Xmerge
 */
@Component
@Slf4j
public class ServiceLoadBalancer extends AbstractLoadBalance {
    @Override
    protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
        Map<String, String> map = invocation.getAttachments();
        String serverId = map.get("serverId");
        log.info("serverId: {}", serverId);
        Invoker<T> invoker = invokers.stream()
                .filter(invoker1 -> serverId.equals(invoker1.getUrl().getParameter("serverId"))).findFirst().orElse(null);
        if (invoker != null) {
            return invoker;
        }
        throw new RuntimeException("没有找到对应的provider from ServiceLoadBalancer");
    }
}
