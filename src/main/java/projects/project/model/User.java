package projects.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cognome;
    private String email;
    private String psw;

    public User(/*Integer id,*/ String nome, String cognome, String email, String psw){
        //this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.psw = psw;
    }

    public User(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    @Override
    public String toString(){
        return "User: "+
                "id: "+id+
                " nome: "+nome+
                " cognome: "+cognome+
                " email: "+email+
                " psw: ***";
    }
}
