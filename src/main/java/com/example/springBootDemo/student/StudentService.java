package com.example.springBootDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository
                .findByStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String studentName, String studentEmail){
        Student student = studentRepository.findByStudentById(studentId).orElseThrow(() -> new IllegalStateException(
                "student ID" + studentId + " does not exist"));

        if (studentName != null && studentName.length()> 0 && !Objects.equals(student.getName(), studentName)){
            student.setName(studentName);
        }

        if (studentEmail != null && studentEmail.length()> 0 && !Objects.equals(student.getEmail(), studentEmail)){
            Optional<Student> studentOptional = studentRepository.findByStudentByEmail(studentEmail);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(studentEmail);
        }


    }


}
