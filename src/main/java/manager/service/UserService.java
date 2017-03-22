package manager.service;

import core.dao.Dao;
import core.service.BaseService;
import core.service.serviceImpl.BaseServiceImpl;
import core.unionkey.UpLoadKey;
import core.util.StringUtil;
import manager.dao.UserDao;
import manager.entity.Knowledge;
import manager.entity.KnowledgeUpLoad;
import manager.entity.User;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhangheng on 2017/2/24.
 */
@Service
public class UserService extends BaseServiceImpl<User> {

    UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        this.dao = userDao;
    }
    public User login(String name, String password) throws Exception {
        User user = getByUserName(name);
        if (!Objects.equals(password,user.getPassword())){
            throw new Exception("用户名或密码不正确");
        }
        return user;
    }
    @Transactional
    public User getByUserName(String name) throws Exception {
        if (StringUtil.isEmpty(name)){
            return null;
        }
        List<User> users = userDao.getEntityByPropName("username",name);
        if (!users.isEmpty()) {
            return (User) users.get(0);
        }
        else
            return null;
    }


}
