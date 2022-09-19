
import java.util.Scanner;

public class hw2 {

    public static int max(int m,int n){
        return m>n ? m :n;
    }

    public static int maxSubArrayMethodFour(int arr[]){
        int n=arr.length;
        int nAll=arr[0];     
        int nEnd=arr[0];     

        for(int i=1;i<n;i++){
            nEnd=max(nEnd+arr[i],arr[i]);
            nAll=max(nEnd,nAll);
        }

        return nAll;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=Integer.parseInt(sc.next());
        
        int[] num=new int[number];

       
        for(int i=0;i<number;i++){
            num[i]=(int)sc.nextInt();
        }
        System.out.println(maxSubArrayMethodFour(num));

    }
}
