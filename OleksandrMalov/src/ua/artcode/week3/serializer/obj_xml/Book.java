package ua.artcode.week3.serializer.obj_xml;

/**
 * Created by Олександр on 29.02.2016.
 */
public class Book {


    private String category;

    private Title title;
    private Author author;
    private Year year;
    private Price price;

    public Book(String category, Title title, Author author, Year year, Price price) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return "<book " +
                "category=\"" + category.toString() + "\">\n" +
                "\t<title" + title.toString() + "</title>\n" +
                "\t<author>" + author.toString() + "</author>\n" +
                "\t<year>" + year.toString() + "</year>\n" +
                "\t<price>" + price.toString() + "</price>\n" +
                "</book>\n"
                ;
    }
}
