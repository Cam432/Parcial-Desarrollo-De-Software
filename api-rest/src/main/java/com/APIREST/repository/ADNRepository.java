package com.APIREST.repository;

import com.APIREST.model.ADN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ADNRepository extends JpaRepository <ADN, Long> {

    long countByEsMutante(boolean esMutante);

}
