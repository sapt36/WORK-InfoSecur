import java.util.*;

public class OctToBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        int[] arr = new int[8];
        for(int i = 0; i<8 ; i++) {
        	arr[i] = 0;
        }
        int input = in.nextInt();
        int j = 0;
        while(input!=0) {
        	if(input % 2 == 0) {
        		input = input/2;
        		j++;
        	}
        	else {
        		arr[j] = 1;
        		input = input/2;
        		j++;
        	}
        }
        for(int i=7;i>=0;i--) {
        	System.out.print(arr[i]);
        }
    }
}