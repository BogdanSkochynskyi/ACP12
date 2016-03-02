package ua.artcode.week3.serializer.obj_xml;

/**
 * Created by Олександр on 29.02.2016.
 */
public class BookStore {

    public static String bookstore = "bookstore";

    public static void main(String[] args) {
        System.out.println("<" + bookstore + ">");
        Book book = new BookBuilder().appendCategory("cooking").
                appendTitle(new Title("en", "Everyday Italian")).
                appendAuthor(new Author("Giada De Laurentiis")).
                appendYear(new Year(2005)).
                appendPrice(new Price(30.00)).build();
        System.out.println(book.toString());

        Book book2 = new BookBuilder().appendCategory("children").
                appendTitle(new Title("en", "Harry Potter")).
                appendAuthor(new Author("J K. Rowling")).
                appendYear(new Year(2005)).
                appendPrice(new Price(29.99)).build();
        System.out.println(book2.toString());

        Book book3 = new BookBuilder().appendCategory("web").
                appendTitle(new Title("en", "XQuery Kick Start")).
                appendAuthor(new Author("James McGovern")).
                appendYear(new Year(2003)).
                appendPrice(new Price(49.99)).build();
        System.out.println(book3.toString());

        Book book4 = new BookBuilder().appendCategory("web").
                appendTitle(new Title("en", "Learning XML")).
                appendAuthor(new Author("Erik T. Ray")).
                appendYear(new Year(2003)).
                appendPrice(new Price(39.95)).build();
        System.out.println(book4.toString());
    }
}
