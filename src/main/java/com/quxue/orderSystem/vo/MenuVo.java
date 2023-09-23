package com.quxue.orderSystem.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuVo {
    private Integer id;
    private String label;
    private String url;
    private List<MenuVo> children=new ArrayList<>();
}
