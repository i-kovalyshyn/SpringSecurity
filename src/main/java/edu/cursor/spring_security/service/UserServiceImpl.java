package edu.cursor.spring_security.service;

import edu.cursor.spring_security.model.Role;
import edu.cursor.spring_security.model.User;
import edu.cursor.spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        userRepository.save(new User(user.getUsername(), user.getEmail(), user.getPassword(), roles));

    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id).isPresent()
                ? userRepository.findById(id) : Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUsername(userName).isPresent()
                ? userRepository.findByUsername(userName) : Optional.empty();
    }

    @Override
    public boolean existsByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

    @Override
    public void deleteByUserName(String userName) {
        userRepository.deleteByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       return userRepository.findByUsername(username).get();
    }
}
