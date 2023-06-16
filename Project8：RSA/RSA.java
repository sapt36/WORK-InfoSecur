import java.math.BigInteger;

public class RSA {
    public static void main(String[] args) {
        // Given values
        BigInteger p = new BigInteger("5");
        BigInteger q = new BigInteger("11");
        BigInteger e = new BigInteger("13");
        BigInteger M1 = new BigInteger("18");
        BigInteger C2 = new BigInteger("20");

        // Step 1: Calculate N=p*q
        BigInteger N = p.multiply(q);

        // Step 2: Calculate φ(N)=(p-1)*(q-1)
        BigInteger olaN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Step 3: Calculate e*d mod φ(N) = 1
        BigInteger d = e.modInverse(olaN);
	System.out.println(d);

        // (1) Encryption C=M^e mod N
        BigInteger C1 = M1.modPow(e, N);
        System.out.println("(1) When M = " + M1 + ", C = " + C1);

        // (2) Decryption M=C^d mod N
        BigInteger M2 = C2.modPow(d, N);
        System.out.println("(2) When C = " + C2 + ", M = " + M2);
    }
}
