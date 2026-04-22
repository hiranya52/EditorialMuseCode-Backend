package edu.icet.service;

import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import edu.icet.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String password) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        return jwtUtil.generateToken(username);
    }

    // REGISTER
    public String register(String username, String password) {

        if (userRepository.findByUsername(username).isPresent()) {
            return "User already exists";
        }

        User user = new User();
        user.setUsername(username);

        // 🔐 IMPORTANT: encode password
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        return "User registered successfully";
    }

}
