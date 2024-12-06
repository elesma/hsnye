package hs;

import hs.user.Registration;

/**
 * A Main osztály a Webshop alkalmazás belépési pontja.
 * Ez az osztály felelős a felhasználói regisztrációs folyamat elindításáért.
 */
public class Main {

    /**
     * A program belépési pontja.
     * @param args a parancssori argumentumok, amelyek a program indításakor átadhatók
     */
    public static void main(String[] args) {
        Registration registration = new Registration(); // Regisztrációs példány létrehozása

        // Regisztráljunk egy új felhasználót
        boolean success = registration.registerCustomer(
                 "1D",
                "Kis_Pista",
                "password123",
                "Pista_Kis",
        "Nyíregyháza",
                "123-456",
        "pista@gmail.com");

        if (success) {
            System.out.println("Registration successful!"); // Sikeres regisztráció üzenet
        } else {
            System.out.println("Username already taken."); // Felhasználónév már foglalt üzenet
        }
    }
}