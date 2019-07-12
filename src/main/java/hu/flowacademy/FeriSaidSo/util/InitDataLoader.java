package hu.flowacademy.FeriSaidSo.util;

import hu.flowacademy.FeriSaidSo.domain.*;
import hu.flowacademy.FeriSaidSo.repository.ArticleRepository;
import hu.flowacademy.FeriSaidSo.repository.CommentRepository;
import hu.flowacademy.FeriSaidSo.repository.ProfileRepository;
import hu.flowacademy.FeriSaidSo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.EnumSet;

@Component
@Transactional
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) {

        User user = new User();
        user.setBio("I work at statefarm");
        user.setEmail("jake@jake.jake");
        user.setToken("jwt.token.here");
        user.setUsername("jake");

        Profile profile = new Profile();
        profile.setFollowing(false);
        profile.setUsername(user.getUsername());
        profile.setBio(user.getBio());
        profile.setImage(user.getImage());
        user.setProfile(profile);

        Article article = new Article();
        article.setSlug("how-to-train-your-dragon");
        article.setTitle("How to train your dragon");
        article.setDescription("Ever wonder how?");
        article.setBody("It takes a Jacobian");
        article.setTagList(EnumSet.of(Tag.DRAGONS, Tag.TRAINING));
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());
        article.setFavorited(false);
        article.setFavoritesCount(0);
        article.setAuthor(profile);

        Comment comment = new Comment();
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        comment.setBody("It takes a Jacobian");
        comment.setAuthor(profile);

        userRepository.save(user);
        profileRepository.save(profile);
        articleRepository.save(article);
        commentRepository.save(comment);
    }
}
