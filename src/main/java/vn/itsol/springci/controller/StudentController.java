package vn.itsol.springci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.itsol.springci.dto.Student;
import vn.itsol.springci.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("${spring.data.rest.base-path}/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/getAll")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);

        
    }
}
