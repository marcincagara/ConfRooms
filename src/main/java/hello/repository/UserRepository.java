package hello.repository;

import hello.model.UserAs;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAs, Integer> {
}
