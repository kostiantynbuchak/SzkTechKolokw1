package com.example.zad2;

import java.util.*;
import java.util.stream.Collectors;
//1.	Tworzymy klasę student
// ID, Imie, Nazwisko
class Student {
    int ident;
    String imie;
    String nazwisko;
    int ocena;

    public Student(int ident,String imie, String nazwisko, int ocena) {
        this.ident = ident;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        //ID musi byc w formacie Wxxxxx
        return "w"+ ident + " " imie + " " + nazwisko + " - ocena: " + ocena;
    }
}

public class StudentApp {
    //Wpisujemy 5 wartości to klasy Student (int,str,str,int)
    public static void main(String[] args) {
        List<Student> studenci = Arrays.asList(
                new Student(68136,"Kostiantyn", "Buchak", 4),
                new Student(10129,"Marek", "Giebultowski", 5),
                new Student(10192,"Andrzej", "Duda", 5),
                new Student(78193,"Oleh", "Winnik", 3),
                new Student(69121,"Kowal", "Jaszuk", 2)
        );
//3.	Dodamy funkcje wyszukiwania (Scanner)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ocenę do wyszukania: ");
        int szukanaOcena = scanner.nextInt();

        List<Student> wynik = studenci.stream()
                .filter(s -> s.ocena == szukanaOcena)
                .collect(Collectors.toList());
//„brak studentów” w przypadku, kiedy podanej oceny nie ma w liśćie
        if (wynik.isEmpty()) {
            System.out.println("Brak studentów z oceną " + szukanaOcena);
        } else {
            System.out.println("Studenci z oceną " + szukanaOcena + ":");
            wynik.forEach(System.out::println);
        }
    }
}