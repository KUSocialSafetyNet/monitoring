package com.my.ftpclient.result;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 08.08.2018.
 */
public class Result {
    ArrayList<HashMap> resultList=new ArrayList<HashMap>();

    public Result(){
        resultList.clear();
    }


    public ArrayList<HashMap> getResultList() {
        return resultList;
    }

    public void addToList(HashMap fileInfo) {
        this.resultList.add(fileInfo);
        // this.resultList = resultList;
    }

}
