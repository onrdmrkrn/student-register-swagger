package com.example.finaltask.repository;

import com.example.finaltask.entity.Student;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository <Student, Integer> {
    public Optional<Student> findByStudentId(int studentId);



}
