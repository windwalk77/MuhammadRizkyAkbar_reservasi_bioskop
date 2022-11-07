package org.binar.challenge4_bejava.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

@Configuration
public class FirebaseConfig {


        Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);


    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("firebase-account.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .setDatabaseUrl("https://bioskopapp-a28ba-default-rtdb.firebaseio.com")
                .build();
        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions);
        logger.info("Firebase Berhasil Inisiasi");
        return FirebaseMessaging.getInstance(app);
    }

}

