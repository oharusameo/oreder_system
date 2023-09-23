package com.quxue.orderSystem.controller;

import com.quxue.orderSystem.pojo.Result;
import com.quxue.orderSystem.service.MenuService;
import com.quxue.orderSystem.util.CookieUtil;
import com.quxue.orderSystem.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private MenuService menuService;
    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @RequestMapping("/showMenu.do")
    public Result showMenu(HttpServletRequest req) {
        String role = CookieUtil.getCookieValue(req, "role");
        if (role != null) {
            List<MenuVo> menuVos = menuService.selectMenuByRole(Integer.valueOf(role));
            return Result.success(menuVos);
        }
        return Result.error("我不到啊");
    }


}
