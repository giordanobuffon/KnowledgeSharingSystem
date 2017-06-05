package br.edu.ifrs.bean;

public class Discipline {
    private int id;
    private String description;
    private String semester;

    public Discipline() {
        this.id = 0;
        this.description = "";
        this.semester = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String  getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
