package site.izerone.mmall.service;

import site.izerone.mmall.common.ServerResponse;
import site.izerone.mmall.pojo.User;

/**
 * description
 *
 * @author izerone
 * @version 1.0
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    public ServerResponse<String> register(User user);

    public ServerResponse<String> checkValid(String str, String type);

    public ServerResponse<String> selectQuestion(String username);

    public ServerResponse<String> checkAnswer(String username, String question, String answer);

    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken);

    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    public ServerResponse<User> updateInformation(User user);

    public ServerResponse<User> getInformation(Integer userId);

}
