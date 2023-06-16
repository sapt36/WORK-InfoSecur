import java.util.*;

public class BinaryToOct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("請輸入二進位數：");
        String str,outStr = "";
        int i,output = 0,str_len;
        str = in.next();
        str_len = str.length();
        char[] s=new char[24];
        for(int j=0;j < str_len ; j++) {
        	s[j]=str.charAt(j);
        }
        for(i = 0 ; i < str_len ; i++)
        {
        	output+= (s[i]-'0') * power(2,str_len-i-1);
        	if(i==0) {
        		outStr = s[i] + "*" +power(2,str_len-i-1);
        	}
        	else {
        		outStr = outStr + "+" + s[i] + "*" +power(2,str_len-i-1);
        	}
        }
        System.out.println(outStr + "=" + output);
        System.out.println(str+" 轉換為十進制："+output);
    }
    static int power(int x,int y)
    {
        int i;
        int result = x;
        if(y==0)
            return 1;
        for(i=1;i<y;i++)
            result*=x;
               
        return result;
    }
} 