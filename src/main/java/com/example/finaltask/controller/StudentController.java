package com.example.finaltask.controller;


import com.example.finaltask.dto.StudentDto;
import com.example.finaltask.entity.Student;
import com.example.finaltask.response.StudentResponse;
import com.example.finaltask.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
@Api(value = "ogrenci isleri kontrol merkezi")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    @ApiOperation(value = "Yeni Ogrenci Ekleme metodu", notes = "Bu metodu dikkatli kullan")
    public StudentResponse add(@RequestBody @ApiParam (value = "ogrenci") StudentDto studentDto){
        return studentService.add(studentDto);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value =  "Ogrenci Bulma metodu", notes = "Bu metodu dikkatli kullan")
    public  ResponseEntity<StudentDto> find(@PathVariable  (name = "id")  @ApiParam (value = "ogrenci") String studentId){
        return studentService.find(Integer.parseInt(studentId));
    }

    @DeleteMapping("/remove/{studentId}")
    @ApiOperation(value = "Ogrenci silme metodu", notes = "Bu metodu dikkatli kullan")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "studentId")  @ApiParam (value = "ogrenci") int studentId){
         Boolean status = studentService.delete(studentId);
         return ResponseEntity.ok(status);
    }

    @PutMapping("/edit/{studentId}")
    @ApiOperation(value = "Ogrenci guncelleme metodu", notes = "Bu metodu dikkatli kullan")
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "studentId") String studentId, @RequestBody  @ApiParam (value = "ogrenci") Student student){{
        Student result = studentService.updateUser(Integer.parseInt(studentId), student);
        return ResponseEntity.ok(result);
    }

}
}
