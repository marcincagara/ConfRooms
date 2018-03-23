package hello.service;

import hello.dto.ConfRoom;
import hello.model.ConfRoomModel;
import hello.repository.ConfRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Transactional
    public List<ConfRoom> getAll(){
        List<ConfRoom> confRooms = new ArrayList<>();
        Iterable<ConfRoomModel> all = confRoomRepository.findAll();
        for(ConfRoomModel confRoomModel : all){
            ConfRoom confRoom =  ConfRoom.builder()
                    .floor(confRoomModel.getFloor())
                    .name(confRoomModel.getName())
                    .hdmi(confRoomModel.isHdmi())
                    .skypeVc(confRoomModel.isSkypeVc())
                    .lan(confRoomModel.isLan())
                    .labels(confRoomModel.isLabels())
                    .remotes(confRoomModel.isRemotes())
                    .instruction(confRoomModel.isInstruction())
                    .comments(confRoomModel.getComments())
                    .build();
            confRooms.add(confRoom);
        }
        return confRooms;
    }

    @Transactional
    public void saveConfRoom(ConfRoom confRoom){
        ConfRoomModel confRoomModel = ConfRoomModel.builder()
                .floor(confRoom.getFloor())
                .name(confRoom.getName())
                .hdmi(confRoom.isHdmi())
                .skypeVc(confRoom.isSkypeVc())
                .lan(confRoom.isLan())
                .labels(confRoom.isLabels())
                .remotes(confRoom.isRemotes())
                .instruction(confRoom.isInstruction())
                .comments(confRoom.getComments())
                .build();
        confRoomRepository.save(confRoomModel);
    }

    @Transactional
    public void deleteConfRoom(int id) {
        confRoomRepository.deleteById(id);
    }

    @Transactional
    public Optional<ConfRoom> getConfRoom(int id) {
        Optional<ConfRoomModel> byId = confRoomRepository.findById(id);
        return byId.map(conf->ConfRoom.builder()
                .floor(conf.getFloor())
                .name(conf.getName())
                .hdmi(conf.isHdmi())
                .skypeVc(conf.isSkypeVc())
                .lan(conf.isLan())
                .labels(conf.isLabels())
                .remotes(conf.isRemotes())
                .instruction(conf.isInstruction())
                .comments(conf.getComments())
                .build());
    }
}
