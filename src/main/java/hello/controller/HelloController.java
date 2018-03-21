package hello.controller;

import hello.model.ConfRoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class HelloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping("/{id}")
    public ConfRoomModel getPerson(@PathVariable("id") Integer id) {
        System.out.println(helloService.getConfRoom(id));
        return helloService.getConfRoom(id);
    }

    @RequestMapping("/a")
    public String d(Model  model){
        System.out.println("saas");
        return "aaa";
    }

    @RequestMapping("/b")
    public List<ConfRoomModel> sa(){
        return helloService.getAll();
    }
    @GetMapping("/list")
    public String listCustomers(Model model){
        List<ConfRoomModel> customers = helloService.getAll();
        model.addAttribute("confRoomModel", customers);

        return "aaa";
    }
}
