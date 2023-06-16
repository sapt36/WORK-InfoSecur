import java.util.*;
import java.io.*;

public class bmpPlus4writeToTxt {
	public static void main(String[] args) {
		//Load a.txt
		File file = new File("BmpBinary4.txt");
		int outNum;
		int[] arr = new int[8];
		String str = "",s="";
		Scanner sc;
		try {
			sc = new Scanner(file);
			String line;
			while (sc.hasNext()) { 
				// Check if there is more input to be read
				line = sc.next();
				if(BiToOct(line)>131) {
					outNum = BiToOct(line)-1;//outNum為二補數的數字-1==一補數的數字
					arr = OctToBinary(outNum);//arr為一補數
					arr = oneComplement(arr);//arr為原數的binary
					str="";
					for(int i=0;i<8;i++){
			            str = str + arr[i] + "";   
			        }
			        s = s + (-(BiToOct(str))-4) + "";
				}
				else {
					s = s + (BiToOct(line)-4) + "";
				}
				System.out.print(" ");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.print("Stop at load file");
		}
		
		// Writing in file gfg.txt
        try {
            FileOutputStream fileOut
                = new FileOutputStream("output.bmp");
            s = "GeeksforGeeks";
  
            // converting string into byte array
            byte b[] = s.getBytes();
            fileOut.write(b);
            fileOut.close();
            System.out.println(
                "file is successfully updated!!");
        }
        catch (Exception e) {
            System.out.println("Stop at output stream");
        }
	}
	static int BiToOct(String str){
        int i,output = 0,str_len;
        str_len = str.length();
        char[] s=new char[16];
        for(int j=0;j < str_len ; j++) {
        	s[j]=str.charAt(j);
        }
        for(i = 0 ; i < str_len ; i++)
        {
        	output+= (s[i]-'0') * power(2,str_len-i-1);
        }
        return output;
    }
    static int power(int x,int y){
        int i;
        int result = x;
        if(y==0)
            return 1;
        for(i=1;i<y;i++)
            result*=x;
               
        return result;
    }
    public static int[] OctToBinary(int input) {
        int[] arr = new int[8];
        int[] arrRev = new int[8];
        for(int i = 0; i<8 ; i++) {
        	arr[i] = 0;
        }
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
        int p=8;
        for(int i=0;i<8;i++) {
        	arrRev[p-1]=arr[i];
        	p = p-1;
        }
        return arrRev;
    }
    public static int[] oneComplement(int[] arr) {
    	for(int i=0; i<8 ; i++) {
    		if(arr[i]>0) {
    			arr[i] = 0;
    		}
    		else {
    			arr[i] = 1;
    		}
    	}
    	return arr;
    }
}