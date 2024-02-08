package com.xmerge.DTLab.services.cloud.transitionService.config.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.Router;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceRouter implements Router {
    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public <T> List<Invoker<T>> route(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        for (Invoker<T> invoker : invokers) {
            String serverId = invoker.getUrl().getParameter("serverId");
            if (serverId.equals(invocation.getAttachment("serverId"))) {
                return invokers;
            }
        }
        return new ArrayList<Invoker<T>>(Collections.singleton(invokers.get(0)));
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean isForce() {
        return false;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
