package cn.edu.buaa.myblog.service;

import cn.edu.buaa.myblog.entity.AdminUser;

public interface AdminUserService {


    AdminUser login(String userName, String password);

    AdminUser getUserDetailById(Integer loginUserId);

    boolean updateName(Integer loginUserId, String loginUserName, String nickName);

    boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);
}
