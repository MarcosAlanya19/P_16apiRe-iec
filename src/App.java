import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IOException {
       boolean retry;
        do {
            App.userFruit();
            retry = Utils.toTryAgain();
        } while (retry);
        System.out.println("GRACIAS POR SU COMPRA, VUELVA PRONTO");
    }

    public static void userFruit() throws IOException {
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_CYAN = "\u001B[36m";
        Scanner store = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        // Frutas en stock
        Fruit[] listFruits = new Fruit[3];
        listFruits[0] = new Fruit(1, "Manzana", 3.00);
        listFruits[1] = new Fruit(2, "Mandarina", 2.00);
        listFruits[2] = new Fruit(3, "Uva", 4.00);

        // Solicitud de nombre para el cliente
        String documento = JOptionPane.showInputDialog("Buen dia, ¿Cual es su DNI o RUC?");

        String razonSocial = "";
        String dirEmpresa = Utils.findRucDir(documento);

        if (documento.length()>8){
            razonSocial = Utils.findRuc(documento);
            dirEmpresa = Utils.findRucDir(documento);
        }else{
            razonSocial = Utils.findDni(documento);
        }

        System.out.println("Que gusta comprar hoy? ");
        System.out.println("Por hoy solo tenemos estas frutas:");

        // Recorrido de todas las frutas existentes
        for (int i = 0; i < listFruits.length; i++) {
            System.out.println(listFruits[i].id + ".- " + listFruits[i].fruta + " a un " +
                    "costo de " + listFruits[i].costo + " el kilo");
        }

        // Se menciona sobre los descuentos habientes
        System.out.println("Descuento 20% por compras mayores a S/ 50.00");
        System.out.println("Descuento 40% por compras mayores a S/100.00");
        System.out.println("Descuento 50% por compras mayores a S/150.00");

        // Opciones de compra
        int compra = JOptionPane.showOptionDialog(null,
                "¿Que fruta va a llevar?",
                "Compra a realizar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{listFruits[0].fruta, listFruits[1].fruta, listFruits[2].fruta}, " ");

        // Consulta de kilos a llevar
        double kilo = Double.parseDouble(JOptionPane.showInputDialog("¿Cuantos kilos va a comprar?"));

        // Algoritmos
        double compras = listFruits[compra].costo * kilo;
        double baseI = compras / 1.18;
        double IGV = (compras / 1.18) * 0.18;

        LocalDate todaysDate = LocalDate.now();
        //Descuentos
        double descuento = 0;
        df.format(descuento);

        if (compras > 50) {
            descuento = compras * 0.20;
        } else if (compras > 100) {
            descuento = compras * 0.40;
        } else if (compras > 150) {
            descuento = compras * 0.50;
        } else {
            System.out.println("Descuento no valido");
        }

        // Informacion de comprobante
        System.out.println(ANSI_YELLOW + "\nEl cliente: " + razonSocial+ANSI_YELLOW);

        if (dirEmpresa.length()==25){
            System.out.println(" ");
        }else{
            System.out.println("Su direccion es: "+dirEmpresa);
        }

        System.out.println(ANSI_YELLOW+"El dia: " + todaysDate +
                "\nCompro: "+df.format(kilo)+" kl de "+listFruits[compra].fruta+"\nPrecio por kilo: S/."+df.format(listFruits[compra].costo)+ANSI_YELLOW);
        System.out.println(ANSI_YELLOW+"\nBase imponible: S/."+df.format(baseI)+"\nIGV: S/."+df.format(IGV)+"\nPrecio neto: S/."+df.format(compras)+ANSI_YELLOW);
        if (descuento > 50) {
            System.out.println(ANSI_CYAN + "\nCon un descuento de S/." + df.format(descuento) +
                    "\nTeniendo que " +
                    "pagar un " +
                    "total de: S/." + (compras - descuento) + ANSI_CYAN);
        }
    }
}

