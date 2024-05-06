package uz.pdp.online.webclienttutormain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uz.pdp.online.webclienttutormain.dto.TodoDtoResp;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoContoller {


    @GetMapping("/get/user/{userid}")
    public ResponseEntity<List<TodoDtoResp>> getTodos(@PathVariable("userid") String userid) {
        List<TodoDtoResp> todos = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();


    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TodoDtoResp>> getAll() {

        return ResponseEntity.accepted().body(List.of(new TodoDtoResp()));

    }

}
