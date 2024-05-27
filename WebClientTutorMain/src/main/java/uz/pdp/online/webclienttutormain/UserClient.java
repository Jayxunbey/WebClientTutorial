package uz.pdp.online.webclienttutormain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import uz.pdp.online.webclienttutormain.dto.UserDtoResp;
import java.util.List;


@FeignClient(value = "UserClient", url = "https://jsonplaceholder.typicode.com/users")
public interface UserClient {


    @GetMapping
    List<UserDtoResp> getAllUsers();

    @PostMapping(path = "/create-user")
    UserDtoResp createUser(@RequestBody UserDtoResp userDtoResp);

}
