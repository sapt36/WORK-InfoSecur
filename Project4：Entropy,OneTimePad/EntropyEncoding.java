import java.util.*;
import java.io.*;

public class EntropyEncoding {
    public static void main(String[] args) {
        //Load a.txt
		File file = new File("a.txt");
		String input = "";
		Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) { 
				// Check if there is more input to be read
				input = sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.print("Stop");
		}

        // Calculate frequency of each character
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        // Build Huffman tree
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.offer(node);
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }
        Node root = pq.poll();

        // Generate Huffman codes
        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        // Encode input using Huffman codes
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sb.append(codes.get(c));
        }
        String encoded = sb.toString();

        // Output Huffman codes and encoded message
        System.out.println("Huffman codes:");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Encoded message:");
        System.out.println(encoded);
    }

    private static void generateCodes(Node node, String code, Map<Character, String> codes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            codes.put(node.c, code);
            return;
        }
        generateCodes(node.left, code + "0", codes);
        generateCodes(node.right, code + "1", codes);
    }

    private static class Node {
        char c;
        int freq;
        Node left;
        Node right;

        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    private static class NodeComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            return n1.freq - n2.freq;
        }
    }
}
