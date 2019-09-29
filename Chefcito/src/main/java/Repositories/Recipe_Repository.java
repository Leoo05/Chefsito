package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Recipe_Repository extends JpaRepository<Entities.Recipe,String> {
}
