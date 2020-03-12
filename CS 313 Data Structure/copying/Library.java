package copying;

public class Library implements Cloneable {
    private Book[] books;
    private String name;

    public Library(String name, Book[] books)
    {
        this.name = name;
        this.books = books;
    }

    //what kind of copy is this? Note: we already know that Book's clone() returns a shallow copy
    @Override
    public Library clone() {
        try {
            Library other = (Library) super.clone();
            other.books = new Book[this.books.length];
            for (int i = 0; i < books.length; i++) {
                other.books[i] = this.books[i].clone();
            }
            return other;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
