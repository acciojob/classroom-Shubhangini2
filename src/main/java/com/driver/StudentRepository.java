package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String,Student> studentMap= new HashMap<>();
    private HashMap<String,Teacher> teacherMap= new HashMap<>();
    private HashMap<String, List<String>> teacherStudentMap= new HashMap<>();

    public void addStudent(Student student){
        studentMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public Student findStudent(String student) {
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        return teacherMap.get(teacher);
    }
    public void addStudentTeacherPair(String student, String teacher) {

        List<String> studentByTeacher = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)){
            studentByTeacher= teacherStudentMap.get(teacher);
            studentByTeacher.add(student);
            teacherStudentMap.put(teacher, studentByTeacher);
        }
    }

    public List<String> findStudentByTeacher(String teacher) {
        List<String> studentList = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacher)){
            studentList= teacherStudentMap.get(teacher);
        }
        return studentList;
    }

    public List<String> findAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void removeTeacher(String teacher){
        teacherMap.remove(teacher);
        teacherStudentMap.remove(teacher);
    }

    public void removeStudent(String studentName){
        studentMap.remove(studentName);
    }

    public List<String> getAllTeachers(){
        return new ArrayList<>(teacherMap.keySet());
    }
}
