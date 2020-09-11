package cn.edu.buaa.myblog.service.impl;

import cn.edu.buaa.myblog.dao.AdminUserMapper;
import cn.edu.buaa.myblog.entity.AdminUser;
import cn.edu.buaa.myblog.service.AdminUserService;
import cn.edu.buaa.myblog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {


    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password,"UTF-8");
        return adminUserMapper.login(userName,passwordMd5);
    }
}
