package com.g09.reto3.controller;

import java.util.List;

import com.g09.reto3.service.SkatesService;
import com.g09.reto3.entity.Skates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@CrossOrigin(origins="*")
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/Skate")
public class SkatesController {
    
    @Autowired
    SkatesService skatesService;

    @GetMapping("/all")
    public List<Skates> findAllSkates(){
        return skatesService.findAllSkates();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Skates create(@RequestBody Skates skate){
        return skatesService.save(skate);
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")Long id){
        return skatesService.delete(id);
    }

    

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Skates update(@RequestBody Skates skate){
        return skatesService.update(skate);
    }

}
