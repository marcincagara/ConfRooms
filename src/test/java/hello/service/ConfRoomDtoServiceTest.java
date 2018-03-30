package hello.service;

import hello.dto.ConfRoomDto;
import hello.model.ConfRoomModel;
import hello.repository.ConfRoomRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class ConfRoomDtoServiceTest {

    @Mock
    private ConfRoomRepository confRoomRepository;

    private ConfRoomService confRoomService;

    @Before
    public void setUp() {
        initMocks(this);
        confRoomService = new ConfRoomService(confRoomRepository);
    }

    @Test
    public void shouldGetConfRoomById() {
        ConfRoomModel expected = getConfRoomModel();
        expected.setId(5);

        ConfRoomModel toSave = getConfRoomModelById(expected,5);

        ConfRoomModel actual = confRoomService.saveConfRoom(toSave);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void shouldGetAllConfRooms() {

    }


    private ConfRoomModel getConfRoomModel() {
        return ConfRoomModel.builder()
                .id(1)
                .name("Kraków")
                .floor(6)
                .skypeVc(true)
                .hdmi(true)
                .lan(true)
                .remotes(true)
                .labels(true)
                .comments("no comment")
                .build();
    }

    private ConfRoomModel getConfRoomModelById(ConfRoomModel confRoomModel, int id) {
        confRoomModel.setId(id);
        return confRoomModel;
    }
}
   /* private ConfRoomModel getConfRoomModelById(int id) {
        ConfRoomModel confRoomModel = new ConfRoomModel();
        confRoomModel.setId(id);
        confRoomModel.setName("Wrocław");
        confRoomModel.setFloor(5);
        confRoomModel.setSkypeVc(false);
        confRoomModel.setHdmi(false);
        confRoomModel.setLan(false);
        confRoomModel.setLabels(false);
        confRoomModel.setComments("comment 1");
        return confRoomModel;
    }*/