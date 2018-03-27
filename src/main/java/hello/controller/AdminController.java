package hello.controller;

import hello.model.ConfRoomModel;
import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import hello.service.ConfRoomService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class AdminController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @Autowired
    private ConfRoomService confRoomService;

    @Autowired
    private UserService userService;

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
        List<ConfRoomModel> customers = confRoomService.getAll();
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
        confRoomService.saveConfRoom(confRoomModel);
        return "redirect:/list";
    }

    @DeleteMapping("/delete")
    public String deleteConfRoom(@RequestParam("confRoomId") int id){
        confRoomService.deleteConfRoom(id);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String updateCOnfRoom(@RequestParam("confRoomId") int id, Model model){
        Optional<ConfRoomModel> confRoomModel = confRoomService.getConfRoom(id);
        model.addAttribute("confRoom",confRoomModel);
        return "save-confRoom";
    }

    @GetMapping("/saveUser")
    public String showSaveUser(Model model){

        User user = new User();
        model.addAttribute("user",user);
        return "save-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid@ModelAttribute("user") User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "save-user";
        }
        userService.saveUser(user);
        return "redirect:/showUser";
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
        return "redirect:/showUser";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model){
       Optional<User> user =  userService.getSingleUser(id);
       model.addAttribute("user",user);
        return "save-user";
    }
}
