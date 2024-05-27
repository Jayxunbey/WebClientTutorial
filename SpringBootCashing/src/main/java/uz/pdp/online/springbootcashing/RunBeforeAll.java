package uz.pdp.online.springbootcashing;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import uz.pdp.online.springbootcashing.entity.Photo;
import uz.pdp.online.springbootcashing.repo.PhotoRepository;

import java.util.List;

@Configuration
@ComponentScan("uz.pdp.online.springbootcashing.repo")
@RequiredArgsConstructor
public class RunBeforeAll implements CommandLineRunner {

    private final PhotoRepository photoRepository;

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Photo[] forObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", Photo[].class);

//        List<Photo> photos = photoRepository.saveAll(List.of(forObject));
//        photos.forEach(System.out::println);

    }
}



