package co.usa.ciclo3.reto3.repository;

import co.usa.ciclo3.reto3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import co.usa.ciclo3.reto3.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    ///Trae todos los elementos que están en la base de datos
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
        ///Trae las categorías
    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    ///Guarda las categorías
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    
    ///Borrar una categoría
    public void delete(Category c){
        categoryCrudRepository.delete(c);
        
    }
}
