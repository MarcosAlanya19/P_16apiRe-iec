import java.util.Scanner;
public class aFunction {
    //function S / N
    public static boolean toTryAgain() {
        System.out.println("\n¿Desea comprar algo mas?");
        System.out.println("S / N");
        Scanner value = new Scanner(System.in);
        String response = value.next();
        return (response.equalsIgnoreCase("S"));
    }
}
