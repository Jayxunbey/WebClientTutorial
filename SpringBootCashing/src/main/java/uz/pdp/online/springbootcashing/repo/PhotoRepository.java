package uz.pdp.online.springbootcashing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.online.springbootcashing.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    @Transactional
    @Modifying
    @Query("update Photo p set p.id = ?1, p.albumId = ?2, p.title = ?3, p.url = ?4, p.thumbnailUrl = ?5 where p.id = ?6")
    int updateIdAndAlbumIdAndTitleAndUrlAndThumbnailUrlById(Integer id, int albumId, String title, String url, String thumbnailUrl, Integer id1);

    @Transactional
    @Modifying
    @Query("update Photo p set p.albumId = ?1, p.title = ?2, p.url = ?3, p.thumbnailUrl = ?4 where p.id = ?5")
    int updateAlbumIdAndTitleAndUrlAndThumbnailUrlById(int albumId, String title, String url, String thumbnailUrl, Integer id);
}