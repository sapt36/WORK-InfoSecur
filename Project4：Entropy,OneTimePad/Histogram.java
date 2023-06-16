import java.util.Scanner;

public class Histogram{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入英文字串：");
        String input = scanner.nextLine();

        int[] freq = new int[128]; // 0-127 為ASCII code 的範圍
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.print((char) i +"("+(int) i+")"+ ":\t");
                for (int j = 0; j < freq[i]; j++) {
                    System.out.print(".");
                }
                System.out.println();
            }
        }
    }
}
