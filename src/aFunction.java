import java.util.Scanner;
public class aFunction {
    //function S / N
    public static boolean toTryAgain() {
        System.out.println(ANSI_WHITE+"\n¿Desea comprar algo mas?"+ANSI_WHITE);
        System.out.println("S / N");
        Scanner value = new Scanner(System.in);
        String response = value.next();
        return (response.equalsIgnoreCase("S"));
    }
    public static final String ANSI_WHITE = "\u001B[37m";
}
