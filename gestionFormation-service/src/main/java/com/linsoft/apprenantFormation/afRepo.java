package com.linsoft.apprenantFormation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface afRepo extends JpaRepository<apprenantFormation,Integer> {

    Optional<apprenantFormation> findOneByIdFormationAndIdApprenant(int idF,int idA);
}
