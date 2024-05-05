package com.securitydemo.inmemory.controllers;
import com.securitydemo.inmemory.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService=universityService;
    }

    @GetMapping("/lessons")
    public List<String> getLessons() {
        return universityService.getLessons();
    }

    @PostMapping("/assignLesson/{studentId}/{lesson}")
    public String assignLesson(@PathVariable Long studentId, @PathVariable String lesson) {
        return universityService.assignLesson(studentId, lesson);
    }

    @DeleteMapping("/removeLesson/{lesson}")
    public String removeLesson(@PathVariable String lesson) {
        return universityService.removeLesson(lesson);
    }

    @PutMapping("/addLesson/{lesson}")
    public String addLesson(@PathVariable String lesson) {
        return universityService.addLesson(lesson);
    }
}
