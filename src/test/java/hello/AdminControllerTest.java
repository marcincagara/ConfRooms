package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import hello.controller.AdminController;
import hello.dto.ConfRoom;
import hello.repository.ConfRoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    private AdminController adminController;


    @Mock
    private ConfRoomRepository confRoomRepository;

    @Before
    public void setUp(){
        initMocks(this);
        AdminController adminController = new AdminController();
    }

    @Test
    public void shouldRetunConfRoom() {
        //ConfRoom ecpected = new ConfRoom(...);

        //Mockito.when(confRoomRepository)

        //ConfRoom actual = new ConfRoom(...)
    }

}
