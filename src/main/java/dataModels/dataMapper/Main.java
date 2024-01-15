package dataModels.dataMapper;

import java.util.Optional;

public final class Main {
    public static void main(final String... args) {
        try {
            StudentDataMapper mapper = new StudentDataMapperImpl();
            Student student = new Student(1, "Adam", 'A');
            mapper.insert(student);
            System.out.println(student + ", is inserted");

            Optional<Student> studentToBeFound = mapper.find(student.getStudentId());
            System.out.println(studentToBeFound + ", is searched");

            student = new Student(student.getStudentId(), "AdamUpdated", 'A');
            mapper.update(student);
            System.out.println(student + ", is updated");

            System.out.println(student + ", is going to be deleted");
            mapper.delete(student);
            System.out.println(student + ", is deleted");

            DatabaseManager.closeConnection();
        } catch (DataMapperException e) {
            throw new RuntimeException(e);
        }
    }
}
