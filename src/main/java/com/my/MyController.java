package com.my;

import com.my.ftpclient.ftp.FtpClient;
import com.my.ftpclient.ftp.FtpListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by User on 08.08.2018.
 */
@Controller
@RequestMapping("/")
public class MyController {

    ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");

    @RequestMapping(path = "/ftp154",method = RequestMethod.GET)
    public String getFromFtp(ModelMap model){
        FtpListener ftpClient=(FtpListener) context.getBean("ftp1");
        model.addAttribute("host",ftpClient.getHost());
        model.addAttribute("result",ftpClient.getFileList());
        return "result";
    }

    @RequestMapping(path = "/ftp214",method = RequestMethod.GET)
    public String getFromFtpTwo(ModelMap model){
        FtpListener ftpClient=(FtpListener) context.getBean("ftp2");
        model.addAttribute("host",ftpClient.getHost());
        model.addAttribute("result",ftpClient.getFileList());
        return "result";
    }


}
