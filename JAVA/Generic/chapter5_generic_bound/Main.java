package JAVA.Generic.chapter5_generic_bound;

public class Main {
    public static void main(String[] args) {
        Course<Person> personCourse = new Course("일반인과정");
        Course<Worker> workerCourse = new Course("직장인과정");
        Course<Student> studentCourse = new Course("학생과정");
        Course<HighStudent> highStudentCourse = new Course("고등학생과정");

        CourseSystem cs = new CourseSystem();

        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        Student student1 = new Student("student1");
        Student student2 = new Student("student2");
        Worker worker1 = new Worker("worker1");
        Worker worker2 = new Worker("worker2");
        HighStudent highStudent1 = new HighStudent("highStudent1");
        HighStudent highStudent2 = new HighStudent("highStudent2");

        cs.register(personCourse, person1);
        cs.register(personCourse, person2);
        cs.register(studentCourse, student1);
        cs.register(studentCourse, student2);
        cs.register(workerCourse, worker1);
        cs.register(workerCourse, worker2);
        cs.register(highStudentCourse, highStudent1);
        cs.register(highStudentCourse, highStudent2);

        CourseSystem.printCourse(personCourse);
        CourseSystem.printCourse(workerCourse);
        CourseSystem.printCourse(highStudentCourse);
        CourseSystem.printCourse(studentCourse);
    }
}
