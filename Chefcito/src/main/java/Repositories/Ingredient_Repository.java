package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ingredient_Repository extends JpaRepository<Entities.Ingredient,String> {

}
