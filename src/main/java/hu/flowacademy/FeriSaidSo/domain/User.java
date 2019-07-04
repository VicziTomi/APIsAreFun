package hu.flowacademy.FeriSaidSo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column
    private String token;

    @Column
    private String bio;

    @Column
    private String image;

}
