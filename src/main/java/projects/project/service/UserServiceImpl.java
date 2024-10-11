package projects.project.service;

import org.springframework.stereotype.Service;
import projects.project.model.User;
import projects.project.repository.UserRepository;
import projects.project.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        UserDTO user =  UserDTO.toDTO(userRepository.getReferenceById(id));
        System.out.println(user+" trovato!");
        return user;
    }

    @Override
    public List<UserDTO> getUsersByNomeCognome(String nome, String cognome) {
        return userRepository.findAllByNomeAndCognome(nome, cognome).stream().map(UserDTO::toDTO).collect(Collectors.toList());
    }
}
