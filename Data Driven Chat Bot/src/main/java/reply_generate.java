import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class reply_generate {
    public static void main(String args[])  {

    }

    public String getReply(String question) throws Exception{
        tfidf obj1 =new tfidf();

        List<Float> simila =new ArrayList();

        simila=obj1.cosine_similarity(question);
        load_dataset data = new load_dataset();
        List<Book> b=data.Load_data();
        //System.out.print(b.get(0));

        Float maxVal = Collections.max(simila); // should return 7
        Integer maxIdx = simila.indexOf(maxVal);
        //System.out.print(b.get(maxIdx));
        Book obj2=new Book();
        obj2=b.get(maxIdx);
        System.out.print(obj2.getreply());
        return (obj2.getreply());
    }
}
