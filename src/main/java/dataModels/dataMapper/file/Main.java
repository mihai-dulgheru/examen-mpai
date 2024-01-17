package dataModels.dataMapper.file;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDataMapper dataMapper = new StudentDataMapperImpl();

        // Inserarea unui nou student
        Student newStudent = new Student(1, "John Doe", 'A');
        dataMapper.insert(newStudent);
        System.out.println("Student inserat: " + newStudent);

        // Căutarea unui student
        Student foundStudent = dataMapper.find(1);
        if (foundStudent != null) {
            System.out.println("Student găsit: " + foundStudent);
        } else {
            System.out.println("Studentul nu a fost găsit.");
        }

        // Actualizarea unui student
        if (foundStudent != null) {
            foundStudent.setName("Jane Doe");
            foundStudent.setGrade('B');
            dataMapper.update(foundStudent);
            System.out.println("Student actualizat: " + foundStudent);
        }

        // Ștergerea unui student
        if (foundStudent != null) {
            dataMapper.delete(foundStudent);
            System.out.println("Student șters: " + foundStudent.getStudentId());
        }

        // Afișarea tuturor studenților
        List<Student> students = ((StudentDataMapperImpl) dataMapper).getStudents();
        System.out.println("Studenți rămași:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
