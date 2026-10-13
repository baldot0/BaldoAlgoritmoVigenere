
public class Lettera {

    public static final int MIN = 32;
    public static final int MAX = 126;
    public static final int NUM_CARATTERI = MAX - MIN + 1; // 95

    public char carattere;

    public Lettera(char carattere) {
        this.carattere = carattere;
    }

    public boolean cifrabile() {
        return carattere >= MIN && carattere <= MAX;
    }

    public void trasla(int salto, String direzione) {
        if (!cifrabile()) {
            return;
        }
        int spostamento = direzione.equals("-") ? -salto : salto;
        int posizione = carattere - MIN;
        int nuova = (((posizione + spostamento) % NUM_CARATTERI) + NUM_CARATTERI) % NUM_CARATTERI;
        carattere = (char) (nuova + MIN);
    }
}