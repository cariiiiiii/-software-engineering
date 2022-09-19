
public class hw3 {
 public static void main(String[] args) {
     int i,j;  
     int c=0;     
          for(i=2;i<=10000;i++) {  
                for( j=2;j<i;j++) {
                       if (i%j==0) 
                       break;
                 }
    if (j>=i) {
     System.out.print(" "+i+"\t");    
    c++;                  
    if (c==5) {           
     System.out.println();
     c=0;
    }
    }
  }
 }
}