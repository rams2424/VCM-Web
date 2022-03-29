package com.framework.ConfigReader;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.framework.Configuration.Browser.ConfigurationReader;
import com.framework.Helper.ProjectLevelFilePath;
import com.framework.Helper.Logger.LoggerHelper;

public class PropertyFileReader implements ConfigurationReader{
    
    private Properties prop = null;
    Logger log = LoggerHelper.getLogger(PropertyFileReader.class);
    public PropertyFileReader() {
        prop = new Properties();
        String filePath = ProjectLevelFilePath.getProjectPath()+"//src//main//resources//PropertyFile//config.properties";
        try {
            prop.load(new FileInputStream(filePath));
        } catch (Exception e) {
            log.info(e.getMessage());
        }	
    }
    
    public String getbrowserType() {
        log.info(prop.getProperty("browserType"));
        return prop.getProperty("browserType");
    }
    
    
    @Override
    public String getRemoteDriverPath() {
        log.info(prop.getProperty("NodeURL"));
        return prop.getProperty("NodeURL");
    }
    
    
    @Override
    public String getEnv() {
        log.info(prop.getProperty("env"));
        return prop.getProperty("env");
    }
    
    @Override
    public String getSITURL() {
        log.info(prop.getProperty("SitUrl"));
        return prop.getProperty("SitUrl");
    }
    
    @Override
    public String getSITUserName() {
        log.info(prop.getProperty("SitUserName"));
        return prop.getProperty("SitUserName");
    }
    
    @Override
    public String getSITPassword() {
        log.info(prop.getProperty("SitPassWord"));
        return prop.getProperty("SitPassWord");
    }
    
    @Override
    public String getUATURL() {
        log.info(prop.getProperty("UatUrl"));
        return prop.getProperty("UatUrl");
    }
    
    @Override
    public String getUATUserName() {
        log.info(prop.getProperty("UatUserName"));
        return prop.getProperty("UatUserName");
    }
    
    @Override
    public String getUATPassword() {
        log.info(prop.getProperty("UatPassWord"));
        return prop.getProperty("UatPassWord");
    }
}
