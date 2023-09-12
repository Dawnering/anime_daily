package com.example.ad.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ad.entity.CalendarEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalendarDao extends BaseMapper<CalendarEntity> {
}
