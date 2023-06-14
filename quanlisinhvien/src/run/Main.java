package run;

import config.Config;
import controller.StudentController;
import model.Students;
import service.StudentService;

import static service.StudentService.studentList;

public class Main {
    static Students[] studentList = StudentService.studentList;
    static StudentController controller = new StudentController();

    public static void main(String[] args) {

        StudentService.studentList[0] = new Students(1, "student1", true, 18, "Hà nội", null);
        StudentService.studentList[1] = new Students(2, "student2", false, 19, "Hà Nam", null);
        StudentService.studentList[2] = new Students(3, "student3", true, 20, "Hà Tây", null);
        while (true) {
            System.out.println("1.\tHiển thị danh sách sinh viên\n" +
                    "2.\tThêm mới sinh viên\\\n" +
                    "3.\tUpdate thông tin sinh viên theo id\n" +
                    "4.\tXoá sinh viên theo id\n" +
                    "5.\tThoát");
            System.out.println("nhập lựa chọn của bạn ");
            int choice = Config.getScanner().nextInt();
            switch (choice) {
                case 1:
                    showAllStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    static void showAllStudents() {

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println(studentList[i]);
            }
        }

    }

    static public void createStudent() { // hàm tọa mới học sinh
//        Students student = new Students();
        int id = idAutoIncrement(); // id tự tăng
//        student.setId(id);
        System.out.println("Nhập tên học sinh"); //lấy tên học sinh nhập vào từ bàn phím
        String name = Config.getScanner().next();
        boolean gender = getGender(); // láy giới tính
        System.out.println("nhập tuổi");
        int age = Config.getScanner().nextInt();// nhập tuổi
        System.out.println("địa chỉ :");
        String address = Config.getScanner().next();
        Students student = new Students(id, name, gender, age, address, null); //tọa mới học sinh
        boolean checkCreate = controller.createStudent(student); //gọi hàm lưu học sinh  ,và đặt biến check
        if (checkCreate) {
            System.out.println(" tạo thành công");
        } else System.out.println(" quá trình lưu học sinh gặp lỗi ");
    }


    static boolean getGender() {
        System.out.println("giới tính :");
        System.out.println("1 .nam");
        System.out.println("2 .nữ");
        int choice = Config.getScanner().nextInt();
        return choice == 1 ? true : false;
    }

    static int idAutoIncrement() {
        int maxId = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null && maxId < studentList[i].getId()) {
                maxId = studentList[i].getId();
            }
        }
        return maxId + 1;
    }

    static void editStudent() {
        System.out.println("Nhập id học sinh muốn sửa");
        int id = Config.getScanner().nextInt();
        Students student = controller.findById(id);
        if (student == null) {
            System.out.println("ko thấy học sinh có id này");
            return;
        }
        System.out.println(student);
        System.out.println("Nhập tên học sinh"); //lấy tên học sinh nhập vào từ bàn phím
        String name = Config.getScanner().next();
        boolean gender = getGender(); // láy giới tính
        System.out.println("nhập tuổi");
        int age = Config.getScanner().nextInt();// nhập tuổi
        System.out.println("địa chỉ :");
        String address = Config.getScanner().next();
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        student.setGender(gender);
        boolean check = controller.createStudent(student);
        if (check) {
            System.out.println("sửa thành công");
        } else System.out.println("sửa thất bại ");
    }


    static void deleteStudent() {
        System.out.println("nhập id mà bạn muốn xóa");
        int idDel = Config.getScanner().nextInt();
        // cho phép xóa
//        int check = -1;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null && studentList[i].getId() == idDel) {
                studentList[i] = null;
                System.out.println("xóa thành công");
//                check = i;
                break;
            }
        }//        if (check == -1) {
//            System.out.println("ko có id đấy");
        }
    }

