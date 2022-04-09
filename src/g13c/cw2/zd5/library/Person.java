package g13c.cw2.zd5.library;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Person extends BaseObject{

    private final String name;
    private final String surname;
    private final Set<Book> myBooks;

    private Address address;
    private Book myBorrowed;


    public Person(String name, String surname, LocalDate dateOfBirth, Address address){
        ArgumentValidator.checkArgIsBlank(name);
        ArgumentValidator.checkArgIsBlank(surname);

        setCreateDate(dateOfBirth);
        setAddress(address);
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.myBooks = new HashSet<>();
    }

    public void publishBook(Book newBook){
        ArgumentValidator.checkArgIsNull(newBook);
        myBooks.add(newBook);
        newBook.addAuthor(this);
    }

    public void unPublishBook(Book book){
        ArgumentValidator.checkArgIsNull(book);
        book.removeAuthor(this);
        myBooks.remove(book);
    }

    public void setAddress(Address arg){
        ArgumentValidator.checkArgIsNull(arg);
        address = arg;
    }


    void borrow(Book newBook){
        ArgumentValidator.checkArgIsNull(newBook);
        if(myBorrowed != null) throw new RuntimeException("Masz już książkę");
        myBorrowed=newBook;
    }

     void returnBook(){
        if(myBorrowed == null) throw new RuntimeException(name + ", nie masz książki");
        myBorrowed=null;
    }


    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public Address getAddress(){
        return address;
    }

    public LocalDate getDateOfBirth(){
        return getCreateDate();
    }

    public Set<Book> getMyBooks(){
        return myBooks.stream().collect(Collectors.toUnmodifiableSet());
    }

    public Optional<Book> getMyBorrowed(){
        return Optional.ofNullable(myBorrowed);
    }

    @Override
    public String toString(){
        return String.format("Osoba %s, %s, age: %s, %s, %s, borrowed: %s, autor: %s",
                getName(), getSurname(), getAge(), getDateOfBirth(), getAddress(), getMyBorrowed(), getMyBooks());
    }

}
