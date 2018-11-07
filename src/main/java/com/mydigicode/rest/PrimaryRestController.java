package com.mydigicode.rest;

import com.mydigicode.repository.FirebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrimaryRestController {

    @Autowired
    FirebaseRepository firebaseService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> updateDatabase(
            @RequestParam("param") String paramVal
    ){

        firebaseService.updateParam(paramVal);

        return new ResponseEntity<>("ok", new HttpHeaders(), HttpStatus.OK);
    }

}
