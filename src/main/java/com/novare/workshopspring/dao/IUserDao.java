package com.novare.workshopspring.dao;

import com.novare.workshopspring.models.User;

import java.util.List;

public interface IUserDao {
    List<User> getAll();
    User get(long id);
    User register(User user);
    User update(long id, User user);
    void delete(long id);
}
