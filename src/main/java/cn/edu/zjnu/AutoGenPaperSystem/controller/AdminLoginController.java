package cn.edu.zjnu.AutoGenPaperSystem.controller;

import cn.edu.zjnu.AutoGenPaperSystem.model.Admin;
import cn.edu.zjnu.AutoGenPaperSystem.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by zseapeng on 2016/11/24.
 */
@Controller
@SessionAttributes("adminpassword")
@RequestMapping("/api/admin")
public class AdminLoginController {

    @Resource
    private AdminService adminServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    @ResponseBody
    public Object Login(HttpSession session, ModelMap model, String username,
                        String password) {
        Admin admin = adminServiceImpl.selectByadminName(username);
        if (admin == null) {

            return "{\"error\":" + "\"username\"}";
        }
        if (!admin.getAdminpassword().equals(password)) {
            return "{\"error\":" + "\"password\"}";
        }
        //model.put("adminpassword", password);
        session.setAttribute("adminpassword", password);

        return "{\"username\":" + "\"" + admin.getAdminname() + "\"}";

    }

}
