package com.novare.workshopspring.services;

import com.novare.workshopspring.dao.IUserDao;
import com.novare.workshopspring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserDao iUserDao;

    public List<User> getAll() {
        return iUserDao.getAll();
    }
    public User get(long id) {
        return iUserDao.get(id);
    }

    public User create(User user){
        return iUserDao.register(user);
    }
}
