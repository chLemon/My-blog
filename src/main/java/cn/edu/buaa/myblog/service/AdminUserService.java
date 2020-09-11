package cn.edu.buaa.myblog.service;

import cn.edu.buaa.myblog.entity.AdminUser;

public interface AdminUserService {


    AdminUser login(String userName, String password);
}
