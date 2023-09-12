package com.example.ad.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "calendar")
public class CalendarEntity {

    @TableId("id")
    private String id;
    @TableField("title")
    private String title;
    @TableField("title_original")
    private String titleOriginal;
    @TableField("score")
    private double score;
    @TableField("week")
    private String week;
    @TableField("update_time")
    private String updateTime;


}
