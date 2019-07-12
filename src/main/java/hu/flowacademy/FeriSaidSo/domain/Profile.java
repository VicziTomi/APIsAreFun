package hu.flowacademy.FeriSaidSo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profile")
@Data
public class Profile {

    @OneToOne(mappedBy = "profile")
    private User user;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String username;

    @Column
    private String bio;

    @Column
    private String image;

    @Column
    private boolean following;

    @JsonIgnore
    @OneToMany(mappedBy = "author", targetEntity = Article.class, cascade = CascadeType.ALL)
    private Set<Article> articles;

    @JsonIgnore
    @OneToMany(mappedBy = "author", targetEntity = Comment.class, cascade = CascadeType.ALL)
    private Set<Comment> comments;
}
