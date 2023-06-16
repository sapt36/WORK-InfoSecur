import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToTxt4 {
	public static void main(String[] args) {
		//Load a.txt
		File file = new File("a.txt");
		String data = "";
		Scanner sc;
		try {
			sc = new Scanner(file);
			String line;
			while (sc.hasNext()) { 
				// Check if there is more input to be read
				line = sc.nextLine();
				int[] arr = new int[8];
				for (int i = 0; i < line.length(); i++) {
					// convert character to ASCII code and OctToBinary
					arr= OctToBinary((int)line.charAt(i)+4); 
					for(int j:arr) {
						data+=j;
					}
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.print("Stop");
		}
		//Write to b.txt
		try {
            FileWriter writer = new FileWriter("b.txt");
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		//b.txt binaryToASCII
        String result = "";
        try {
            // 讀取檔案
            String data2 = new String(Files.readAllBytes(Paths.get("b.txt")));

            // 將每八個數字轉換成ASCII字元(Use SubString)
            for (int i = 0; i < data2.length(); i += 8) {
                String byteStr = data2.substring(i, i + 8);
                int decimal = Integer.parseInt(byteStr, 2);
                char ch = (char) decimal;
                result+=ch;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
      //Write to c.txt
      try {
    	  FileWriter writer = new FileWriter("c.txt");
          writer.write(result);
          writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
		
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
}