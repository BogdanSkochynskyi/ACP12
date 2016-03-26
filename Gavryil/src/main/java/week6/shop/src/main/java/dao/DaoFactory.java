package week6.shop.src.main.java.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    Connection getConnection () throws SQLException;

   /* NoteBookDao getNoteBookDao (Connection connection);

    ProcessorDao getProcessorDao(Connection connection);

    RamDao getRamDao(Connection connection);

    ScreenDao getScreenDao(Connection connection);

    GpuDao getGpuDao(Connection connection);

    HddDao getHddDao(Connection connection);*/



}
