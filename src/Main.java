public class Main {
    public static void main(String[] args) {


        Polisa p1 = new Polisa("CAR-111", "Anna Nowak", 900.0, 3, 9000.0, true, true);
        p1.printPolisa();
        Polisa p2 = new Polisa("CAR-654", "Piotr Lis", 840.0, 4, 32000.0, false, false);
        p2.printPolisa();
        Polisa p3 = new Polisa("CAR-561", "Thragg Emperori", 900.0, 2, 56000.0, true, false);
        p3.printPolisa();

        biuro.dodajPolise(p1);
        biuro.dodajPolise(p2);
        biuro.dodajPolise(p3);

        biuro.wypiszRaport();
        System.out.println("Laczna skladka: " + biuro.policzLacznaSkladke());
        System.out.println("Laczna prognoza odnowien: " + biuro.policzLacznaPrognozeOdnowien());
        System.out.println("Polisy wysokiego ryzyka: " + biuro.policzPolisyWysokiegoRyzyka());
        System.out.println("Liczba utworzonych polis: " + Polisa.pobierzLiczbeUtworzonychPolis());

        System.out.println(p1.pobierzPodsumowanieRyzyka());
        System.out.println("Prognoza odnowienia dla p1: " + p1.obliczSkladkeOdnowieniowa());
        System.out.println(p1.equals(new Polisa("CAR-101", "Inny klient", 700.0, 1, 30000.0, false, false)));
        System.out.println(p2);

        Polisa znaleziona = biuro.znajdzPoNumerze("CAR-102");
        System.out.println("Znaleziono: " + znaleziona);

    }
}