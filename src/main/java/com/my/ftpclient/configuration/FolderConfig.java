package com.my.ftpclient.configuration;

import java.util.Map;

/**
 * Created by User on 13.08.2018.
 */
public class FolderConfig {


    public Map<String, Integer> getFolderConfiguration() {
        return folderConfiguration;
    }

    public void setFolderConfiguration(Map<String, Integer> folderConfiguration) {
        this.folderConfiguration = folderConfiguration;
    }

    private Map<String,Integer> folderConfiguration;


}
