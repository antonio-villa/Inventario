package com.inventario.repository;

import com.inventario.Entity.Materiales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryProducto extends JpaRepository<Materiales,Long> {
    List<Materiales> findByNombrepContainingIgnoreCase(String nombrep);
    Optional<Materiales> findByNombrep(String nombrep);
    Boolean existsByNombrep(String nombrep);
}
