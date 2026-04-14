public class Polisa {
    private String numerPolisy;
    private String klient;
    private double skladkaBazowa;
    private int poziomRyzyka;
    private double wartoscPojazdu;
    private boolean czyMaAlarm;
    private boolean czyBezszkodowyKlient;
    private static int liczbaUtworzonychPolis;
    private static final double OPLATA_ADMINISTRACYJNA = 100.0;


    public Polisa(String numerPolisy, String klient, double skladkaBazowa, int poziomRyzyka, double wartoscPojazdu,boolean czyMaAlarm, boolean czyBezszkodowyKlient ) {
        this.numerPolisy = numerPolisy;
        this.klient = klient;
        this.skladkaBazowa = skladkaBazowa;
        this.poziomRyzyka = poziomRyzyka;
        this.wartoscPojazdu = wartoscPojazdu;
        this.czyMaAlarm = czyMaAlarm;
        this.czyBezszkodowyKlient = czyBezszkodowyKlient;
        liczbaUtworzonychPolis++;

    }


    public void printPolisa() {
    System.out.println("Polisa: " + numerPolisy);
    System.out.println("Klient: " + klient);
    System.out.println("Skladka bazowa: " + skladkaBazowa);
    System.out.println("Poziom Ryzyka: " + poziomRyzyka);
    System.out.println("Wartosc Pojazd: " + wartoscPojazdu);
    System.out.println("Czy ma alarm: " + czyMaAlarm);
    System.out.println("Czy bezszkodowy klient: " + czyBezszkodowyKlient);
    }

    public static void printliczbaUtworzonychPolis() {
        System.out.println("Liczba utworzonych polis: " + liczbaUtworzonychPolis);
    }

    public double obliczSkladkeKoncowa(){
        double skladkaKoncowa = skladkaBazowa + OPLATA_ADMINISTRACYJNA + poziomRyzyka*120.0;
        if(wartoscPojazdu>40000){
            skladkaKoncowa = skladkaBazowa*1.2;
        }
        if(czyMaAlarm==true){
            skladkaKoncowa = skladkaBazowa-(skladkaKoncowa*0.1);
        }
        if(czyBezszkodowyKlient==true){
            skladkaKoncowa = skladkaBazowa-(skladkaKoncowa*0.3);
        }
        return skladkaKoncowa;
    }
    public double obliczSkladkeOdnowienia(){

    }
}
