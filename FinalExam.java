import java.util.Scanner;
/*Name : Daniyal Awan
 Roll No : 20SW107*/

public class FinalExam {

    // factorial function
    static long factorial (int n){//fac starts
        if(n<2){
            return 1;
        }
        return n*factorial(n-1);
    }//ends

    //fibonaaci series function
    static long fab(int n){//fab starts
        if (n<1)
            return 0;

        if (n<3)
            return 1;

            return fab(n - 1)+fab(n - 2);

    }//ends

    //fab series1 function
    static long fab1(int n){
        if(n<2)
            return 0;
        long f0 = 0 , f1 = 1 , f2 = 1;
        for (int i = 2; i < n; i++){
            f0 = f1;
            f1 = f2;
            f2 = f1 + f0;
        }
        return f2;
    }

    // creating hanoi function to move disks from one place to another in the same order
    static void hanoi (int n, char s, char d, char a){//func starts
        if (n==1)
            System.out.println(s + " --> " + a);

        else {
            hanoi (n-1,s ,d ,a);
            System.out.println(s + " --> " + a);
            hanoi (n-1,d,a,s);
        }
    }//ends

    public static void main(String[] args) {

     /* Calculating Factorial of given number
     Scanner sc = new Scanner(System.in);
        int x;
        int fact = 1;

        System.out.println("Enter the number :");
        x = sc.nextInt();

        for (int i = x; i >= 1; i-- ){
            fact = fact * i;
            System.out.println("fact of "+ x + " = " + fact);
        }*/

        //calling factorial function
        // System.out.println(factorial(5));

        //calling fab function
        //System.out.println(fab(7));

        //calculating time consumed in processing the result of fab series
       /* for (int n = 30; n<=40; n++){
            long t0 = System.currentTimeMillis();
            long m = fab(n);
            long t1 = System.currentTimeMillis();
            System.out.println("Fab of "+ n +"is :"+ m +"\\time:" + (t1 - t0));
        }*/

        //calling fab1
        //System.out.println(fab1(7));

        //calling hanoi function
        int disks = 2;
        hanoi(disks,'A','B','C');
    }
}
