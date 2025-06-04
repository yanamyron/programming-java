import java.util.*;

class Genre {
    String name;
    String description;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Author {
    String name;
    String country;
    int booksCount;
    Genre genre;

    public Author(String name, String country, int booksCount, Genre genre) {
        this.name = name;
        this.country = country;
        this.booksCount = booksCount;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}

class Book implements Comparable<Book> {
    String title;
    Author author;
    Genre genre;
    int year;
    String publisher;

    public Book(String title, Author author, Genre genre, int year, String publisher) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.publisher = publisher;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author.name, book.author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author.name);
    }

    @Override
    public String toString() {
        return title + " by " + author.name;
    }
}

class Reader {
    String fullName;
    int cardNumber;
    long phone;

    public Reader(String fullName, int cardNumber, long phone) {
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return fullName + " (Card: " + cardNumber + ")";
    }
}

class Stuff {
    String fullName;
    String title;
    long phone;

    public Stuff(String fullName, String title, long phone) {
        this.fullName = fullName;
        this.title = title;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return title + " " + fullName;
    }
}

class Publisher {
    String name;
    String address;
    Genre genre;

    public Publisher(String name, String address, Genre genre) {
        this.name = name;
        this.address = address;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return name + " (" + address + ")";
    }
}

class Library {
    Book book;
    Reader reader;
    Stuff staff;

    public Library(Book book, Reader reader, Stuff staff) {
        this.book = book;
        this.reader = reader;
        this.staff = staff;
    }

    @Override
    public String toString() {
        return book + " | Reader: " + reader + " | Staff: " + staff;
    }
}

public class LibraryDemo {
    public static void main(String[] args) {

        Genre fiction = new Genre("Fiction", "Fictional works");
        Genre sciFi = new Genre("Sci-Fi", "Science Fiction");

        Author author1 = new Author("John Smith", "USA", 10, fiction);
        Author author2 = new Author("Jane Doe", "UK", 5, sciFi);

        Book b1 = new Book("Book One", author1, fiction, 2020, "Penguin");
        Book b2 = new Book("Book Two", author2, sciFi, 2021, "HarperCollins");
        Book b3 = new Book("Book One", author1, fiction, 2020, "Penguin");
        Book b4 = new Book("Book Three", author2, sciFi, 2022, "Macmillan");

        List<Book> bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);

        System.out.println("1. Невпорядкований список:");
        for (Book b : bookList) System.out.println(b);

        Set<Book> bookSet = new HashSet<>(bookList);
        System.out.println("\n2. Унікальні книги (HashSet):");
        for (Book b : bookSet) System.out.println(b);

        Collections.sort(bookList);
        System.out.println("\n3. Відсортований список за назвою:");
        for (Book b : bookList) System.out.println(b);

        Set<Book> sortedBookSet = new TreeSet<>(bookList);
        System.out.println("\n4. Унікальні книги у відсортованому вигляді (TreeSet):");
        for (Book b : sortedBookSet) System.out.println(b);

        Map<String, Book> bookMap = new HashMap<>();
        for (Book b : bookList) {
            bookMap.put(b.title, b);
        }
        System.out.println("\n5. Map (ключ - назва книги):");
        for (String key : bookMap.keySet()) {
            System.out.println(key + " -> " + bookMap.get(key));
        }

        Queue<Book> bookQueue = new LinkedList<>();
        bookQueue.add(b1);
        bookQueue.add(b2);
        bookQueue.add(b4);

        System.out.println("\n6. Використання Queue:");
        while (!bookQueue.isEmpty()) {
            System.out.println("Видача книги: " + bookQueue.poll());
        }

        Reader r1 = new Reader("Ivan Petrenko", 101, 380991234567L);
        Reader r2 = new Reader("Olena Koval", 102, 380991234568L);

        Stuff s1 = new Stuff("Andrii Shevchenko", "Librarian", 380991234100L);
        Stuff s2 = new Stuff("Svitlana Bondarenko", "Assistant", 380991234101L);

        Publisher pub1 = new Publisher("Penguin", "NY, USA", fiction);
        Publisher pub2 = new Publisher("HarperCollins", "London, UK", sciFi);

        List<Library> records = new ArrayList<>();
        records.add(new Library(b1, r1, s1));
        records.add(new Library(b2, r2, s2));
        records.add(new Library(b4, r1, s2));

        System.out.println("\n7. Список читачів:");
        displayReaders(Arrays.asList(r1, r2));

        System.out.println("\n8. Персонал бібліотеки:");
        displayStuff(Arrays.asList(s1, s2));

        System.out.println("\n9. Записи бібліотеки:");
        displayLibraryRecords(records);
    }

    public static void displayReaders(List<Reader> readers) {
        for (Reader r : readers) {
            System.out.println(r);
        }
    }

    public static void displayStuff(List<Stuff> staffList) {
        for (Stuff s : staffList) {
            System.out.println(s);
        }
    }

    public static void displayLibraryRecords(List<Library> records) {
        for (Library l : records) {
            System.out.println(l);
        }
    }
}
