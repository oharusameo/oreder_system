package com.quxue.orderSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.quxue.orderSystem.mapper.MenuMapper;
import com.quxue.orderSystem.pojo.Menu;
import com.quxue.orderSystem.service.MenuService;
import com.quxue.orderSystem.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    @Override
    public List<MenuVo> selectMenuByRole(Integer role) {
        QueryWrapper<Integer> wrapper = new QueryWrapper<>();
        wrapper.eq("ut.user_role", role);
        List<Menu> list = menuMapper.queryByRole(wrapper);
        List<MenuVo> menuVos = new ArrayList<>();
        return recurMenu(list,menuVos);
    }

    private List<MenuVo> recurMenu(List<Menu> list,List<MenuVo> menuVos) {
        for (Menu menu : list) {
            Integer parentId = menu.getParentId();
            if (parentId == 0) { //如果菜单parentId为0，则为父级菜单
                Integer parentMenuId = menu.getMenuId();
                MenuVo parentMenu = new MenuVo();
                parentMenu.setId(menu.getMenuId());
                parentMenu.setLabel(menu.getMenuName());

                //循环添加子菜单
                for (Menu subs : list) {
                    if (Objects.equals(subs.getParentId(), parentMenuId)) {
                        MenuVo subMenu = new MenuVo();
                        subMenu.setId(subs.getMenuId());
                        subMenu.setLabel(subs.getMenuName());
                        subMenu.setUrl(subs.getUrl());
                        parentMenu.getChildren().add(subMenu);//在父菜单下添加子菜单对象
                    }
                }
                menuVos.add(parentMenu);
            }

            if (list.remove(menu)) {//每次递归将菜单对象从list里移除，如果移除返回false,则遍历完成
                recurMenu(list, menuVos);
            }
            return menuVos;
//            if (Objects.requireNonNull(parentMenu).getChildren() == null) {
//                return menuVos;
//            }
//            list.remove(menu);
//            recurMenu(list);
        }
        return null;
    }
}


