package charityorganization.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8080")

@RestController
@RequestMapping("/start")
public class simpleController {

    @GetMapping("/get")
    public String start() {
        return "application start";
    }
}

