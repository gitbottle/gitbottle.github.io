package copying;

public class Book implements Cloneable {
    private String isbn;
    private String title;
    private Author author;

    public Book (String isbn, String title, Author author)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    //what sort of copy is this?- shallow copy
    @Override
    public Book clone()  {
        try {
            return (Book) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
