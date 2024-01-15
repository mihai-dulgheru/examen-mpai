package dataModels.dataMapper;

import java.io.Serial;
import java.io.Serializable;

public final class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int studentId;
    private String name;
    private char grade;

    public Student(int studentId, String name, char grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        return studentId;
    }

    @Override
    public boolean equals(Object obj) {
        // return super.equals(obj);
        if (obj instanceof Student student) {
            return studentId == student.studentId;
        }
        return false;
    }
}
