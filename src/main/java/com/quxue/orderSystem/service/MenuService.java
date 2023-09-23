package com.quxue.orderSystem.service;

import com.quxue.orderSystem.pojo.Menu;
import com.quxue.orderSystem.vo.MenuVo;

import java.util.List;

public interface MenuService {

    List<MenuVo> selectMenuByRole(Integer role);

}
