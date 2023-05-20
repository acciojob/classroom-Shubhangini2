package com.driver;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        if(Objects.nonNull(studentRepository.findStudent(student)) && Objects.nonNull(studentRepository.findTeacher(teacher))){
            studentRepository.addStudentTeacherPair(student,teacher);
        }
    }
    public Student findStudent(String studentName){
        return studentRepository.findStudent(studentName);
    }

    public Teacher findteacher(String teacherName) {
        return studentRepository.findTeacher(teacherName);
    }


    public List<String> findStudentByTeacher(String teacher) {
        return studentRepository.findStudentByTeacher(teacher);
    }

    public List<String> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public void deleteTeacher(String teacher) {

        List<String> studentsToDelete= studentRepository.findStudentByTeacher(teacher);

        studentRepository.removeTeacher(teacher);

        for(String studentName: studentsToDelete){
            studentRepository.removeStudent(studentName);
        }
    }

    public void deleteAllTeachers(){
        List<String> teachers = studentRepository.getAllTeachers();
        for(String teacherName: teachers){
            deleteTeacher(teacherName);
        }
    }
}
