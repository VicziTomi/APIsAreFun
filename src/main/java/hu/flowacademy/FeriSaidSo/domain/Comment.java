package hu.flowacademy.FeriSaidSo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@EqualsAndHashCode(exclude = {"author"})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private String body;

    @ManyToOne(targetEntity = Profile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_author", foreignKey = @ForeignKey(name = "fk_comments_profile_username"))
    private Profile author;
}
