package g13c.cw2.zd5;

import g13c.cw2.zd5.library.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){

        Address janaKazimierza = new Address("Polska","Warszawa","Jana Kazimierza",25,24);
        Address janapawla = new Address("Polska","Gdańsk","Jana Pawła II",56);

        Person king = new Person("Stephen", "King", LocalDate.parse("2020-01-12"), janaKazimierza);
        Person tolkien = new Person ("JRR", "Tolkien", LocalDate.parse("2020-02-12"), janapawla);

        Person jan = new Person("Jan", "Kowalski", LocalDate.parse("2020-03-12"), janaKazimierza);
        Person stanislaw = new Person ("Stanisław", "Nowak", LocalDate.parse("2020-04-12"), janapawla);
        Person mateusz = new Person("Mateusz", "Kowalczyk", LocalDate.parse("2020-05-12"), janaKazimierza);
        Person katarzyna = new Person ("Katarzyna", "Drab", LocalDate.parse("2020-06-12"), janapawla);

        System.out.println(jan);
        System.out.println(katarzyna);




        Book harrypotter = new Book (1L, "Harry Potter", Genre.FANTASY, Lang.JAPANESE, king, LocalDate.parse("2020-06-12"));
        Book starwars = new Book (2L, "Gwiezdne wojny", Genre.FICTION, Lang.UKRAINIAN, king);
        Book it = new Book (3L, "It", Genre.ADVENTURE, Lang.ENGLISH, king);
        Book dune = new Book (4L, "Diuna", Genre.CLASSIC, Lang.POLISH, tolkien);

        System.out.println(king);

        harrypotter.borrowBook(jan);

        System.out.println(jan);

        jan.publishBook(dune);

        harrypotter.placeBack();

        System.out.println(jan);

        tolkien.publishBook(dune);

        jan.unPublishBook(dune);
        System.out.println(jan);

        printBook(dune);

        dune.borrowBook(katarzyna);
        printBook(dune);

    }

    private static void printBook(Book book){
        System.out.println(book);
        System.out.println("Authors: "+book.getAuthors());
        System.out.println("Borrowed: "+book.getBorrower());
    }


}
