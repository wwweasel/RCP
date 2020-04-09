package de.wwweasel.RCP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessioNRepo extends JpaRepository<ProfessioN, Integer>{
	List<ProfessioN> findByProfession(String profession);
}
