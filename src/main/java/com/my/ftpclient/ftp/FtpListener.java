package com.my.ftpclient.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 13.08.2018.
 */
public interface FtpListener {



    void connectToFtp() throws Exception;
    void disconnect() throws Exception;
    ArrayList<HashMap> getFileList();
    String getHost();
}
