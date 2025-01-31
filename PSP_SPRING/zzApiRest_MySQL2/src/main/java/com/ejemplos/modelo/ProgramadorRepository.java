package com.ejemplos.modelo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramadorRepository extends JpaRepository<Programador, String> {
}