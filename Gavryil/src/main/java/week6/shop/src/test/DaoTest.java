package week6.shop.src.test;


import week6.shop.src.main.java.dao.NoteBookDao;
import week6.shop.src.main.java.entities.NoteBook;

public class DaoTest {
    public static void main(String[] args) {
        NoteBookDao dao = new NoteBookDao();
        java.util.List<NoteBook> list = dao.getAll();
        for (NoteBook noteBook : list){
            System.out.println(noteBook);
        }
        NoteBook noteBook = dao.getEntityById(17);
        System.out.println(noteBook.getManufacture());
    }
}
