package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    User findById(int id);


    List<User> getAll();

    void update(int id, User user);

    void delete(int id);
}
