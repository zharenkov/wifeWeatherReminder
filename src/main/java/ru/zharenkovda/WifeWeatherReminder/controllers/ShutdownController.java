package ru.zharenkovda.WifeWeatherReminder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zharenkovda.WifeWeatherReminder.services.SchedulerService;

@RestController
@EnableAutoConfiguration
public class ShutdownController {
    @Autowired
    private SchedulerService schedulerService;

    @RequestMapping("/stop")
    public String stopAll(){
        schedulerService.stopExecutorService();
        return "Scheduler is stopped";
    }

    @RequestMapping("/start")
    public String startService(){
        schedulerService.startExecitorServiceAfterStop();
        return "Scheduler rerunned";
    }
}