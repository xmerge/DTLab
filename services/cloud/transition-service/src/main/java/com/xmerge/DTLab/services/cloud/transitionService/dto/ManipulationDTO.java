package com.xmerge.DTLab.services.cloud.transitionService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Xmerge
 */
@Data
@RequiredArgsConstructor
public class ManipulationDTO {

    private String serverId;
    private String deviceId;
    private String deviceStatus;
}
