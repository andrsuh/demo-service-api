package com.wine.to.up.test.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@AllArgsConstructor
public class ServiceMessage {
    @NotNull
    private Map<String, byte[]> headers;
    @NotNull
    private String message;
}
