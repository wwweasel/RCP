package de.wwweasel.RCP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ApplicationStartupRunner implements CommandLineRunner{
	
	@Autowired
	ProfessioNService professioNService;
	
    @Override
    public void run(String... args) throws Exception {
    	professioNService.save(new ProfessioN("MODELING",6000));
    	professioNService.save(new ProfessioN("RIGGING",6000));
    	professioNService.save(new ProfessioN("ANIMATION",6000));
    	professioNService.save(new ProfessioN("TEXTURING",6000));
    	professioNService.save(new ProfessioN("LIGHTING",6000));
    	professioNService.save(new ProfessioN("COMP",6000));
    }
}
