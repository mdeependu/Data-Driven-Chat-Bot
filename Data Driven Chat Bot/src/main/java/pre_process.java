import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class pre_process {

    public static  List<List<String>> pre_processed_data() throws Exception
    {
        tokenization obj1=new tokenization();
        List<List<String>> tokenize_data=new ArrayList<>();
        tokenize_data=obj1.tokenize_sentence();
        for(int i=0;i<tokenize_data.size();i++) {
            List<String> flag=new ArrayList();
            flag=tokenize_data.get(i);
            for(int j=0;j<flag.size();j++){
                String item=new String();
                item=flag.get(j);
                //System.out.print(flag.get(j)+" ");
                flag.set(j,item.toLowerCase());
            }
            //System.out.print("\n");
        }
        //System.out.print(tokenize_data);
        for(int i=0;i<tokenize_data.size();i++) {
            List<String> flag=new ArrayList();
            flag=tokenize_data.get(i);
            for(int j=0;j<flag.size();j++){
                String item=new String();
                item=flag.get(j);
                //System.out.print(flag.get(j)+" ");
                flag.set(j,item.replaceAll("\\p{Punct}", ""));

            }
            //System.out.print("\n");
        }
        //System.out.print(tokenize_data);

        List<List<String>> rdata =new ArrayList();
        for(int i=0;i<tokenize_data.size();i++) {
            List<String> flag=new ArrayList();
            flag=tokenize_data.get(i);
            String stopwords[]= {"is","the","am","i","are","they","them","on","can","to","of","an","my","for","how","me","a","do","and","at","in","it"};
            List<String> stopwordlist=new ArrayList();
            stopwordlist.addAll(Arrays.asList(stopwords));
            List<String> wordlist=new ArrayList();
            wordlist=flag;
            wordlist.removeAll(stopwordlist);
            //System.out.print(wordlist);
            rdata.add(wordlist);
        }
        //System.out.print(rdata);
        return rdata;
    }
    //static List<List<String>> data =new ArrayList();
    public static void main(String[] args) throws Exception {
        String[] bog= new String[] {};
        List<List<String>> data =new ArrayList();
        data=pre_processed_data();
        //System.out.print(data);


    }





}
