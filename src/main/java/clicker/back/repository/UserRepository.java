package clicker.back.repository;

import clicker.back.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUid(String uid);
}

