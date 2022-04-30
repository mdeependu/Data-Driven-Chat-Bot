import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class tokenization {

    static  List<String> token(String sentence) {

        //System.out.println("inside tokenization function");
        //System.out.println(sentence);
        StringTokenizer st = new StringTokenizer(sentence," ");
        List<String> token_obj1=new ArrayList();
        while (st.hasMoreTokens()) {
            //System.out.println(st.nextToken());
            String word_token=st.nextToken();
            token_obj1.add(word_token);
            //System.out.print(word_token+" ");
        }
        return token_obj1;

    }

    public  List<List<String>> tokenize_sentence() throws Exception {
        load_dataset data = new load_dataset();
        List<Book> b=data.Load_data();
        //System.out.print(b.size()+"\n");
        List<List<String>> sentence_list=new ArrayList();
        for(int i=0;i<b.size();i++) {
            Book obj1=new Book();
            obj1=b.get(i);
            String flag =obj1.getsentence();
            //System.out.print(flag);
            List<String> token_obj1=new ArrayList();
            token_obj1= token(flag);
            sentence_list.add(token_obj1);
            //System.out.println(token_obj1);
        }
        return sentence_list;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");

    }

}
