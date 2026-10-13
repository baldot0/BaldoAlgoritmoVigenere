import java.util.Scanner;

public static String elabora(String testo, int[] chiave, String direzione) {
    StringBuilder risultato = new StringBuilder();
    int indiceChiave = 0;

    for (int i = 0; i < testo.length(); i++) {
        Lettera lettera = new Lettera(testo.charAt(i));
        if (lettera.cifrabile()) {
            lettera.trasla(chiave[indiceChiave % chiave.length], direzione);
            indiceChiave++;
        }
        risultato.append(lettera.carattere);
    }
    return risultato.toString();
}

private static int leggiIntero(Scanner in, String messaggio) {
    while (true) {
        System.out.print(messaggio);
        String riga = in.nextLine().trim();
        try {
            return Integer.parseInt(riga);
        } catch (NumberFormatException e) {
            System.out.println("Valore non valido: inserisci un numero intero.");
        }
    }
}

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int lunghezza;
    do {
        lunghezza = leggiIntero(in, "Lunghezza della chiave (intero > 0): ");
        if (lunghezza <= 0) {
            System.out.println("La lunghezza deve essere maggiore di 0.");
        }
    } while (lunghezza <= 0);

    int[] chiave = new int[lunghezza];
    for (int i = 0; i < lunghezza; i++) {
        chiave[i] = leggiIntero(in, "Numero " + (i + 1) + " della chiave: ");
    }

    int scelta;
    do {
        scelta = leggiIntero(in, "Operazione (1 = cifratura, 2 = decifratura): ");
        if (scelta != 1 && scelta != 2) {
            System.out.println("Scelta non valida: inserisci 1 oppure 2.");
        }
    } while (scelta != 1 && scelta != 2);

    System.out.print("Testo: ");
    String testo = in.nextLine();

    String direzione = (scelta == 1) ? "+" : "-";
    System.out.println("Risultato: " + elabora(testo, chiave, direzione));

    in.close();
}