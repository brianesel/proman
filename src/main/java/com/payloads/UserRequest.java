package com.payloads;

import javax.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank
    private String accessToken;

    public String getaccessToken() {
        return accessToken;
    }

    public void setUsernameOrEmail(String accessToken) {
        this.accessToken = accessToken;
    }
}
