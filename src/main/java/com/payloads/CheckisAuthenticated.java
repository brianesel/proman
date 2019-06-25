package com.payloads;

import javax.validation.constraints.NotBlank;

public class CheckisAuthenticated {
    @NotBlank
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
