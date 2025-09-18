package cl.cachoza.web001.repository;

import cl.cachoza.web001.entity.WpUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WpUserRepository extends JpaRepository<WpUserEntity, Long> {
    
    Optional<WpUserEntity> findById(Long id);
    
    Optional<WpUserEntity> findByUserLogin(String userLogin);
    
    Optional<WpUserEntity> findByUserEmail(String userEmail);
    
    boolean existsByUserLogin(String userLogin);
    
    boolean existsByUserEmail(String userEmail);
    
    void deleteById(Long id);
    
    boolean existsById(Long id);
}