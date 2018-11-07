package com.mydigicode.repository;

import com.google.firebase.database.DatabaseReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FirebaseRepository {

    @Autowired
    DatabaseReference databaseReference;

    public void updateParam(String data){

        DatabaseReference dataRef = databaseReference.child("param");

        Map<String, String> users = new HashMap<>();
        users.put("param", data);

        dataRef.setValueAsync(data);
    }


}
