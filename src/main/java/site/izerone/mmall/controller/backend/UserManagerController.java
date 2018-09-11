package site.izerone.mmall.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.izerone.mmall.common.Const;
import site.izerone.mmall.common.ServerResponse;
import site.izerone.mmall.pojo.User;
import site.izerone.mmall.service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * 用户后台管理
 *
 * @author izerone
 * @version 1.0
 */
@Controller
@RequestMapping("/manage/user")
public class UserManagerController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @param session 会话对象
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if(response.isSuccess()){
            User user = response.getData();
            if (user.getRole() == Const.Role.ROLE_ADMIN) {
                // 说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER, response.getData());
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员，无法登录");
            }
        }
        return response;
    }
}
