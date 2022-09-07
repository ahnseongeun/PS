package JAVA.Generic.chapter5_generic_bound;

import java.util.ArrayList;
import java.util.List;

public class Course<T> {

    private String name;
    private List<T> studentList;

    public Course(String name) {
        this.name = name;
        studentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<T> getStudentList() {
        return studentList;
    }
}
