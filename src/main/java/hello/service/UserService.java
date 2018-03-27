package hello.service;

import hello.model.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(userAs -> users.add(userAs));
        return users;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getSingleUser(int id) {
        return userRepository.findById(id);
    }
}
