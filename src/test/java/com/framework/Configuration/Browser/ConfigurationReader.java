package com.framework.Configuration.Browser;

public interface ConfigurationReader {
    
    public String getbrowserType();
    public String getSITURL();
    public String getSITUserName();
    public String getSITPassword();
    public String getUATURL();
    public String getUATUserName();
    public String getUATPassword();
    public String getRemoteDriverPath();
    public String getEnv();
}

