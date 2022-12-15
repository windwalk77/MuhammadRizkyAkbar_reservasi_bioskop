package com.binar.schedules.configs;

import com.binar.schedules.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Quartz {

    @Autowired
    private ScheduleService scheduleService;
    @Scheduled(cron = "0 8 * * * ?")
    public void everyDay() {
        System.out.println("Schedule: " + scheduleService.findAll());
    }


}
