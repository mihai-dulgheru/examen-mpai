package dataModels.dataMapper.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CallToPrintStackTrace")
public final class StudentDataMapperImpl implements StudentDataMapper {
    @Override
    public Student find(int studentId) {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = ?")) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("grade").charAt(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Student studentToBeUpdated) throws DataMapperException {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE students SET name = ?, grade = ? WHERE id = ?")) {
            statement.setString(1, studentToBeUpdated.getName());
            statement.setString(2, String.valueOf(studentToBeUpdated.getGrade()));
            statement.setInt(3, studentToBeUpdated.getStudentId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DataMapperException("Student [" + studentToBeUpdated.getName() + "] is not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Student studentToBeInserted) throws DataMapperException {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO students (name, grade) VALUES (?, ?)")) {
            statement.setString(1, studentToBeInserted.getName());
            statement.setString(2, String.valueOf(studentToBeInserted.getGrade()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataMapperException("Error inserting student into database");
        }
    }

    @Override
    public void delete(Student studentToBeDeleted) throws DataMapperException {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE id = ?")) {
            statement.setInt(1, studentToBeDeleted.getStudentId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new DataMapperException("Student [" + studentToBeDeleted.getName() + "] is not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DatabaseManager.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {
            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("grade").charAt(0)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
