package hello.repository;


import hello.model.User;
import hello.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String username);
    User findById(int id);
}
