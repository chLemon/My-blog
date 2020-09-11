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
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        return adminUser;
    }

    @Override
    public boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        if (adminUser != null) {
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {

        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        if (adminUser != null) {
            //设置密码并修改
            String originalPasswordMD5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMD5 = MD5Util.MD5Encode(newPassword,"UTF-8");

            if (originalPasswordMD5.equals(adminUser.getLoginPassword())){
                adminUser.setLoginPassword(newPasswordMD5);
                if (adminUserMapper.updateByPrimaryKeySelective(adminUser)>0){
                    return true;
                }

            }
        }

        return false;
    }
}
