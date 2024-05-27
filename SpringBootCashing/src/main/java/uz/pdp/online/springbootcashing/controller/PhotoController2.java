

package uz.pdp.online.springbootcashing.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
        import uz.pdp.online.springbootcashing.entity.Photo;
import uz.pdp.online.springbootcashing.service.PhotoService;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("api/photo2")
@Slf4j
public class PhotoController2 {

    private final PhotoService photoService;

    public PhotoController2(PhotoService photoService, CacheManager cacheManager) {
        this.photoService = photoService;
    }


    @GetMapping("getAll")
    public ResponseEntity<List<Photo>> getAll() {

        List<Photo> all = photoService.getAll();


        return ResponseEntity.ok(all);

    }

    @Cacheable(cacheNames = "photos")
    @GetMapping("/{id}")
    public ResponseEntity<Photo> getById(@PathVariable Integer id) throws InterruptedException {

        Photo byId = photoService.getById(id);

        return ResponseEntity.ok(byId);
    }

    @CachePut(cacheNames = "photos",key = "#photo.id")
    @GetMapping("/update")
    public ResponseEntity<String> updateById(@RequestBody Photo photo) throws InterruptedException {

        if (!photoService.update(photo)) {
            ResponseEntity.badRequest().body("Something went wrong");
        }

        return ResponseEntity.ok("Successfully updated photo");
    }

    @CacheEvict(cacheNames = "photos")
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws InterruptedException {

        photoService.deleteById(id);

        return ResponseEntity.ok("Succesfully");

    }


    @Scheduled(fixedRate = 10000)
                    @CacheEvict(allEntries = true, cacheManager = "cacheManager", cacheNames = "photos")
    public void flushCache() {
        log.info("Flushing cache");
    }


}
