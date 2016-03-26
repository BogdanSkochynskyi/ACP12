package week6.shop.src.main.java.dao;

import week6.shop.src.main.java.entities.AbstractEntity;
import week6.shop.src.main.java.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gavri on 25.03.2016.
 */
public abstract class AbstractDao<E extends AbstractEntity,Integer> implements AbstractController<E,Integer> {
    private Connection connection;

    public abstract String getSelectQuery();

    protected abstract String getIdSelectQuery();

    protected abstract List<E> parseList(ResultSet resultSet);

    @Override
    public List<E> getAll()  {
        String sql = getSelectQuery();
        Connection connection = null;
        PreparedStatement statement = null;
        List<E> list = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            list = parseList(resultSet);
        } catch (SQLException e) {
            System.err.println("SQL ecxeption: connection or statement ERROR");
            e.printStackTrace();
        }finally {
            JdbcUtils.closePreparedStatement(statement);
            JdbcUtils.closeConnection(connection);
        }


        return list;
    }

    @Override
    public E getEntityById(Integer id){
        String sql = getIdSelectQuery();
        Connection connection = null;
        PreparedStatement statement = null;
        E entity = null;
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (java.lang.Integer) id);
            ResultSet resultSet = statement.executeQuery();
            List<E>  list = parseList(resultSet);
            entity = list.get(0);
        } catch (SQLException e) {
            System.err.println("SQL ecxeption: connection or statement ERROR");
            e.printStackTrace();
        }finally {
            JdbcUtils.closePreparedStatement(statement);
            JdbcUtils.closeConnection(connection);
        }

        return entity;
    }

    @Override
    public boolean insertEntity(E entity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteEntity(E entity) throws SQLException {
        return false;
    }

    @Override
    public boolean updateEntity(E entity) throws SQLException {
        return false;
    }
}
