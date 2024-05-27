package uz.pdp.online.mongoprojecttest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.online.mongoprojecttest.entity.User;

public interface UserRepositoryMongo extends MongoRepository<User, String> {
    User findByUsername(String username);
}
