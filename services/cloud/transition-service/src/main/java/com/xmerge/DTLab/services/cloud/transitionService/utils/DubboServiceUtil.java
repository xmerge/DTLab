package com.xmerge.DTLab.services.cloud.transitionService.utils;



import com.xmerge.DTLab.services.cloud.transitionService.common.enums.InvokerStatusEnum;
import com.xmerge.DTLab.services.cloud.transitionService.dto.InvokerServerWrapper;
import org.apache.dubbo.rpc.protocol.InvokerWrapper;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Xmerge
 */
public class DubboServiceUtil {

    public static final ConcurrentHashMap<String, InvokerServerWrapper> INVOKER_SERVER_MAP = new ConcurrentHashMap<>();

    public static Boolean isServerAvailable(String serverId) {
        return INVOKER_SERVER_MAP.containsKey(serverId) &&
                INVOKER_SERVER_MAP.get(serverId).getStatus().equals(InvokerStatusEnum.AVAILABLE);
    }

    public static Boolean isServerOffline(String serverId) {
        return INVOKER_SERVER_MAP.containsKey(serverId) &&
                INVOKER_SERVER_MAP.get(serverId).getStatus().equals(InvokerStatusEnum.OFFLINE);
    }
}
