import javax.swing.*;
import java.util.Scanner;

public class fruits {
    public static void main(String[] args) {
        boolean retry;
        do {
            fruits.userFruit();
            retry = aFunction.toTryAgain();
        } while (retry);
        System.out.println("FIN DEL PROGRAMA");
//        System.out.println("\nCompraste "+kilo+" kl de "+listFruits[compra].fruta+" "+
//                "con un costo total de " + compras);
    }
    public static void userFruit() {

        Scanner store = new Scanner(System.in);

        // Solicitud de nombre para el cliente
        String nombre = JOptionPane.showInputDialog("Buen dia, ¿Cual es su nombre?");
        System.out.println("Que gusta comprar hoy? "+nombre );
        System.out.println("Por hoy solo tenemos estas frutas:");

        // Frutas en stock
        objectFruits listFruits[] = new objectFruits[3];
        listFruits[0]=new objectFruits(1,"Manzana",3.00);
        listFruits[1]=new objectFruits(2,"Mandarina",2.00);
        listFruits[2]=new objectFruits(3,"Uva", 4.00);

        // Recorrido de todas las frutas existentes
        for (int i = 0; i < listFruits.length; i++) {
            System.out.println(listFruits[i].id+".- "+listFruits[i].fruta +" a un costo de "+ listFruits[i].costo +" el kilo");
        }
        // Se menciona sobre los descuentos habientes
        System.out.println("Recuerda que hay un descuento de 20% por una compra mayor de 50 soles");

        // Opciones de compra
        int compra = JOptionPane.showOptionDialog(null,
                "¿Que fruta va a llevar?",
                "Compra a realizar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{listFruits[0].fruta,listFruits[1].fruta,listFruits[2].fruta}," ");

        // Consulta de kilos a llevar
        int kilo = Integer.parseInt(JOptionPane.showInputDialog("Cuantos kilos va a comprar"));

        // Algoritmo para calculo de compra
        double compras = listFruits[compra].costo * kilo;




        // Repetidor

        // Informacion de comprobante

    }
}

