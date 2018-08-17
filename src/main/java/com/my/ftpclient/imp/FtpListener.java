package com.my.ftpclient.imp;

import com.my.ftpclient.configuration.FtpConfiguration;
import java.util.ArrayList;
import java.util.HashMap;

public interface FtpListener {
    void connectToFtp() throws Exception;

    void disconnect() throws Exception;

    void setConfiguration(FtpConfiguration ftpConfiguration);

    ArrayList<HashMap> startCheck();
}
