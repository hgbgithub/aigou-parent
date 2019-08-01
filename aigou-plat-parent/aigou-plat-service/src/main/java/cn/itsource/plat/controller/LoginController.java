package cn.itsource.plat.controller;

import cn.itsource.domain.User;
import cn.itsource.util.AjaxResult;
import org.bouncycastle.cms.RecipientId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    //@RequestBody 接收前台json体形式的请求参数封装到实体类对象中
    public AjaxResult login(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();

        if("admin".equals(username)&&"admin".equals(password)){
            return AjaxResult.getAjaxResult().setSuccess(true).setMessage("登录成功").setResultObj(user);
        }
        return AjaxResult.getAjaxResult().setSuccess(false).setMessage("登录失败");
    }

}
