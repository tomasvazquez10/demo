package com.emergentes.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/demo")
public class Controller {

    @RequestMapping("/test")
    public ResponseEntity<String> getTest(){
        return new ResponseEntity<>("Demo test", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public ResponseEntity<String> saveData(@RequestBody String data){
        System.out.println("Dato enviado: "+data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
