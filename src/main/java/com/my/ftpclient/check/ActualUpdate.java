package com.my.ftpclient.check;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class ActualUpdate {

    public void cheсkActualUpdate(ArrayList<HashMap> input, ArrayList<HashMap> out) {
        HashMap result = new HashMap();
        input.forEach(info -> {
            LocalDate createDate = (LocalDate) info.get("date");
            String res="Не актуально <BR>последний бэкап:(" + createDate + ")";
            result.put("name", info.get("name"));
            result.put(info.get("folder") + "id", "error");
            if (ChronoUnit.DAYS.between(createDate, LocalDate.now()) <= (int) info.get("update")) {
                res = "Актуально";
                result.put(info.get("folder") + "id", "noerror");
            }
            result.put(info.get("folder"), res);
        });
        out.add(result);
    }

}