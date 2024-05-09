package com.emergentes.demo.controller;

import com.emergentes.demo.model.DatoCensado;
import com.emergentes.demo.repository.DatoCensadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/demo")
public class DatoController {

    private final DatoCensadoRepository repository;

    @Autowired
    public DatoController(DatoCensadoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/test")
    public ResponseEntity<String> getTest(){
        return new ResponseEntity<>("Demo test", HttpStatus.OK);
    }

    @RequestMapping("/dato/{id}")
    public ResponseEntity<DatoCensado> getDatoCensado(@PathVariable Long id){
        Optional<DatoCensado> optionalDatoCensado = repository.findById(id);
        return optionalDatoCensado.map(datoCensado -> new ResponseEntity<>(datoCensado, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new DatoCensado(), HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public ResponseEntity<String> saveData(@RequestBody String data){
        System.out.println("Dato enviado: "+data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dato")
    public ResponseEntity<DatoCensado> saveData(@RequestBody DatoCensado dato){
        System.out.println("Dato enviado: "+dato.toString());
        DatoCensado nuevoDato = repository
                .save(dato);
        return new ResponseEntity<>(nuevoDato, HttpStatus.OK);
    }
}
