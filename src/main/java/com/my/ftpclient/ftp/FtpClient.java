package com.my.ftpclient.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 08.08.2018.
 */

public class FtpClient implements FtpListener {


    public Map<String,Integer> getGod() {
        return god;
    }

    public void setGod(Map<String,Integer> god) {
        this.god = god;
    }

    private Map<String,Integer> god;

    private String host;
    private String login;
    private String pass;



    public String getBackupDirectory() {
        return backupDirectory;
    }

    public void setBackupDirectory(String backupDirectory) {
        this.backupDirectory = backupDirectory;
    }

    private String backupDirectory;

    public FTPClient ftpClient=new FTPClient();
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
        if(!FTPReply.isPositiveCompletion(reply)) {
            disconnect();
            new Throwable("Отказ соединения с FTP");
        }
    }

    @Override
    public void disconnect() throws Exception{
        ftpClient.disconnect();
        System.out.println("Disconnect from "+host);
    }

    @Override
    public ArrayList<HashMap> getFileList() {
        try {
            connectToFtp();
            ftpExplorer.seter(ftpClient);
            ftpExplorer.findFiles(getBackupDirectory());
            System.out.println(god.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ftpExplorer.resu();
    }


}
