import java.util.List;
import java.util.ArrayList;
public class bag_of_words  {
    static List<String> bog= new  ArrayList();
    public static void main(String args[]) throws Exception  {
        System.out.print(" in bag of words ");
    }
    public static List<List<Integer>> bagofwords() throws Exception
    {
        pre_process obj1=new pre_process();
        List<List<String>> data1 =new ArrayList();
        data1=obj1.pre_processed_data();

        for (int i=0;i<data1.size();i++)
        {
            List<String> flag =data1.get(i);
            for(int j=0;j<flag.size();j++)
            {
                String item =flag.get(j);
                //System.out.print(item+" ");

                if(bog.contains(item)) {
                    ;
                }
                else{
                    bog.add(item);
                }
            }
        }
//System.out.print(bog);
//System.out.print(bog.size());
        List<List<Integer>> vect=new ArrayList();
        for(int i=0;i<data1.size();i++) {
            List<Integer> v=new ArrayList();
            List<String> flag =data1.get(i);
            for(int j=0;j<bog.size();j++) {
                if(flag.contains(bog.get(j))){
                    v.add(1);
                }
                else {
                    v.add(0);
                }

            }
            //System.out.print(v+"\n");
            vect.add(v);
        }
//System.out.print(vect);
        return vect;
    }
}