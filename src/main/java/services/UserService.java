package services;

import entities.User;
import repositories.interfaces.IUserRepository;
import services.interfaces.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService implements IUserService {

    @Inject
    private IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.getAll();
        return users;
    }

    @Override
    public boolean create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User get(int id) {
        return userRepository.get(id);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }
}