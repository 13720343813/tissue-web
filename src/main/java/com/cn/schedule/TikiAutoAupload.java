package com.cn.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TikiAutoAupload {
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void auto() throws IOException {
        System.out.println("this is test tiki auto....");
        String commond = "curl \"http://192.168.0.79:81/authenticate/runScript?type=tiki.AutoUpLoadTikiTrackNumbers\"";
        Process process = Runtime.getRuntime().exec(commond);
    }
}
