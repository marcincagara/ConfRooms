package hello.controller;

import hello.dto.ConfRoom;
import hello.model.ConfRoomModel;
import hello.model.User;
import hello.service.ConfRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import hello.service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConfRoomService confRoomService;

    @GetMapping("/admin")
    public String adminPanel(){
        return "admin-panel";
    }

    @GetMapping("/confRoomPanel")
    public String confRoomPanel(){
        return "conf-room-panel";
    }

    @GetMapping("/userPanel")
    public String userPanel(){
        return "user-panel";
    }


    @GetMapping("/confRoomList")
    public String listConfRooms(Model model){
        List<ConfRoomModel> allConfs = confRoomService.getAllConfs();
        allConfs.sort(Comparator.comparingInt(ConfRoomModel::getFloor));
        model.addAttribute("confRoomModel", allConfs);
        return "confRoomList";
    }

    @GetMapping("/confRoomList/{floor}")
    public String listConfRoomsFromFloor(Model model, @PathVariable("floor") int floor){
        List<ConfRoomModel> allConfs = confRoomService.getConfsFromFloor(floor);
        model.addAttribute("confRoomModel", allConfs);
        return "confRoomList";
    }

/*    @GetMapping("/confRoomlist")
    public String listConfRooms(Model model){
        List<ConfRoom> all = confRoomService.getAll();
        model.addAttribute("confRoomModel", all);
        return "confRoomList";
    }*/

    @GetMapping("/saveConf")
    public String showSaveConfRoom(Model model){
        ConfRoomModel confRoomModel = new ConfRoomModel();
        model.addAttribute("confRoom",confRoomModel);
        return "save-confRoom";
    }
    @PostMapping("save")
    public String saveConfRoom(@ModelAttribute("confRoom") ConfRoom confRoom){
        confRoomService.saveConfRoom(confRoom);
        return "redirect:/conf/list";
    }

    @GetMapping("/delete")
    public String deleteConfRoom(@RequestParam("confRoomId") int id){
        confRoomService.deleteConfRoom(id);
        return "redirect:/conf/list";
    }

    @GetMapping("/update")
    public String updateCOnfRoom(@RequestParam("confRoomId") int id, Model model){
        Optional<ConfRoom> confRoom = confRoomService.getConfRoom(id);
        model.addAttribute("confRoom",confRoom);
        return "save-confRoom";
    }

    @GetMapping("/saveUser")
    public String showSaveUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "save-user";
    }

    @PostMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/conf/showUser";
    }

    @GetMapping("/showUser")
    public String showUser(Model model){
      List<User> users = userService.getUser();
      model.addAttribute("userList",users);
        return "user-list";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id){
        userService.deleteUser(id);
        return "redirect:/conf/showUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model){
       Optional<User> user =  userService.getSingleUser(id);
       model.addAttribute("user",user);
        return "save-user";
    }
}
