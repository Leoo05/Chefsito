package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Keep_Repository extends JpaRepository<Entities.Keep,Entities.User> {
}