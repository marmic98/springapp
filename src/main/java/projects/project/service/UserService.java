package projects.project.service;

import projects.project.model.User;
import projects.project.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<UserDTO> getAllUsers();
    User getUserByEmail(String email);
    UserDTO getUserById(Integer id);
    List<UserDTO> getUsersByNomeCognome(String nome, String cognome);

}
