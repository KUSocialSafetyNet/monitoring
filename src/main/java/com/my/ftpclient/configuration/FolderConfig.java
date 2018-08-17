package com.my.ftpclient.configuration;

import com.my.ftpclient.imp.FolderConfigerationImp;
import java.util.Map;

public class FolderConfig implements FolderConfigerationImp {

    public Map<String, Integer> getFolderConfiguration() {
        return folderConfiguration;
    }

    private Map<String, Integer> folderConfiguration;

    public void setFolderConfiguration(Map<String, Integer> folderConfiguration) {
        this.folderConfiguration = folderConfiguration;
    }

    @Override
    public Map<String, Integer> getFolders() {
        return folderConfiguration;
    }
}
