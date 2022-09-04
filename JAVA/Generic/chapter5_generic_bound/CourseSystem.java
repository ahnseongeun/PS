package JAVA.Generic.chapter5_generic_bound;

import java.util.List;

public class CourseSystem {

    public <T> void register(Course<? extends Person> course, T t) {

        List<T> students;

        //List<T>는 List<Person>보다 하위타입이여서 캐스팅 필요
        students = (List<T>) course.getStudentList();

        students.add(t);

    }

    public static void printCourse(Course<?> course) {
        System.out.println(course.getName() + " 수강생 " + course.getStudentList().toString());
    }

    public static void printCourseStudent(Course<? extends Student> course) {
        System.out.println(course.getName() + " 수강생 " + course.getStudentList().toString());
    }

    public static void printCourseWorker(Course<? super Worker> course) {
        System.out.println(course.getName() + " 수강생 " + course.getStudentList().toString());
    }
}
