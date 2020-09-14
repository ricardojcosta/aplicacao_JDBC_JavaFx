
package model.dao;

import java.util.List;
import model.entidades.Department;
import model.entidades.Seller;


public interface SellerDao {
    void insert(Seller obj);

    void update(Seller obj);

    void deleteById(int id);

    Seller findById(int id);

    List<Seller> findAll();
    
    List<Seller> findByDepartment (Department departamento);
    
}
