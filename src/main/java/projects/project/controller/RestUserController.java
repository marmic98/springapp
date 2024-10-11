package projects.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.project.model.User;
import projects.project.service.UserService;
import projects.project.service.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity< List<UserDTO> > getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        if (users == null || users.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);//saveUser restituisce l'utente salvato con l'id messo dal db!
        if(savedUser == null)
            return new ResponseEntity<>("Salvataggio non avvenuto", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>("Utente salvato con successo con id "+savedUser.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        UserDTO user = userService.getUserById(id);
        if (user == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getUser/{nome}-{cognome}")
    public ResponseEntity<List<UserDTO>> getUserByNomeCognome(@PathVariable String nome, @PathVariable String cognome){
        List<UserDTO> user = userService.getUsersByNomeCognome(nome, cognome);
        if (user == null || user.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
