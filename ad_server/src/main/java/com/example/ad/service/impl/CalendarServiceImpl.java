package com.example.ad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ad.dao.CalendarDao;
import com.example.ad.entity.CalendarEntity;
import com.example.ad.service.CalendarService;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl extends ServiceImpl<CalendarDao, CalendarEntity> implements CalendarService {
}
