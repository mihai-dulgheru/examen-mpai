package dataModels.dataMapper.file;

public interface StudentDataMapper {

    Student find(int studentId);

    void insert(Student student);

    void update(Student student);

    void delete(Student student);
}
