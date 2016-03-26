package week6.shop.src.main.java.dao;

import week6.shop.src.main.java.entities.AbstractEntity;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController<E extends AbstractEntity,ID> {

    List<E> getAll()throws SQLException;
    E getEntityById(ID id)throws SQLException;
    boolean insertEntity(E entity)throws SQLException;
    boolean deleteEntity(E entity)throws SQLException;
    boolean updateEntity(E entity)throws SQLException;
}
