package com.framework.Helper.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.framework.Helper.ProjectLevelFilePath;


public class LoggerHelper {
    private static boolean root = false;
    public static Logger getLogger(Class clas) {
        if(root)
            return Logger.getLogger(clas);
        
        //PropertyConfigurator.configure(ProjectLevelFilePath.getProjectPath()+"\\src\\main\\resources\\logFolder\\log4j.properties");
        // Changing this path as it is failing in Jenkins server , Jagadeesh javali , Date:24th OCT 2020
         PropertyConfigurator.configure(ProjectLevelFilePath.getProjectPath()+"/src/main/resources/logFolder/log4j.properties");
        root = true;
        return Logger.getLogger(clas);
    }
}
