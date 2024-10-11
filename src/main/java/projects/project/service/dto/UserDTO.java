package projects.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import projects.project.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String nome;
    private String cognome;
    private String email;

    public static UserDTO toDTO(User user){
        if(user == null)
            return null;
        return new UserDTO(user.getNome(), user.getCognome(), user.getEmail());
    }

    public static User toEntity(UserDTO userDTO){
        if(userDTO == null)
            return null;
        return new User(userDTO.getNome(), userDTO.getCognome(), userDTO.getEmail());
    }

    @Override
    public String toString(){
        return "User: "+
                "nome: "+nome+
                " cognome: "+cognome+
                " email: "+email+
                " psw: ***";
    }
}
