package students;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String className;
    private List<Integer> grades = new ArrayList<>();

    public Student(String className, String clas, List<Integer> grades) {
        this.name = className;
        this.className = clas;
        this.grades = grades ;
    }

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public String getName() {
        return name;
    }
    public String getClassName() {
        return className;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int note){
        grades.add(note);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", grades=" + grades +
                '}';
    }
}
