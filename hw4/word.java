import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class word {
    public static void main(String[] args)throws IOException
    {
         File file = new File("I Have a Dream.txt");
         System.out.println("1.统计英文单词个数"+"  "+"2.统计字母个数");
         Scanner sc = new Scanner(System.in);
         int value=sc.nextInt();
      
         switch(value) {
        
                  case 1:txtString2(file);
                         break;
                  case 2:txtString(file);
                 
         }
         }
  
    
    
  
    public static void txtString(File file) throws IOException{
        try {
           
            FileReader fr = new FileReader(file);
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(fr);    
            HashMap<String,Integer> hm = new HashMap<String,Integer>();
            String line =null;
            Integer count = 0;
            Integer total = 0;
            char ch;
            while ((line=br.readLine())!=null) {
                for(int j=0;j<line.length();j++) {
                     ch=line.charAt(j); 
                   if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) {
                  total = total + 1;
               
                    count=hm.get(ch+"");
                   if(count==null) {
                       count=1;
                   }
                   else {
                       count++;
                   }
                   hm.put(ch+"",count); 
                   }
                }
            }
            /*
            
            for (String str : hm.keySet()) {
                lv=list.get(list.size()-i-1).getValue()*1.0/total*100;
                System.out.println(str+"个数:"+hm.get(str)+"        "+String.format("%.2f", lv)+"%");   
            }*/
            System.out.println("总字母个数："+total);
            
            List<Map.Entry<String ,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(hm.entrySet());
         
                  Comparator<Map.Entry<String,Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                      public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
                          return (left.getValue().compareTo(right.getValue()));
                      }
                  };
         
                  Collections.sort(list,comparator);
                  double lv=0;
                  for(int i=0;i<52;i++){
                      lv=list.get(list.size()-i-1).getValue()*1.0/total*100;
                      System.out.println(list.get(list.size()-i-1).getKey() +":"+list.get(list.size()-i-1).getValue()+"    "+String.format("%.2f", lv)+"%");
                  }
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
  
     public static void txtString2(File file)  throws IOException{
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         StringBuffer sb = new StringBuffer();
         String line =null;
         while ((line=br.readLine())!=null){
            sb.append(line);
        }     
        fr.close();

             String str = sb.toString().toLowerCase(); 
             String[] words = str.split("[^(a-zA-Z)]+"); 
             Map<String ,Integer> map = new HashMap<String, Integer>() ;
             for(String word :words){
                 if(map.get(word)==null){  
                     map.put(word,1);
                 }else{
                     map.put(word,map.get(word)+1); 
                 }
             }
            List<Map.Entry<String ,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
             Comparator<Map.Entry<String,Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                 public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
                  int i=left.getValue()-right.getValue();
                     if(i==0) {
                      return (right.getKey().compareTo(left.getKey()));
                     }
                     return (left.getValue().compareTo(right.getValue()));
                 }
             };
           
           
             Collections.sort(list,comparator);
             int n=list.size();
             
             System.out.println("一共有"+n+"个单词");
           
             for(int i=0;i<n;i++){
                 System.out.print(list.get(list.size()-i-1).getKey() +":"+list.get(list.size()-i-1).getValue()+"  ");
             }
     }         
}