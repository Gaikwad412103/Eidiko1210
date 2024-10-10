package com.restApi.SpringBootRestApi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Userlogin {
    @NotNull(message = "not null is not allowed")
    private long userId;
    @NotNull(message = "not null is not allowed")
    private String password;
}
