import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class tfidf {
    static List<List<Integer>> vect=new ArrayList();
    static List<String> bag=new ArrayList();
    public static void main(String[] args) throws Exception {

    }

    public static List<Float> cosine_similarity(String question) throws Exception {
        List<List<Integer>> vect=new ArrayList();
        bag_of_words obj1 =new bag_of_words();
        vect =obj1.bagofwords();
        List<String> bag=new ArrayList();
        bag=obj1.bog;
        //System.out.print("\n "+vect.size()+"\n"+bag);

        List<String> q_token=new ArrayList();
        StringTokenizer st = new StringTokenizer(question," ");
        List<String> token_obj1=new ArrayList();
        while (st.hasMoreTokens()) {
            String word_token=st.nextToken();
            q_token.add(word_token);
        }
        for (int i =0;i<q_token.size();i++)
        {
            String a=q_token.get(i);
            q_token.set(i, a.toLowerCase());
            q_token.set(i,a.replaceAll("\\p{Punct}", ""));
        }
        //System.out.print(q_token);
        List<Integer> q_vect = new ArrayList();
        //System.out.print(bag.size());
        for(int i=0 ;i<bag.size();i++) {
            //System.out.print(bag.get(i));
            if(q_token.contains(bag.get(i))) {
                q_vect.add(1);
            }
            else {
                q_vect.add(0);
            }
        }
        //System.out.print(q_vect);
        List<Float> similar =new ArrayList();
        for(int i=0 ;i<vect.size();i++) {
            //System.out.print(vect.get(i));
            double s = dot_product(vect.get(i),q_vect);
            double m1=mod(vect.get(i));
            double m2=mod(q_vect);
            float sim =(float) (s/(m1*m2));
            similar.add(sim);
        }
        //System.out.print(similar);
        return similar;
    }

    public static double dot_product(List<Integer> a,List<Integer> b)	{
        float sum=0;
        for(int i=0;i<a.size();i++) {
            sum=sum+(a.get(i)*b.get(i));
        }
        return sum;
    }
    public static double mod(List<Integer> a) {
        float sum=0;
        for(int i=0;i<a.size();i++) {
            sum=sum+(a.get(i)*a.get(i));
        }
        return Math.sqrt(sum);
    }

}
