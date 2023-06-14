package model;

public class Classs {
    private int idClasss;
    private String className;

    public Classs() {
    }

    public Classs(int idClasss, String className) {
        this.idClasss = idClasss;
        this.className = className;
    }

    public int getIdClasss() {
        return idClasss;
    }

    public void setIdClasss(int idClasss) {
        this.idClasss = idClasss;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


