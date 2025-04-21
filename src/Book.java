public class Book{
    private String title;
    private String author;
    private double myRating;
    private int pages;
    private boolean isAngsty;
    private String introToBook;
    private Category category;
    private String wannaReadAgain;

    public Book(String title, String author, double myRating, int pages, boolean isAngsty, String introToBook, Category category, String wannaReadAgain){
        this.title = title;
        this.author = author;
        this.myRating = myRating;
        this.pages = pages;
        this.isAngsty = isAngsty;
        this.introToBook = introToBook;
        this.category = category;
        this.wannaReadAgain = wannaReadAgain;
    }

    public void updateRating(double myRating){
        this.myRating = myRating;
    }

    public void updateReadAgain(String wannaReadAgain){
        this.wannaReadAgain = wannaReadAgain;
    }

    @Override
    public String toString() {
        return "Book Details:\n" +
           "------------------------\n" +
           "Title             : " + title + "\n" +
           "Author            : " + author + "\n" +
           "Rating            : " + myRating + "\n" +
           "Pages             : " + pages + "\n" +
           "Is Angsty?        : " + isAngsty + "\n" +
           "Intro to Book     : " + introToBook + "\n" +
           "Category          : " + category + "\n" +
           "Read Again Status : " + wannaReadAgain + "\n";
    }

    public String getTitle(){
        return title;
    }

    public Boolean getIsAngsty(){
        return isAngsty;
    }

    public String getWannaReadAgainBook(){
        return wannaReadAgain;
    }

}



