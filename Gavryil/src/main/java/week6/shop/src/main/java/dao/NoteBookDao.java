package week6.shop.src.main.java.dao;

import week6.shop.src.main.java.entities.NoteBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavri on 25.03.2016.
 */
public class NoteBookDao extends AbstractDao<NoteBook,Integer> {

    @Override
    public String getSelectQuery() {
        String queryAll = "Select * From notebooks";
        return queryAll;
    }

    @Override
    protected String getIdSelectQuery() {
        String idQuery = "Select * From notebooks where notebook_id = ? ";
        return idQuery;
    }

    @Override
    public List<NoteBook> parseList(ResultSet resultSet) {
        List<NoteBook> list = new ArrayList<>();
        NoteBook noteBook;
        try {
            while (resultSet.next()){
                 noteBook = new NoteBook(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getInt(4),resultSet.getInt(5),
                        resultSet.getInt(6),resultSet.getInt(7));
                list.add(noteBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
