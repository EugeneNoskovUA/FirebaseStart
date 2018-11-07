package com.mydigicode.listeners;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ParamListener implements ValueEventListener {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.getValue() instanceof Map){
            Map<String, String> document = (Map<String, String>) dataSnapshot.getValue();
            System.out.println(document.get("param"));
        }else{
            System.out.println(dataSnapshot);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
    }
}
