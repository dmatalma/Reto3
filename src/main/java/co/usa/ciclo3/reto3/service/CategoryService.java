package co.usa.ciclo3.reto3.service;

import co.usa.ciclo3.reto3.model.Category;
import co.usa.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private Boolean other;

    public List<Category> getAll(){
        return  categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(p.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
        }
    }
    
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(c.getId()); ///creo un objeto g y lo traigo
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return c;
    }

        public boolean deletecategory (int id){
            Boolean aBoolean = getCategory(id).map(p -> {
                categoryRepository.delete(p);
                return true;        
            }).orElse(false);
            return aBoolean;

        ///Podría usarse también de esta manera:   
        ///public boolean deleteCategory(int id){
        ///Optional<Category> c=getCategory(id);
        ///if(!c.isEmpty()){
        ///    categoryRepository.delete(c.get());
        ///    return true;        
        ///}
        ///return false;
        }

    public boolean deleteCategory(int categoryid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
