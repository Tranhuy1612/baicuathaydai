package model;

public class Students {
    private int id;
    private String name;
    private boolean gender;
    private int age;
    private String address;
    private Classs classs; // 1 đối tượng class sẽ là 1 thuộc tính của student

    public Students() {
    }

    public Students(int id, String name, boolean gender, int age, String address, Classs classs) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + (this.gender ? "nam" : "nữ") +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", classs=" + classs +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }
}
