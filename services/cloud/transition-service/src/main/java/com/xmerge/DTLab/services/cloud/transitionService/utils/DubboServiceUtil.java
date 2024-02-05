package com.xmerge.DTLab.services.cloud.transitionService.utils;

import org.apache.dubbo.rpc.Invoker;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Xmerge
 */
public class DubboServiceUtil {

    public static final ConcurrentHashMap<String, Invoker<?>> INVOKER_MAP = new ConcurrentHashMap<>();

    public static Boolean isServiceAvailable(String uniqueId) {
        return INVOKER_MAP.containsKey(uniqueId);
    }
}
