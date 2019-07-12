package hu.flowacademy.FeriSaidSo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.EnumSet;

@Entity
@Table(name = "articles")
@Data
@EqualsAndHashCode(exclude = {"author"})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String slug;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String body;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private boolean favorited;

    @Column
    private int favoritesCount;

    @Column
    private EnumSet<Tag> tagList;

    @ManyToOne(targetEntity = Profile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_author", foreignKey = @ForeignKey(name = "fk_articles_profile_username"))
    private Profile author;

}
