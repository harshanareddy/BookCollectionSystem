import java.util.Scanner;

public class BookCollectionSystem {

    static Scanner scan = new Scanner(System.in);
    static BookCollection bc = new BookCollection();
    public static void main(String[] args) {

        System.out.println("Hey harsh, what are you reading lately, you wanna add something in your collection?");
        System.out.println("If yes, type 'y'");

        String response = scan.nextLine();
        
        if(response.equals("y")){
            addBookToCollection();
        }

        String repeatResponse = "n";

        while(true){
            String searchTitle;

            System.out.println("Do you wanna perform some actions? Here's the list:");
            System.out.println("1. Display all of your collection");
            System.out.println("2. Remove any book");
            System.out.println("3. Search a book on title");
            System.out.println("4. Search angsty books");
            System.out.println("5. Search wanna read again books");
            System.out.println("6. Update rating of any book");
            System.out.println("7. Update read again status of any book");

            int action = Integer.parseInt(scan.nextLine());

            switch(action){
                case 1:
                        bc.displayMyCollection();
                        break;
                
                case 2:
                        System.out.println("Can you say the title of the book you wanna remove");
                        searchTitle = scan.nextLine();
                        System.out.println(bc.removeBook(searchTitle));
                        break;

                case 3:
                        System.out.println("Can you say the title of the book you wanna search");
                        searchTitle = scan.nextLine();
                        System.out.println(bc.getBook(searchTitle));
                        break;
                
                case 4:
                        bc.displayAngstyBooks();
                        break;
                
                case 5:
                        bc.displayWannaReadAgainBooks();
                        break;
                
                case 6:
                        System.out.println("Can you tell me the title of the book");
                        searchTitle = scan.nextLine();
                        System.out.println("what's your updated rating");
                        double rating = Double.parseDouble(scan.nextLine());
                        System.out.println(bc.updateBookRating(searchTitle, rating));
                        break;

                case 7:
                        System.out.println("Can you tell me the title of the book");
                        searchTitle = scan.nextLine();
                        System.out.println("what's your updated status? yes/no");
                        String status = scan.nextLine();
                        System.out.println(bc.updateReadAgainStatus(searchTitle, status));
                        break;

                default:
                        System.out.println("Thanks darling, have a good day <3");      
                        
            }

            System.out.println("wanna do something else, babe? y/n");
            repeatResponse = scan.nextLine(); 

            if(repeatResponse.equals("n")){
                break;
            }
        }

        

    }

    public static void addBookToCollection(){
        while(true){
            System.out.println("Can you give me some details about the book hon");
        
            System.out.println("Title");
            String title = scan.nextLine();
            
            System.out.println("Author");
            String author = scan.nextLine();
            
            System.out.println("How much do you wanna rate this book?");
            double myRating = Double.parseDouble(scan.nextLine());
            
            System.out.println("Pages");
            int pages = Integer.parseInt(scan.nextLine());
            
            System.out.println("Do you think it's an angsty book? true/false");
            boolean isAngsty = Boolean.parseBoolean(scan.nextLine());
            
            System.out.println("Can you describe it in few words");
            String introToBook = scan.nextLine();
            
            System.out.println("Which category do you think it falls into, here's the list:");
            for(Category c: Category.values()){
                System.out.println("- "+c);
            }

            System.out.println("Type the category as shown");
            String categoryInput = scan.nextLine().toUpperCase();

            Category category;

            try{
                category = Category.valueOf(categoryInput);
            }catch(IllegalArgumentException e){
                System.out.println("Oops! there is no such category sweetie. Defaulting to FICTION");
                category = Category.GENERAL_FICTION;
            }


            System.out.println("Will you read it again in future? yes/no");
            String wannaReadAgain = scan.nextLine();
            
            Book b = new Book(title, author, myRating, pages, isAngsty, introToBook, category, wannaReadAgain);
            bc.addBook(b);

            System.out.println("Yay! your book has been added");
            System.out.println("You have "+bc.getCollectionSize()+" books in your shelf, bookworm");
            System.out.println("Do you wanna add some more? y/n");

            String repeatAdding = scan.nextLine();
            if(repeatAdding.equalsIgnoreCase("n")){
                break;
            }

        }
    }
        
}
