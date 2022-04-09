package g13c.cw2.zd5.library;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Book extends BaseObject {

    private static final Set<Long> ids = new HashSet<>();

    private final Long id;
    private final String name;
    private Genre genre;
    private final Lang language;
    private int borrowCount;
    private boolean isAvailable = true;
    private Person borrower;
    private final Set<Person> authors;

    private static void checkUnique(Long id){
        if(ids.contains(id)) throw new RuntimeException("Book o takim ID istnieje");
    }

    public Book(Long id, String name, Genre genre, Lang language, Person author, LocalDate publishBook){
        this(id, name, genre, language, author);
        setCreateDate(publishBook);
    }

    public Book(Long id, String name, Genre genre, Lang language, Person author){
        ArgumentValidator.checkArgIsBlank(name);
        ArgumentValidator.checkArgIsNull(id);
        ArgumentValidator.checkArgIsNull(genre);
        ArgumentValidator.checkArgIsNull(language);
        ArgumentValidator.checkArgIsNull(author);
        checkUnique(id);
        ids.add(id);
        this.name=name;
        this.id=id;
        this.genre=genre;
        this.language=language;
        this.borrowCount=0;
        authors=new HashSet<>();

        author.publishBook(this);
    }

    public void borrowBook(Person person){
        if(isAvailable == false) throw new RuntimeException("Książka jest niedostępna");
        isAvailable=false;
        borrower=person;
        person.borrow(this);
        borrowCount++;
    }

    public void placeBack(){
        if(isAvailable == true) throw new RuntimeException("Książka nie została wypożyczona");
        isAvailable=true;
        borrower.returnBook();
        borrower=null;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Genre getGenre(){
        return genre;
    }

    public Lang getLanguage(){
        return language;
    }

    public int getBorrowCount(){
        return borrowCount;
    }

    public Person getBorrower(){
        return borrower;
    }

    public Optional<LocalDate> getPublishDate(){
        return Optional.ofNullable(getCreateDate());
    }

    public Set<Person> getAuthors(){
        return authors.stream().collect(Collectors.toUnmodifiableSet());
    }


    public void setPublishDate(LocalDate publishDate){
        setCreateDate(publishDate);
    }

    public void setGenre(Genre newGenre){
        genre=newGenre;
    }

    void addAuthor(Person person){
        ArgumentValidator.checkArgIsNull(person);
        authors.add(person);
    }

    void removeAuthor(Person person){
        ArgumentValidator.checkArgIsNull(person);
        if(authors.size()==1)throw new RuntimeException("Nie można usunąć, Book musi mieć przynajmniej jednego autora");
        authors.remove(person);
    }

    @Override
    public String toString(){
        return String.format("Book: %s, %s, %s, %s, BorrowCount: %s, isAvailable %s", getId(), getName(), getGenre(), getLanguage(), getBorrowCount(), isAvailable);
    }

}
