package hello.service;
import hello.model.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ConfRoomRepository;
import hello.model.ConfRoomModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HelloService {

   // private ConfRoomRepository confRoomRepository;

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    public HelloService(ConfRoomRepository confRoomRepository) {
        this.confRoomRepository = confRoomRepository;
    }*/

  /*@Transactional
    public List<ConfRoomModel> getAll(){
        List<ConfRoomModel> confRoomModel = new ArrayList<>();
                confRoomRepository.findAll().forEach(confRoomModel1 -> confRoomModel.add(confRoomModel1));
        return confRoomModel;
    }*/

    /*@Transactional
    public void saveConfRoom(ConfRoomModel confRoomModel){
        confRoomRepository.save(confRoomModel);
    }

    @Transactional
    public void deleteConfRoom(int id) {
      confRoomRepository.deleteById(id);
    }

    @Transactional
    public Optional<ConfRoomModel> getConfRoom(int id) {
        return confRoomRepository.findById(id);
    }*/

    @Transactional
    public void saveUser(User user) {
      userRepository.save(user);
    }

    @Transactional
    public List<User> getUser() {
      List<User> users = new ArrayList<>();
      userRepository.findAll().forEach(user -> users.add(user));
      return users;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getSingleUser(int id) {
     return userRepository.findById(id);
    }
}
