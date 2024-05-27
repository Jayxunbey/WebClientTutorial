package uz.pdp.online.liquabasetoday.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
@SQLRestriction("enabled = true")
@SQLDelete(sql = "update")
public class User {
    @Id
    private Long id;
    private String username;

    private boolean enabled ;
    private String password;

}
