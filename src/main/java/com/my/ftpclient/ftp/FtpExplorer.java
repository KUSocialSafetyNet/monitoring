package com.my.ftpclient.ftp;

import com.my.ftpclient.check.CheckingFiles;
import com.my.ftpclient.result.Result;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by User on 08.08.2018.
 */
public class FtpExplorer {

    //TODO временный array list
    public static ArrayList<HashMap> resultList=new ArrayList<HashMap>();
    ArrayList<HashMap> oneRecord=new ArrayList<>();
    Result fileList=new Result();
    String root;
    FTPClient ftpClient;

    enum FoldersName {DAY,WEEK,MONTH}

    public FtpExplorer(){
        resultList.clear();
    }

    @NotNull
    private FTPFile[] getFileList(String dir) {
        //TODO что делать если будет NULL
        final FTPFile[] defaultResult={};
        try {
            return ftpClient.listFiles(dir);
        } catch (IOException e) {
            e.printStackTrace();
            return defaultResult;
        }
    }

    public void seter(FTPClient ftpClient){
        this.ftpClient=ftpClient;
    }

    public void findFiles(String rootDir) {
            resultList.clear();
            for (FTPFile ftpFolder : getFileList(rootDir)) {
                if (ftpFolder.isDirectory()) {
                    String folderName = ftpFolder.getName();
                    if (folderName.substring(0, 7).equals("SERV_IP")) {
                        getBackupDirectory(rootDir + folderName);
                    }
                }
            }

    }

    void clearAll(){
        resultList.clear();
    }


    private void getBackupDirectory(String directory){
        boolean fileExist=true;
        for (FTPFile ftpFolder:getFileList(directory)) {
            if (ftpFolder.isDirectory()) {
                String subDur = directory + "/" + ftpFolder.getName();
                //TODO fuck
                    oneRecord.clear();
                    getBackupFile(subDur, FoldersName.DAY.toString(),1);
                    getBackupFile(subDur, FoldersName.WEEK.toString(),7);
                    getBackupFile(subDur, FoldersName.MONTH.toString(),33);
                //TODo надо что то менять здесь
                if (oneRecord.size()>0){
                CheckingFiles cf=new CheckingFiles();
                cf.chekActualUpdate(oneRecord);}
            }
        }
    }

    private boolean getBackupFile(String directory,String folderName,int period){
        String name=null;
        HashMap fileInfo=new HashMap();
        ArrayList<LocalDate> fileList=new ArrayList<>();
        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyyMMdd");

        for (FTPFile ftpFile:getFileList(directory+"/"+folderName)) {
            if (ftpFile.isFile()) {
                String fileName = ftpFile.getName();
                    String createDate=fileName.substring(fileName.length()-12,fileName.length()-4);
                    if(createDate.length()==8){
                        name=fileName.substring(0,fileName.length()-12);
                        LocalDate fileCreateDate=LocalDate.parse(createDate,dateTimeFormatter);
                        fileList.add(fileCreateDate);}
            }
        }

        if(fileList.size()>0) {
            fileInfo.put("name", name);
            fileInfo.put("folder", folderName);
            fileInfo.put("date", Collections.max(fileList));
            fileInfo.put("update", period);
            oneRecord.add(fileInfo);
            //writeFileList(fileInfo);
            return true;

        }  else return false;
    }


    private void writeFileList(HashMap fileInfo){
        fileList.addToList(fileInfo);
    }

    public ArrayList<HashMap> resu(){
        return resultList;
    }


}
