package charityorganization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/start")
public class simpleController {

    @GetMapping("/get")
    public String start() {
        return "application start";
    }
}
