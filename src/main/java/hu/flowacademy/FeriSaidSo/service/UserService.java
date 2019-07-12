package hu.flowacademy.FeriSaidSo.service;

import hu.flowacademy.FeriSaidSo.domain.User;
import hu.flowacademy.FeriSaidSo.exception.UserNotFoundException;
import hu.flowacademy.FeriSaidSo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String name) {
        return userRepository.findByUsername(name).orElseThrow(UserNotFoundException::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
