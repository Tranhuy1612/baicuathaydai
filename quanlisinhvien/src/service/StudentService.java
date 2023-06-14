package service;

import model.Students;

public class StudentService { // class này xử lí logic thao tác với student(CRUD)
    public static Students[] studentList = new Students[50]; // dánh sách student

    public boolean saveStudent(Students student) {
        if (student == null) {
            return false;
        }
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null || studentList[i].getId() == student.getId()) {
                studentList[i] = student;
                return true;
            }
        }
        return false;
    }

    public Students findById(int id) {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i].getId() == id) {
                return studentList[i];
            }
        }
        return null;
    }


}
