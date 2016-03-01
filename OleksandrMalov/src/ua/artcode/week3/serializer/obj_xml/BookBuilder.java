package ua.artcode.week3.serializer.obj_xml;

/**
 * Created by Олександр on 29.02.2016.
 */
public class BookBuilder {

    private String category;

    private Title title;
    private Author author;
    private Year year;
    private Price price;

    public BookBuilder appendCategory(String category){
        this.category = category;
        return  this;
    }

    public BookBuilder appendTitle(Title title){
        this.title = title;
        return this;
    }
    public BookBuilder appendAuthor(Author author){
        this.author = author;
        return this;
    }
    public BookBuilder appendYear(Year year){
        this.year = year;
        return this;
    }
    public BookBuilder appendPrice(Price price){
        this.price = price;
        return this;
    }
    public Book build() {
        return new Book(category, title, author, year, price);
    }


}
