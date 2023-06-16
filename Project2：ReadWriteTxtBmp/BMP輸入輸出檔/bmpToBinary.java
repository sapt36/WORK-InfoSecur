import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class bmpToBinary {
    public static void main(String[] args) throws IOException {
        File file = new File("Img_File.bmp"); //read file(import java.io.File
        byte[] byteArray = new byte[(int) file.length()];

        try (FileInputStream inputStream = new FileInputStream(file)) {
            int readBytes = inputStream.read(byteArray);
            if (readBytes != file.length()) {
                throw new IOException("Failed to read the entire file");
            }
        }
        int[] arr = new int[8];
        for (int i = 0; i < byteArray.length; i++) {
			// convert number to Binary
        	if(byteArray[i]<0) {
        		arr = twoComplement(OctToBinary(byteArray[i]));
        	}
        	else {
        		arr = OctToBinary(byteArray[i]);
        	}
			for(int j:arr) {
				System.out.print(j);
			}
		}
    }
    public static int[] OctToBinary(int input) {
        int num = 0;
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
    public static int[] twoComplement(int[] arr) {
    	for(int i=0; i<8 ; i++) {
    		if(arr[i]>0) {
    			arr[i] = 0;
    		}
    		else {
    			arr[i] = 1;
    		}
    	}
    	int carry = 1;
    	for(int i=7; i>=0 ; i--) {
    		arr[i] = arr[i] + carry;
    		if(arr[i]>1) {
    			arr[i] = 0;
    		}
    		else {
    			break;
    		}
    	}
    	return arr;
    }
}
