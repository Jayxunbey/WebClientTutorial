package uz.pdp.online.webclienttutormain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import uz.pdp.online.webclienttutormain.dto.TodoDtoResp;
import uz.pdp.online.webclienttutormain.dto.UserDtoResp;
import uz.pdp.online.webclienttutormain.entity.Todo;
import uz.pdp.online.webclienttutormain.repo.TodoRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoContoller {

    private final TodoRepository todoRepository;


    @PostMapping("/users")
    public ResponseEntity<UserDtoResp> createUser(@RequestBody UserDtoResp userDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth("sdgfjgjjhdsdhj6tu6jdgjfsdhjhdjhs/sjd");

        HttpEntity<UserDtoResp> httpEntity = new HttpEntity<>(userDto, httpHeaders);

        ResponseEntity<UserDtoResp> exchange = new RestTemplate()
                .exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.POST, httpEntity, UserDtoResp.class);

        return ResponseEntity.ok(exchange.getBody());

    }



    @GetMapping("/get/user/{userid}")
    public ResponseEntity<List<TodoDtoResp>> getTodos(@PathVariable("userid") Long userid) {
        List<TodoDtoResp> todos = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        List<Todo> byUserId = todoRepository.findByUserId(userid);
        Todo todo = byUserId.get(0);

        ResponseEntity<UserDtoResp> forEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users/" + userid, UserDtoResp.class);
        UserDtoResp body = forEntity.getBody();

        System.out.println("body = " + body);
        System.out.println("todo = " + todo);

        TodoDtoResp todoDto = new TodoDtoResp();

        todoDto.setId(todo.getId());
        todoDto.setTitle(todo.getTitle());
        todoDto.setUser(body);
        todoDto.setCompleted(todo.isCompleted());

        todos.add(todoDto);
        return ResponseEntity.ok().body(todos);
    }






    @GetMapping("/getAll")
    public ResponseEntity<List<TodoDtoResp>> getAll() {

        return ResponseEntity.accepted().body(List.of(new TodoDtoResp()));

    }

}
