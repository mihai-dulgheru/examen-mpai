package dataModels.dataMapper;

public interface StudentDataMapper {

    Student find(int studentId);

    void insert(Student student) throws DataMapperException;

    void update(Student student) throws DataMapperException;

    void delete(Student student) throws DataMapperException;
}
