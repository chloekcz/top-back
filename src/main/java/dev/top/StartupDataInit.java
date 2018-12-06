package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;
    
    @Autowired
    CollegueRepo collegueRepo;
    
    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Version("v1"));
            this.versionRepo.save(new Version("v2"));
            this.versionRepo.save(new Version("v3"));
            this.versionRepo.save(new Version("v4"));
        }
        
        
        if(this.collegueRepo.count() <= 0) {
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Bibi", 0, "Durand", "Robert", "robert.durand@gmail.com", "8 rue de la liberté, 33110 Le Bouscat"));
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Kiki", 0, "Kiwi", "Christophe", "criridu38@gmail.com", "29 avenue Georges, 38000 Ouganda"));
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Gégé", 0, "Darmont", "Gérard", "gege@gmail.com", "01 rue du soleil, 45000 Italie"));
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Mimi", 0, "Casserole", "Cassandra", "cass@gmail.com", "02 rue tableau, 33000 Bordeaux"));
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Georges", 0, "Delajungle", "Georges", "georges@gmail.com", "26 rue de maurice, 33000 Bordeaux"));
        }
        
        

    }
}
