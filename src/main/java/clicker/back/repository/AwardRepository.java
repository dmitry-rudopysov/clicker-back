package clicker.back.repository;

import clicker.back.model.Award;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;

public interface AwardRepository extends MongoRepository<Award, String> {

}
