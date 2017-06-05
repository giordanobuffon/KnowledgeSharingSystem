package br.edu.ifrs.bean;

public class Student {
    private int id;
    private String name;
    private String email;
    private String password;
    private String course;
    private String semester;
    private int registration;

    public Student() {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.password = "";
        this.course = "";
        this.semester = "";
        this.registration = 0;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String  getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }
}

