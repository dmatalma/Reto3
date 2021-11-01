package com.g09.reto3.service.impl;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Skates;
import com.g09.reto3.repository.SkatesRepository;
import com.g09.reto3.service.SkatesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkatesServiceImpl implements SkatesService{

    @Autowired

    SkatesRepository skatesRepository;

    @Override
    public List<Skates> findAllSkates() {
        return (List<Skates>) skatesRepository.findAll();
    }

    @Override
    public Optional<Skates> findOne(Long id){
        return skatesRepository.findById(id);
    }

    @Override
    public Skates save(Skates skate) {
        return skatesRepository.save(skate);
    }

    @Override
       
        public boolean delete(Long id){
        Optional<Skates> skate=findOne(id);
        if(!skate.isEmpty()){
            skatesRepository.delete(skate.get());
            return true;        
        }
        return false;
        }
    /*public void delete(Long id){
        Optional<Skates> skate= findOne(id);
        if(skate.isPresent()){
            skatesRepository.delete(skate.get());
        }
    }*/

    @Override
    public Skates update(Skates skate){
        if(skate.getId()!=null){
        Optional<Skates> skt= skatesRepository.findById(skate.getId());

            if(!skt.isEmpty()){

                if(skate.getName()!=null){
                    skt.get().setName(skate.getName());
                }

                if(skate.getBrand()!=null){
                    skt.get().setBrand(skate.getBrand());
                }

                if(skate.getYear()!=0){
                    skt.get().setYear(skate.getYear());
                }

                if(skate.getDescription()!=null){
                    skt.get().setDescription(skate.getDescription());
                }

                skatesRepository.save(skt.get());
                return skt.get();
                
            } else{
                return skate;
            }
        }else{
            return skate;
        }
     }
    
}
