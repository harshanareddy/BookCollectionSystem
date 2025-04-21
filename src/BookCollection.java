import java.util.ArrayList;

public class BookCollection {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public Book searchBook(String title){
        for(Book b: books){
            if(b.getTitle().equalsIgnoreCase(title)){
                return b;
            }
        }

        return null;
    }

    public String getBook(String title){
        Book b = searchBook(title);
        if(b!=null){
            return b.toString();
        }

        return "Your collection doesn't seem to have the book you are searching for";

    }

    public String removeBook(String titleBook){

        Book b = searchBook(titleBook);
        if(b!=null){
            books.remove(b);
            return "Done sweetie";
        }else{
            return "You don't have any such book hon";
        }
        
    }

    public void displayMyCollection(){
        if(books.isEmpty()){
            System.out.println("Your book collection is empty hon");
        }else{
            for(Book b: books){
                System.out.println(b);
                System.out.println();
            }
        }
        
    }

    public void displayAngstyBooks(){
        boolean found = false;
        for(Book b: books){
            if(b.getIsAngsty()){
                System.out.println(b);
                found = true;
            }
        }

        if(!found){
            System.out.println("You don't seem to have angsty books");
        }
    }

    public void displayWannaReadAgainBooks(){
        boolean found = false;
        for(Book b: books){
            if(b.getWannaReadAgainBook().equalsIgnoreCase("yes")){
                System.out.println(b);
                found = true;
            }
        }

        if(!found){
            System.out.println("You don't seem to have wanna read again books in your collection sweetie");
        }
    }

    public int getCollectionSize(){
        return books.size();
    }

    public String updateBookRating(String titleBook, double rating){
        Book b = searchBook(titleBook);
        if(b!= null){
            b.updateRating(rating);
            return "Your rating is updated";
        }else{
            return "You don't have any such book hon";
        }
    }

    public String updateReadAgainStatus(String titleBook, String status){
        Book b = searchBook(titleBook);
        if(b!= null){
            b.updateReadAgain(status);
            return "Your read again status of this book is updated";
        }else{
            return "You don't have any such book hon";
        }
    }
}
