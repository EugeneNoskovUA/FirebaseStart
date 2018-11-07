package com.mydigicode.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import com.mydigicode.listeners.ParamListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class AppConfiguration {


    @Autowired
    ParamListener paramListener;


    //fir-start-aed97
    @Bean
    public DatabaseReference databaseReference(){
        // Initialize Firebase
        try {
            FileInputStream serviceAccount = new FileInputStream("service-account.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://fir-start-aed97.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.out.println("ERROR: invalid service account credentials. See README.");
            System.out.println(e.getMessage());

            System.exit(1);
        }

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("/param");

        databaseReference.addValueEventListener(paramListener);

        // Shared Database reference
        return databaseReference;
    }

//    @Bean
//    public DatabaseReference foo(@Qualifier("databaseReference") DatabaseReference databaseReference) {
//        return FirebaseDatabase.getInstance().getReference("/param");
//    }



}
