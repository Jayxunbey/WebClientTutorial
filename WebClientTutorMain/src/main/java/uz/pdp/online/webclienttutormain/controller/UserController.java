package uz.pdp.online.webclienttutormain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uz.pdp.online.webclienttutormain.UserClient;
import uz.pdp.online.webclienttutormain.dto.UserDtoResp;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserClient userClient;

    @GetMapping("/all")
    public ResponseEntity<List<UserDtoResp>> getUser() {

        List<UserDtoResp> allUsers = userClient.getAllUsers();

        return ResponseEntity.ok(allUsers);


//
//        RestTemplate restTemplate = new RestTemplate();
//
//
//        ResponseEntity<List<UserDtoResp>> exchange = restTemplate.exchange(
//                "https://jsonplaceholder.typicode.com/users",
//                HttpMethod.GET,
//                HttpEntity.EMPTY,
//                new ParameterizedTypeReference<List<UserDtoResp>>() {
//                }
//        );
//
//        List<UserDtoResp> userDTOList = exchange.getBody();
//        return ResponseEntity.ok(userDTOList);
//    }

}






}
