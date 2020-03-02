package com.payloads.response.saleforce;

import java.util.List;

public class tokenResponse {
    
    private String token;

    private String baseUrl;
    
    public tokenResponse(String token, String baseUrl){
        this.token = token;
        this.baseUrl = baseUrl;
    }
    
    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl(){
        return baseUrl;
    }
}
