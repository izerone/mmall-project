package site.izerone.mmall.controller.backend;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.web.bind.annotation.RequestParam;
import site.izerone.mmall.common.Const;
import site.izerone.mmall.common.ResponseCode;
import site.izerone.mmall.common.ServerResponse;
import site.izerone.mmall.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * 分类管理模块
 *
 * @author izerone
 * @version 1.0
 */
public class CategoryManagerController {

    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
        }
        return null;
    }
}
