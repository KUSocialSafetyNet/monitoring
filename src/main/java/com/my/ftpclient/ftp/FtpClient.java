package com.my.ftpclient.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 08.08.2018.
 */

public class FtpClient implements FtpListener {


    private String host;
    private String login;
    private String pass;
    private String backupDirectory;

    public static FTPClient ftpClient=new FTPClient();
    FtpExplorer ftpExplorer =new FtpExplorer();

    FtpClient(String host,String login,String pass,String backupDirectory){
        this.host=host;
        this.login=login;
        this.pass=pass;
        this.backupDirectory=backupDirectory;

    }

    @Override
    public String getHost() {
        return host;

    }


    @Override
    public void connectToFtp() throws Exception{
        ftpClient.connect(host);
        ftpClient.login(login,pass);
        ftpClient.enterLocalPassiveMode();
        int reply=ftpClient.getReplyCode();
        ftpClient.changeWorkingDirectory(backupDirectory);
        ftpClient.listFiles();
        if(!FTPReply.isPositiveCompletion(reply)) {
            disconnect();
            new Throwable("Отказ соединения с FTP");
        }
    }

    @Override
    public void disconnect() throws Exception{
        ftpClient.disconnect();
    }

    @Override
    public ArrayList<HashMap> getFileList() {
        try{
            connectToFtp();
            ftpExplorer.findFiles();
            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ftpExplorer.resu();
    }


}
