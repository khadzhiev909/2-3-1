package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDAO.update(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public User findById(int id) {
        return userDAO.findById(id);
    }


    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
