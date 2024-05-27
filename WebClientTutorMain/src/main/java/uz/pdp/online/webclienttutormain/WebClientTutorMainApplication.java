package uz.pdp.online.webclienttutormain;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import uz.pdp.online.webclienttutormain.entity.Todo;
import uz.pdp.online.webclienttutormain.repo.TodoRepository;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class WebClientTutorMainApplication {
    private final TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebClientTutorMainApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args ->{
            Todo[] object = new RestTemplate().getForObject(
                    "https://jsonplaceholder.typicode.com/todos", Todo[].class);

            todoRepository.saveAll(List.of(object));
        };
    }

}
