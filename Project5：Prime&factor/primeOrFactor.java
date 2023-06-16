import java.util.Scanner;

public class primeOrFactor{    
	static void checkPrime(int n){  
		int i,m=0,flag=0;      
		m=n/2;      
		if(n==0||n==1){  
			System.out.println(n+" is not prime number");      
		}else{  
			for(i=2;i<=m;i++){      
				if(n%i==0){      
					System.out.println(n+" is not prime number");      
					flag=1;      
					break;      
				}      
			}      
			if(flag==0)  { System.out.println(n+" is prime number"); }  
		}//end of else  
	}
	public static String primeFactors(int number) {
        int n = number;
        String str = "";
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
            	str = str + i + "*";
                n /= i;
            }
        }
        return str;
    }
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int i = sc.nextInt();
		String str = "";
		checkPrime(i);
		System.out.print("Primefactors of "+i+" = ");
		str = primeFactors(i);
        String str_mul = str.substring(0,str.length()-1);
        System.out.println(str_mul);
        sc.close();
	}    
}