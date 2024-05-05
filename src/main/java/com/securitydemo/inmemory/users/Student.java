package com.securitydemo.inmemory.users;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<String>lesson=new ArrayList<>();

    public Student(Long id, String name, String surname, List<String> lesson) {
        super(id, name, surname);
        this.lesson = lesson;
    }

    public Student(List<String> lesson) {
        this.lesson = lesson;
    }

    public List<String> getLesson() {
        return lesson;
    }

    public void setLesson(List<String> lesson) {
        this.lesson = lesson;
    }
}
