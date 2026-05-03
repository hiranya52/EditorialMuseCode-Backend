package edu.icet.service;

import edu.icet.model.entity.User;
import edu.icet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import edu.icet.security.JwtUtil;

import java.util.Optional;

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

//    public String login(String username, String password) {
//
//        authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//        return jwtUtil.generateToken(username);
//    }

    // REGISTER
//    public String register(String username, String password, String requestPassword) {
//
//        if (userRepository.findByUsername(username).isPresent()) {
//            return "User already exists";
//        }
//
//        User user = new User();
//        user.setUsername(username);
//
//        // 🔐 IMPORTANT: encode password
//        user.setPassword(passwordEncoder.encode(password));
//
//        userRepository.save(user);
//
//        return "User registered successfully";
//    }

    public String register(String fullName, String email, String password) {

        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        // ✅ Generate JWT
        return jwtUtil.generateToken(user.getEmail(), user.getId());
    }

}
