package uz.pdp.online.webclienttutormain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Todo {
    @Id
    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
