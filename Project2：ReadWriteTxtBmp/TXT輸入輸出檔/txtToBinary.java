package test;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {    
		File file = new File("a.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			String line;
			while (sc.hasNext()) { 
				// Check if there is more input to be read
				line = sc.next();
				int[] arr = new int[8];
				for (int i = 0; i < line.length(); i++) {
					// convert character to ASCII code and OctToBinary
					arr= OctToBinary((int)line.charAt(i));
					for(int j:arr) {
						System.out.print(j);
					}
					System.out.print("00100000");
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.print("Stop");
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

}



