package hello.controller;

import hello.model.ConfRoomModel;
import hello.model.UserAs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import hello.service.HelloService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/conf")
public class AdminController {

    @Autowired
    private HelloService helloService;

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

    @GetMapping("/list")
    public String listCustomers(Model model){
        List<ConfRoomModel> customers = helloService.getAll();
        model.addAttribute("confRoomModel", customers);
        return "confRoomList";
    }

    @GetMapping("/saveConf")
    public String showSaveConfRoom(Model model){
        ConfRoomModel confRoomModel = new ConfRoomModel();
        model.addAttribute("confRoom",confRoomModel);
        return "save-confRoom";
    }
    @PostMapping("save")
    public String saveConfRoom(@ModelAttribute("confRoom") ConfRoomModel confRoomModel){
        helloService.saveConfRoom(confRoomModel);
        return "redirect:/conf/list";
    }

    @GetMapping("/delete")
    public String deleteConfRoom(@RequestParam("confRoomId") int id){
        helloService.deleteConfRoom(id);
        return "redirect:/conf/list";
    }

    @GetMapping("/update")
    public String updateCOnfRoom(@RequestParam("confRoomId") int id, Model model){
        Optional<ConfRoomModel> confRoomModel = helloService.getConfRoom(id);
        model.addAttribute("confRoom",confRoomModel);
        return "save-confRoom";
    }

    @GetMapping("/saveUser")
    public String showSaveUser(Model model){
        UserAs user = new UserAs();
        model.addAttribute("user",user);
        return "save-user";
    }

    @PostMapping("saveUser")
    public String saveUser(@ModelAttribute("user") UserAs user){
        helloService.saveUser(user);
        return "redirect:/conf/showUser";
    }

    @GetMapping("/showUser")
    public String showUser(Model model){
      List<UserAs> users = helloService.getUser();
      model.addAttribute("userList",users);
        return "user-list";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id){
        helloService.deleteUser(id);
        return "redirect:/conf/showUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model){
       Optional<UserAs> user =  helloService.getSingleUser(id);
       model.addAttribute("user",user);
        return "save-user";
    }
}
