package hello.controller;

import hello.model.ConfRoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import hello.service.HelloService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/conf")
public class HelloController {

    @Autowired
    private HelloService helloService;

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
}
