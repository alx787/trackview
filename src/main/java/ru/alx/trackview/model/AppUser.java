package ru.alx.trackview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "trackviewdb")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    // в качестве имени пользователя используется email
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String description;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appuser")
    private List<Human> humans;

    // чтобы получить конструктор избранных полей через ломбок
    // нужно ставить аннотацию класса @RequiredArgsConstructor
    // и нужно помечать поля @NonNull
    // напишу конструктор так
    public AppUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", humans=" + humans +
                '}';
    }
}
