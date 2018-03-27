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
public class ConfRoomService {

    private ConfRoomRepository confRoomRepository;

    @Autowired
    public ConfRoomService(ConfRoomRepository confRoomRepository) {
        this.confRoomRepository = confRoomRepository;
    }

  /*  public ConfRoom getPerson(String name) {
        ConfRoomModel person = confRoomRepository.findById(name)
                .orElse(null);


        ConfRoom result = new ConfRoom(person.getName());
        return result;
    }*/

  @Transactional
    public List<ConfRoomModel> getAll(){
        List<ConfRoomModel> confRoomModel = new ArrayList<>();
                confRoomRepository.findAll().forEach(confRoomModel1 -> confRoomModel.add(confRoomModel1));
        return confRoomModel;
    }

    @Transactional
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
    }

}
