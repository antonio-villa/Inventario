package com.inventario.repository;

import com.inventario.Entity.Ferreteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryFerreteria extends JpaRepository<Ferreteria, Long> {

    List<Ferreteria> findByNombrepContainingIgnoreCase(String nombrep);
    Optional<Ferreteria> findByNombrep(String nombrep);
    List<Ferreteria>findByCodigo(int codigo);
    Boolean existsByNombrep(String nombrep);
    Boolean existsByCodigo(int codigo);
}
