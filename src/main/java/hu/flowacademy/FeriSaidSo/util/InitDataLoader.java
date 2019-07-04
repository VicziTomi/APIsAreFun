package hu.flowacademy.FeriSaidSo.util;

import hu.flowacademy.FeriSaidSo.domain.Profile;
import hu.flowacademy.FeriSaidSo.domain.User;
import hu.flowacademy.FeriSaidSo.repository.ProfileRepository;
import hu.flowacademy.FeriSaidSo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setBio("I work at statefarm");
        user.setEmail("jake@jake.jake");
        user.setToken("jwt.token.here");
        user.setUsername("jake");
        userRepository.save(user);

        Profile profile = new Profile();
        profile.setFollowing(false);
        profile.setUsername(user.getUsername());
        profile.setBio(user.getBio());
        profile.setImage(user.getImage());
        profileRepository.save(profile);
    }
}
