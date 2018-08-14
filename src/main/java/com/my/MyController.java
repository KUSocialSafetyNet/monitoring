package com.my;

import com.my.ftpclient.ftp.FtpListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * Created by User on 08.08.2018.
 */
@Controller
@RequestMapping("/")
public class MyController {

    private ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

    @RequestMapping(path = "/ftp", method = RequestMethod.GET)
    public String getFromFtp(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        int id;
        if (allRequestParams.get("id") == null) id = 0;
        else id = Integer.parseInt(allRequestParams.get("id"));
        List<FtpListener> ftpServer = (List<FtpListener>) context.getBean("ftpServerList");
        model.addAttribute("host", ftpServer.get(id).getHost());
        model.addAttribute("result", ftpServer.get(id).getFileList());
        return "result";
    }

    @RequestMapping(path = "/ftp214", method = RequestMethod.GET)
    public String getFromFtpTwo(ModelMap model) {
        FtpListener ftpClient = (FtpListener) context.getBean("ftp2");
        model.addAttribute("host", ftpClient.getHost());
        model.addAttribute("result", ftpClient.getFileList());
        return "result";
    }


}
