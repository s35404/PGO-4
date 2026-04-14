import java.util.Objects;

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


    public Polisa(String numerPolisy, String klient, double skladkaBazowa, int poziomRyzyka, double wartoscPojazdu, boolean czyMaAlarm, boolean czyBezszkodowyKlient) {
        this.numerPolisy = numerPolisy;
        this.klient = klient;
        this.skladkaBazowa = skladkaBazowa;
        this.poziomRyzyka = poziomRyzyka;
        this.wartoscPojazdu = wartoscPojazdu;
        this.czyMaAlarm = czyMaAlarm;
        this.czyBezszkodowyKlient = czyBezszkodowyKlient;
        liczbaUtworzonychPolis++;

    }

    public String getNumerPolisy() {
        return numerPolisy;


    }

    public double obliczSkladkeKoncowa() {
        double skladka = skladkaBazowa + OPLATA_ADMINISTRACYJNA + poziomRyzyka * 120.0;
        if (wartoscPojazdu > 40000) {
            skladka = skladkaBazowa * 1.2;
        }
        if (czyMaAlarm == true) {
            skladka = skladkaBazowa - (skladka * 0.1);
        }
        if (czyBezszkodowyKlient == true) {
            skladka = skladkaBazowa - (skladka * 0.3);
        }
        return skladka;
    }

    public double obliczSkladkeOdnowienia() {
        double baza = obliczSkladkeKoncowa();
        double nowa = baza;
        if (poziomRyzyka == 4) {
            nowa *= 1.10;
        }
        else if (poziomRyzyka >= 5) {
            nowa *= 1.20;
        }
        if (wartoscPojazdu > 50000) {
            nowa += 400;
        }
        if (czyMaAlarm == true) {
            nowa *= 0.92;
        }
        if (czyBezszkodowyKlient == true) {
            nowa *= 0.85;
        }
        double minSkladka = baza * 0.9;
        double maxSkladka = baza * 1.25;

        if (nowa < minSkladka) {
            nowa = minSkladka;
        }
        if (nowa > maxSkladka) {
            nowa = maxSkladka;
        }
        return nowa;
    }
    public String pobierzPodsumowanieRyzyka() {
        if (poziomRyzyka >= 4) {
            return "Wysokie Ryzyko";
        } else if (poziomRyzyka == 3) {
            return "Srednie Ryzyko";
        } else {
            return "Niskie Ryzyko";
        }
    }

    public static int pobierzLiczbeUtworzonychPolis() {
        return liczbaUtworzonychPolis;
    }

    public String toString() {
        return "Polisa: " + numerPolisy + ", klient: " + klient + ", skladkaKoncowa: " + obliczSkladkeKoncowa();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polisa)) return false;
        Polisa polisa = (Polisa) o;
        return Objects.equals(numerPolisy, polisa.numerPolisy);
    }
}
