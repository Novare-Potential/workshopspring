package com.novare.workshopspring.dao;

import com.novare.workshopspring.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements IUserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String sql = "FROM User as u";
        List<User> userList = (List<User>) entityManager.createQuery(sql).getResultList();
        return userList;
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User register(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User update(long id, User user) {
        User currentUser = get(id);
        if (currentUser == null) {
            return null;
        }
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delete(long id) {
        User user = get(id);
        entityManager.remove(user);
    }
}
