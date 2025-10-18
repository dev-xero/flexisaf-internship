package github.dev.xero.di.service;

import github.dev.xero.di.dto.UserDto;
import github.dev.xero.di.model.User;
import github.dev.xero.di.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository_, PasswordEncoder passwordEncoder_) {
        userRepository = userRepository_;
        passwordEncoder = passwordEncoder_;
    }

    // Using setter injection for optional dependencies.
    private NotificationService emailService;

    @Autowired
    public void setEmailService(@Qualifier("emailNotificationService") NotificationService emailService_) {
        emailService = emailService_;
    }

    // Field injection here. Although not recommended.
    @Autowired
    @Qualifier("smsNotificationService")
    private NotificationService smsService;

    // Hypothetical sign up.
    public String signUp(UserDto dto) {
        if (userRepository.findByEmail(dto.email()) != null) {
            return "A user with this email already exists.";
        }

        String hashedPassword = passwordEncoder.encode(dto.password());
        User newUser = new User(dto.username(), dto.email(), hashedPassword);

        userRepository.save(newUser);
        if (emailService != null) {
            emailService.notify("Welcome " + newUser.getUsername() + "!");
        }

        smsService.notify("Verification code sent.");

        return "New user registered!";
    }
}
