package com.framework.API;

public enum APIResources {
    
    GetSaleforceToken("https://sitvcmmemberpool.auth.us-east-2.amazoncognito.com/oauth2/token"),
    UnlockOnlineId("/users/user/unlock");
    private String resource;
    APIResources(String resource) {
        this.resource = resource;
    }
    
    public String getResource() {
        return resource;
    }
    
}
