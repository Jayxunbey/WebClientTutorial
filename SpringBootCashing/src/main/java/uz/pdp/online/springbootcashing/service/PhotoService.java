package uz.pdp.online.springbootcashing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.online.springbootcashing.entity.Photo;
import uz.pdp.online.springbootcashing.repo.PhotoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    public List<Photo> getAll() {

        return photoRepository.findAll();

    }

    public Photo getById(Integer id) throws InterruptedException {
        Thread.sleep(5000);
        return photoRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        photoRepository.deleteById(id);
    }

    public boolean update(Photo photo) {
        int i = photoRepository.updateAlbumIdAndTitleAndUrlAndThumbnailUrlById(
                photo.getAlbumId(),
                photo.getTitle(),
                photo.getUrl(),
                photo.getThumbnailUrl(),
                photo.getId()
        );
        if (i > 0) {
            return true;
        }
        return false;
    }
}
