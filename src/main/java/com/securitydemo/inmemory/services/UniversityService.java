package com.securitydemo.inmemory.services;

import com.securitydemo.inmemory.users.Student;
import com.securitydemo.inmemory.users.Teacher;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UniversityService {
    private List<String> lessons = new ArrayList<>();
    private Map<Long, Teacher> teachers = new HashMap<>();
    private Map<Long, Student> students = new HashMap<>();

    public UniversityService() {
        lessons.add("Matematik");
        lessons.add("Algoritma");
        lessons.add("Java programlama");
        lessons.add("Yapay zeka");
        teachers.put(1L, new Teacher(1L, "Serkan", "Özaydın", lessons.get(1)));
        teachers.put(2L, new Teacher(2L, "Turgut", "Uyar", lessons.get(1)));
        students.put(10L, new Student(10L, "Bilal", "Akyol",
                Arrays.asList(lessons.get(1), lessons.get(2))));
        students.put(7L, new Student(10L, "Bilal", "Akyol",
                Arrays.asList(lessons.get(0), lessons.get(3))));
    }
    public List<String> getLessons() {
        return lessons;
    }

    public String assignLesson(Long ogrenciId, String lesson) {
        Student student = students.get(ogrenciId);
        if (student != null) {
            List<String> studentLessons = student.getLesson();
            if (!studentLessons.contains(lesson)) {
                studentLessons.add(lesson);
                return "Öğrenciye eklenen ders";
            } else {
                return "Öğrenci bu dersi zaten almaktadır";
            }
        } else {
            return "Öğrenci bulunamadı";
        }
    }

    public String removeLesson(String lesson) {
        boolean removed = lessons.remove(lesson);
        if (removed) {
            return "Ders kaldırıldı";
        } else {
            return "Ders bulunamadı";
        }
    }

    public String addLesson(String lesson) {
        lessons.add(lesson);
        return "Ders eklendi";
    }

}

