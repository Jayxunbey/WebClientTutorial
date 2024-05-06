package uz.pdp.online.webclienttutormain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.online.webclienttutormain.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
