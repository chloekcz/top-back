package dev.top.controller;

import dev.top.entities.Version;
import dev.top.repos.VersionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/versions")
public class VersionCtrl {

    @Autowired
    private VersionRepo versionRepo;

    @GetMapping
    public List<Version> findAll() {
        return this.versionRepo.findAll();
    }
    
}
