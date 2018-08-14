package com.my.ftpclient.check;

import com.my.ftpclient.ftp.FtpExplorer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 08.08.2018.
 */
public class CheckingFiles {


   public void chekActualUpdate(ArrayList<HashMap> input)
   {
       HashMap result=new HashMap();

        input.forEach(info->{
            String res;
            LocalDate createDate=(LocalDate) info.get("date");
            result.put("name",info.get("name"));
            result.put(info.get("folder")+"id","error");
            if (ChronoUnit.DAYS.between(createDate,LocalDate.now())<=(int)info.get("update")){
                res="Актуально";
                result.put(info.get("folder")+"id","noerror");}
                else res="Не актуально <BR>последний бэкап:("+createDate+")";
                result.put(info.get("folder"),res);
        });

       FtpExplorer.resultList.add(result);
    }



}