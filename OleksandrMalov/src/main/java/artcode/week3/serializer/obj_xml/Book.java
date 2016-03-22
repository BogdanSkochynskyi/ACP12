package main.java.artcode.week3.serializer.obj_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by Олександр on 29.02.2016.
 */
@XmlRootElement(name = "book")
public class Book {
    @XmlElement
    private String title;
    @XmlElement
    private String author;
    @XmlElement
    private int year;
    @XmlElement
    private double price;

//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }

    public Book( String title, String author, int year, double price) {

        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book\n" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price;
    }
}