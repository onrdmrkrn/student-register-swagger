package com.example.finaltask.service;

import com.example.finaltask.dto.StudentDto;
import com.example.finaltask.entity.Student;
import com.example.finaltask.repository.StudentRepository;
import com.example.finaltask.response.Meta;
import com.example.finaltask.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StudentService {
   @Autowired
   StudentRepository studentRepository;

    public StudentResponse add(StudentDto studentDto) {
        Student studentResult = StudentDto.fromResource(studentDto);
        studentResult = studentRepository.save(studentResult);
        return addedStudent(StudentDto.toResource(Optional.of(studentResult)));
    }

    private StudentResponse addedStudent(StudentDto fromDto) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.meta = new Meta("Ogrenci kaydetme basarılı", 200);
        studentResponse.student = fromDto;
        return studentResponse;
    }

    public ResponseEntity<StudentDto> find(int studentId) {
        Optional<Student> student = studentRepository.findByStudentId(studentId);
        StudentResponse studentResponse = new StudentResponse();
       return ResponseEntity.ok(StudentDto.toResource(student));

    }

    public Boolean delete(int studentId) {

        Optional<Student> student = studentRepository.findByStudentId(studentId);
        if (student != null){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;

    }

    public Student updateUser(int studentId, Student student) {
        Optional<Student> studentResult = studentRepository.findByStudentId(studentId);
        if (studentResult != null){
            studentResult.get().setName(student.getName());
            studentResult.get().setSurname(student.getSurname());
            studentResult.get().setUpdatedAt(new Date());


            return studentRepository.save(studentResult.get());
        }
        return null;
    }
}
