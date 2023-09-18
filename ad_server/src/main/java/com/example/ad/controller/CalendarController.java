package com.example.ad.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ad.common.R;
import com.example.ad.entity.CalendarEntity;
import com.example.ad.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @PostMapping("calendar/get")
    public R<List<CalendarEntity>> getCalendar(){
        QueryWrapper<CalendarEntity> last_up = new QueryWrapper<>();
        last_up.select("update_time").orderByDesc("update_time").last("LIMIT 1");
        String update_time=calendarService.getOne(last_up).getUpdateTime();


        QueryWrapper<CalendarEntity> findByWeek = new QueryWrapper<>();
        findByWeek.eq("update_time",update_time);
        List<CalendarEntity> result=calendarService.list(findByWeek);
        return R.success(result);
    }

}
