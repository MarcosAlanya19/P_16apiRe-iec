import java.util.Scanner;

public class act {
    public static void main(String[] args) {
        Scanner pro = new Scanner(System.in);
        System.out.println("Numero");
        int n = pro.nextInt();
        int s=0;

        for (int i = 0; i <= n; i++) {
            s = s + i;
        }
        System.out.println("Suma: "+s);
    }
}
