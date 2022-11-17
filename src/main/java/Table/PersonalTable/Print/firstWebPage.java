package Table.PersonalTable.Print;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class firstWebPage {
    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello world");
        return "Hello";
    }
}
