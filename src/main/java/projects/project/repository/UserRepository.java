package projects.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.project.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    public User findByEmail(String email);

    List<User> findAllByNomeAndCognome(String nome, String cognome);
}
