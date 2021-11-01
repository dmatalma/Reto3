package com.g09.reto3.service.impl;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Category;
import com.g09.reto3.repository.CategoryRepository;
import com.g09.reto3.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findOne(Long id){
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean delete(Long id){
        Optional<Category> category=findOne(id);
            if(!category.isEmpty()){
                categoryRepository.delete(category.get());
                return true;        
            }
            return false;
        }
   /* public void delete(Long id){
        Optional<Category> category= findOne(id);
        if(category.isPresent()){
            categoryRepository.delete(category.get());
        }
    }*/

    @Override
    public Category update(Category category){
        if(category.getId()!=null){
        Optional<Category> cat= categoryRepository.findById(category.getId());

            if(!cat.isEmpty()){
                if(category.getDescription()!=null){
                  cat.get().setDescription(category.getDescription());
                } 
                
                if( category.getName()!=null){
                  cat.get().setName(category.getName());
                }

                if(category.getSkates()!=null){
                  cat.get().setSkates(category.getSkates());
                }

                categoryRepository.save(cat.get());
                return cat.get();
                
            } else{
                return category;
            }
        }else{
            return category;
        }
     }
     
}
