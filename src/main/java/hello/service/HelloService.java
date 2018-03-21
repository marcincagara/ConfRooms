package hello.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.dao.HelloDao;
import hello.model.ConfRoomModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HelloService {

    private HelloDao helloDao;

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
        List<ConfRoomModel> confRoomModel = (List<ConfRoomModel>) helloDao.findAll();
        System.out.println(confRoomModel.size());
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
}
