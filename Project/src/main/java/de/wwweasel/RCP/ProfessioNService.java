package de.wwweasel.RCP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessioNService {
	
	@Autowired
	private ProfessioNRepo repo;
	
	public ProfessioN save(ProfessioN professioN) {
		return repo.save(professioN);
	}

	public List<ProfessioN> findAll(){
		return repo.findAll();
	}
	
}
