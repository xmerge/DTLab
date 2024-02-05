package com.xmerge.DTLab.services.cloud.transitionService.dto;

import com.xmerge.DTLab.services.cloud.transitionService.common.enums.InvokerStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.dubbo.rpc.Invoker;

/**
 * @author Xmerge
 */
@Data
@AllArgsConstructor
@Builder
public class InvokerServerWrapper {

    private InvokerStatusEnum status;

    private String serverId;

    private Invoker<?> invoker;
}
