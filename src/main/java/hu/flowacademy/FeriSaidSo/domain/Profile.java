package hu.flowacademy.FeriSaidSo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profile")
@Data
@EqualsAndHashCode(callSuper = false, exclude = {"articles", "comments"})
public class Profile extends User {

    @Column
    private boolean following;

    @JsonIgnore
    @OneToMany(mappedBy = "author", targetEntity = Article.class, cascade = CascadeType.ALL)
    private Set<Article> articles;

    @JsonIgnore
    @OneToMany(mappedBy = "author", targetEntity = Comment.class, cascade = CascadeType.ALL)
    private Set<Comment> comments;
}
