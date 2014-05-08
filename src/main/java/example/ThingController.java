package example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThingController {
    @RequestMapping("/thing")
    @ResponseBody
    public String thingTwo() {
        return "Hello, Bar";
    }
}
