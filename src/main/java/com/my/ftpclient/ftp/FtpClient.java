package com.my.ftpclient.ftp;

import com.my.ftpclient.configuration.FtpConfiguration;
import com.my.ftpclient.imp.FtpListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class FtpClient implements FtpListener {

    private String host;
    private String login;
    private String pass;
    private String root;
    private FtpExplorer ftpExplorer;
    private FTPClient ftpClient=new FTPClient();
    final static Logger LOG=Logger.getLogger(FtpClient.class);

    @Override
    public ArrayList<HashMap> startCheck() {
        try {
            connectToFtp();
            ftpExplorer.setFtpClient(ftpClient);
            ftpExplorer.findFiles(root);
        } catch (Exception e) {
            LOG.error(e.getMessage()); }
                return ftpExplorer.getResult();
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
    public void setConfiguration(FtpConfiguration ftpConfiguration) {
        this.host=ftpConfiguration.getHost();
        this.login=ftpConfiguration.getLogin();
        this.pass=ftpConfiguration.getPassword();
        this.root=ftpConfiguration.getRoot();
    }

    public void setFtpExplorer(FtpExplorer ftpExplorer) {
        this.ftpExplorer = ftpExplorer;
    }

}
