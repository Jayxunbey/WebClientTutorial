package uz.pdp.online.springbootcashing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.online.springbootcashing.entity.Photo;
import uz.pdp.online.springbootcashing.service.PhotoService;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("api/photo")
//@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;
    private final CacheManager cacheManager;

//    @Autowired
    public PhotoController(PhotoService photoService, CacheManager cacheManager) {
        this.photoService = photoService;
        this.cacheManager = cacheManager;
    }
//    private final ConcurrentHashMap<Integer, Photo> photoMap = new ConcurrentHashMap<>();

    @GetMapping("getAll")
    public ResponseEntity<List<Photo>> getAll() {

        List<Photo> all = photoService.getAll();


        return ResponseEntity.ok(all);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getById(@PathVariable Integer id) throws InterruptedException {

        Cache photos = cacheManager.getCache("photos");

        Photo photo = photos.get(id, Photo.class);

        if (photo == null) {
            photo = photoService.getById(id);
            photos.put(id, photo);
        }

        return ResponseEntity.ok(photo);
    }

    @GetMapping("/update")
    public ResponseEntity<String> updateById(@RequestBody Photo photo) throws InterruptedException {

        if (!photoService.update(photo)) {
            ResponseEntity.badRequest().body("Something went wrong");
        }

//        photoMap.put(photo.getId(), photo);

        return ResponseEntity.ok("Successfully updated photo");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) throws InterruptedException {

        photoService.deleteById(id);

//        photoMap.remove(id);
        return ResponseEntity.ok("Succesfully");

    }

}
