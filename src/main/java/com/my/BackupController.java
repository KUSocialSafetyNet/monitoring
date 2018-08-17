package com.my;

import com.my.ftpclient.configuration.FtpConfiguration;
import com.my.ftpclient.imp.FtpListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class BackupController {

    private ApplicationContext context = new ClassPathXmlApplicationContext("ftp-updater-context.xml");
    private List<FtpConfiguration>  ftpConfiguration=(List<FtpConfiguration>) context.getBean("ftpConfigList");
    private FtpListener ftpClient = (FtpListener) context.getBean("ftpClient");
    private final String ROOT="/backup";

    @RequestMapping(path = ROOT, method = RequestMethod.GET)
    public String selectFtp(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        String viewPage;
        if (allRequestParams.get("id") != null)  {
            int id = Integer.parseInt(allRequestParams.get("id"));
            viewPage=getFtpPage(id,model);
        } else viewPage=getAllFtp(model);
        return viewPage;
    }

    private String getAllFtp(ModelMap model) {
        ArrayList<String> serverList=new ArrayList<>();
        ftpConfiguration.forEach(ftpList -> serverList.add(ftpList.getHost()));
        model.addAttribute("title", "Бэкапирование");
        model.addAttribute("root", ROOT);
        model.addAttribute("serverList", serverList);
        return ROOT+"/backup";
    }

    private String getFtpPage(int id, ModelMap model) {
            if (id < ftpConfiguration.size()) {
                ftpClient.setConfiguration(ftpConfiguration.get(id));
                model.addAttribute("title", "Бэкапирование на сервере "+ftpConfiguration.get(id).getHost());
                model.addAttribute("host", ftpConfiguration.get(id).getHost());
                model.addAttribute("result", ftpClient.startCheck());
                return ROOT+"/result";
            }
        return "redirect:"+ROOT;
        }
}
