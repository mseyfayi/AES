import java.util.Scanner;

public class DiffieHellman {
    private int p;
    private int g;
    private int a;
    private int b;

    private DiffieHellman(int p, int g, int a, int b) {
        this.p = p;
        this.g = g;
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int g = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        DiffieHellman diffieHellman = new DiffieHellman(p, g, a, b);
        double A = diffieHellman.getA();
        int B = diffieHellman.getB();
        int K = diffieHellman.getK();
        System.out.println(String.format("%.0f %d %d", A, B, K));
    }

    private int getK() {
        return modularExponential(getA(), b, p);
    }

    private int getB() {
        return modularExponential(g, b, p);
    }

    private int getA() {
        return modularExponential(g, a, p);
    }

    // (x^y) mod p
    private int modularExponential(int x, int y, int p) {
        x = x % p;
        if (x == 0) return 0;

        int res = 1;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }
}
