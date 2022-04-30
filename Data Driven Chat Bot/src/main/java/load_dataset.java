import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
public class load_dataset
{
    public static void main(String[] args) throws Exception
    {  System.out.print("loading data\n");
        //parsing a CSV file into Scanner class constructor
    }

    public static List<Book> Load_data() throws Exception {
        List<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(new File("D:\\downloads\\dataset.txt"));
        sc.useDelimiter(",");  //sets the delimiter pattern
        int i=0;
        while (sc.hasNext())  //returns a boolean value
        {
            String srno=sc.next();
            //System.out.print(srno+" ");
            String question =sc.next();
            //System.out.print(question+" ");
            String reply=sc.next();
            //System.out.print(reply+" \n");
            Book book = createBook(i,question,reply);// adding book into ArrayList
            books.add(book);
            i++;
        }
        sc.close(); //closes the scanner
        for (Book b : books) {
            //System.out.println(b);
        }

        return books;
    }
    private static Book createBook(int srno,String question,String repl ) {
        int serial_number = srno;
        String sentence =question;

        String reply = repl;

        // create and return book of this metadata
        return new Book(serial_number,sentence,reply);
    }


}

class Book {
    private String sentence;
    private int serial_number;
    private String reply;

    public Book() {
        this.serial_number =-1;
        this.sentence ="";
        this.reply ="";
    }
    public Book(int serial_number,String sentence,  String reply) {
        this.serial_number = serial_number;
        this.sentence = sentence;

        this.reply = reply;
    }

    public String getsentence() {
        return sentence;
    }

    public void setsentence(String sentence) {
        this.sentence = sentence;
    }

    public int getserial_number() {
        return serial_number;
    }

    public void setserial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public String getreply() {
        return reply;
    }

    public void setreply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Book [serial_number=" + serial_number + ",sentence=" + sentence + ",  reply=" + reply
                + "]";
    }

}

