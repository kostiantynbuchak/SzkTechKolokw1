package com.example.zad3;

import java.util.*;

public class RezystorApp {
    public static void main(String[] args) {
        ///lista oporników z wartościami oporów w Ω
        List<Double> oporniki = Arrays.asList(220.0, 100.0, 330.0, 470.0, 10.0, 56.0);

        /// Sortujemy oporniki
        oporniki.sort(Collections.reverseOrder());

        ///posortowane oporniki
        System.out.println("Oporniki posortowane (Ω):");
        for (int i = 0; i < oporniki.size(); i++) {
            // Drukujemy numer i wartość opornika
            System.out.println((i + 1) + ": " + oporniki.get(i) + " Ω");
        }

        ///obiekt Scanner do wczytywania danych od użytkownika
        Scanner scanner = new Scanner(System.in);

        ///typ połączenia
        System.out.print("Typ połączenia (szeregowe/równoległe): ");
        String typ = scanner.nextLine().toLowerCase();

        ///numer pierwszego opornika
        System.out.print("Nr pierwszego opornika: ");
        int start = scanner.nextInt() - 1;

        ///ostatniego opornika
        System.out.print("Nr ostatniego opornika: ");
        int end = scanner.nextInt() - 1;

        ///czy zakres jest prawidłowy
        if (start < 0 || end >= oporniki.size() || start > end) {
            // Jeśli zakres jest nieprawidłowy, wyświetlamy komunikat o błędzie
            System.out.println("Nieprawidłowy zakres.");
            return;
        }

        ///podlista oporników na podstawie podanych indeksów
        List<Double> wybrane = oporniki.subList(start, end + 1);
        double oporZastepczy;

        //opór zastępczy
        if (typ.equals("szeregowe")) {
            ///sumujemy opory
            oporZastepczy = wybrane.stream().mapToDouble(Double::doubleValue).sum();

        } else if (typ.equals("równoległe")) {
            ///obliczamy odwrotności oporów i sumujemy je
            oporZastepczy = 1 / wybrane.stream().mapToDouble(r -> 1 / r).sum();
        } else {
            ///nieznany = blęd
            System.out.println("Nieznany typ połączenia.");
            return;
        }

        // Wyświetlamy wynik obliczeń
        System.out.printf("Opór zastępczy: %.2f Ω", oporZastepczy);
    }
}
