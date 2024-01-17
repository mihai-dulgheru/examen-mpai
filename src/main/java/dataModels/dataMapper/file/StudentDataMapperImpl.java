package dataModels.dataMapper.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDataMapperImpl implements StudentDataMapper {
    @Override
    public Student find(int studentId) {
        try {
            List<String> lines = FileHelper.readAllLines();
            for (String line : lines) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == studentId) {
                    return new Student(studentId, data[1], data[2].charAt(0));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Student student) {
        String studentData = student.getStudentId() + "," + student.getName() + "," + student.getGrade();
        try {
            List<String> lines = FileHelper.readAllLines();
            lines.add(studentData);
            FileHelper.writeAllLines(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try {
            List<String> lines = FileHelper.readAllLines();
            List<String> updatedLines = lines.stream().map(line -> {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == student.getStudentId()) {
                    return student.getStudentId() + "," + student.getName() + "," + student.getGrade();
                }
                return line;
            }).collect(Collectors.toList());

            FileHelper.writeAllLines(updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {
        try {
            List<String> lines = FileHelper.readAllLines();
            lines = lines.stream().filter(line -> Integer.parseInt(line.split(",")[0]) != student.getStudentId()).collect(Collectors.toList());

            FileHelper.writeAllLines(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
            List<String> lines = FileHelper.readAllLines();
            for (String line : lines) {
                String[] data = line.split(",");
                students.add(new Student(Integer.parseInt(data[0]), data[1], data[2].charAt(0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
