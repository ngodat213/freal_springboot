package com.example.frealsb.Auth;

import com.example.frealsb.Entities.User;
import com.example.frealsb.Services.UserService;
import com.example.frealsb.Util.EncryptionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ChangePasswordTests {
    @Autowired
    private UserService userService;

    @Test
    public void testChangePassword() {
        User user = new User();
        user.setId("bc406b62-6a63-4a84-b232-a60a190f5651");
        user.setAvatarPublicId("Freal/public/zmhc6q9km7psp7eymp8w");
        user.setEnabled(true);
        user.setFirstName("Hydra");
        user.setLastName("Coder");
        user.setEmail("ngodat.it213@gmail.com");
        user.setPassword("$2a$10$SSQ/sniHbClkoKLTR/ZeYuyHgvz4Rn2nEQnd44sBzOtvwyca8CT3q");

        String newPassword = "Code26102003#!@";
        user.setPassword(EncryptionUtils.PasswordEncoder(newPassword));

    }
}
