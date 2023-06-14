package controller;

import model.Students;
import service.StudentService;

public class StudentController { //điều hướng luồng chạy
    private StudentService service =new StudentService();
    public boolean createStudent(Students student){ //hàm lưu student
        return service.saveStudent(student); // trả về hàm saveStudent trong service
    }
    public Students findById(int id){
        return service.findById(id);
    }
}
