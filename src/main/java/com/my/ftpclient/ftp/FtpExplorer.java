package com.my.ftpclient.ftp;

import com.my.ftpclient.check.ActualUpdate;
import com.my.ftpclient.imp.FolderConfigerationImp;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by User on 08.08.2018.
 */
public class FtpExplorer {

    private FolderConfigerationImp folderList;
    private static ArrayList<HashMap> resultList = new ArrayList<>();
    private ArrayList<HashMap> oneRecord = new ArrayList<>();
    private FTPClient ftpClient;
    private ActualUpdate check = new ActualUpdate();
    final static Logger LOG=Logger.getLogger(FtpClient.class);


    @NotNull
    private FTPFile[] getFileList(String dir) {
        final FTPFile[] defaultResult = {};
        try {
            return ftpClient.listFiles(dir);
        } catch (IOException e) {
            LOG.error(e.getMessage());
            return defaultResult;
        }
    }

    public void findFiles(String rootDir) {
        resultList.clear();
        for (FTPFile ftpFolder : getFileList(rootDir))
            if (ftpFolder.isDirectory()) {
                String folderName = ftpFolder.getName();
                if (folderName.substring(0, 7).equals("SERV_IP"))  getBackupDirectory(rootDir + folderName);
            }
    }

    private void getBackupDirectory(String directory) {
        for (FTPFile ftpFolder : getFileList(directory))
            if (ftpFolder.isDirectory()) {
                String subDur = directory + "/" + ftpFolder.getName();
                oneRecord.clear();
                folderList.getFolders().forEach((k, v) -> getBackupFile(subDur, k, v));
                if (oneRecord.size() > 0)  check.cheсkActualUpdate(oneRecord,resultList);
            }
    }

    private void getBackupFile(String directory, String folderName, int period) {
        String name = null;
        HashMap fileInfo = new HashMap();
        ArrayList<LocalDate> fileList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        for (FTPFile ftpFile : getFileList(directory + "/" + folderName))
            if (ftpFile.isFile()) {
                String fileName = ftpFile.getName();
                String createDate = fileName.substring(fileName.length() - 12, fileName.length() - 4);
                if (createDate.length() == 8) {
                    name = fileName.substring(0, fileName.length() - 12);
                    LocalDate fileCreateDate = LocalDate.parse(createDate, dateTimeFormatter);
                    fileList.add(fileCreateDate);
                }
            }

        if (fileList.size() > 0) {
            fileInfo.put("name", name);
            fileInfo.put("folder", folderName);
            fileInfo.put("date", Collections.max(fileList));
            fileInfo.put("update", period);
            oneRecord.add(fileInfo);
        }
    }

    public ArrayList<HashMap> getResult() {
        return resultList;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }

    public FtpExplorer(FolderConfigerationImp folderList) {
        this.folderList = folderList;
    }

}
