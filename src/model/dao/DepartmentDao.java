package model.dao;

import java.util.List;
import model.entidades.Department;

public interface DepartmentDao {

    void insert(Department obj);

    void update(Department obj);

    void deleteById(int id);

    Department findById(int id);

    List<Department> findAll();

}
