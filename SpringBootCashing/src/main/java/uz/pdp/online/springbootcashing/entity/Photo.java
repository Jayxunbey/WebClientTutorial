package uz.pdp.online.springbootcashing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    @Id
    private Integer id;
    private int albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
}
