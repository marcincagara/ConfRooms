package hello.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.dao.HelloDao;
import hello.model.ConfRoomModel;
import java.util.List;

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

    public ConfRoomModel getConfRoom(int id){
       ConfRoomModel confRoomModel = helloDao.findById(id)
            .orElse(null);

       return confRoomModel;
    }

    public List<ConfRoomModel> getAll(){
        List<ConfRoomModel> confRoomModel = (List<ConfRoomModel>) helloDao.findAll();
        System.out.println(confRoomModel.size());
        return confRoomModel;
    }

    public ConfRoomModel test(Integer id){
        ConfRoomModel confRoomModel = helloDao.findById(id)
                .orElse(null);
        return confRoomModel;
    }
}
