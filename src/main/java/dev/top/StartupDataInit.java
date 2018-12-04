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
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Bibi", 0));
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Kiki", 0));
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Gégé", 0));
        	this.collegueRepo.save(new Collegue("https://media.giphy.com/media/M7oKkaur56EFO/giphy.gif", "Mimi", 0));
        }

    }
}
