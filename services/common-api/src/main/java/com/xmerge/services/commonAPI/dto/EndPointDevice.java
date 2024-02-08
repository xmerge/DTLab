package com.xmerge.services.commonAPI.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @author Xmerge
 */
@Data
@RequiredArgsConstructor
public class EndPointDevice implements Serializable {

    private final String deviceId;

    private final String deviceName;

    private final Integer deviceType;

    private final String deviceLocation;

    private final Integer deviceStatus;
}
