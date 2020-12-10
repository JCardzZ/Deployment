package com.mm.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.com.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
