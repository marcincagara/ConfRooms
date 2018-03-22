package hello.service;
import hello.model.UserAs;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.HelloDao;
import hello.model.ConfRoomModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HelloService {

    private HelloDao helloDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public HelloService(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

  /*  public Person getPerson(String name) {
        ConfRoomModel person = helloDao.findById(name)
                .orElse(null);


        Person result = new Person(person.getName());
        return result;
    }*/

  @Transactional
    public List<ConfRoomModel> getAll(){
        List<ConfRoomModel> confRoomModel = new ArrayList<>();
                helloDao.findAll().forEach(confRoomModel1 -> confRoomModel.add(confRoomModel1));
        return confRoomModel;
    }

    @Transactional
    public void saveConfRoom(ConfRoomModel confRoomModel){
        helloDao.save(confRoomModel);
    }

    @Transactional
    public void deleteConfRoom(int id) {
      helloDao.deleteById(id);
    }

    @Transactional
    public Optional<ConfRoomModel> getConfRoom(int id) {
        return helloDao.findById(id);
    }

    @Transactional
    public void saveUser(UserAs user) {
      userRepository.save(user);
    }
    @Transactional
    public List<UserAs> getUser() {
      List<UserAs> users = new ArrayList<>();
      userRepository.findAll().forEach(userAs -> users.add(userAs));
      return users;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Optional<UserAs> getSingleUser(int id) {
     return userRepository.findById(id);
    }
}
