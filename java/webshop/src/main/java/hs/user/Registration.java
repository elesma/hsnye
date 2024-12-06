package hs.user;

import com.fasterxml.jackson.databind.ObjectMapper; //Jackson könyvtár importálása
import java.io.File; //File kezeléshez
import java.util.ArrayList; // Lista használata
import java.util.List; // Lista használata

/**
 *  Az osztály felelős az ügyfelek regisztrációjáért és kezeléséért.
 *  Az ügyfelek adatait egy JSON fileban tárolja.
 */
public class Registration {
    /**
     * A regisztrált ügyfelek listája.
     **/
    private List<Customer> customers;

    /**
     * A JSON file elérési útja, amely az ügyfelek adatait tartalmazza.
     **/
    private final String filepath = "customers.json";

    /**
     * Konstruktor, amely betölti az ügyfeleket a JSON file-ból.
     **/

    public Registration() {
        this.customers = loadCustomers();
    }

    /**
     * Ügyfelek betöltése a JSON fiile-ból.
     **/
    private List<Customer> loadCustomers() {
        ObjectMapper objectMapper = new ObjectMapper();  // Jackson ObjectMapper példány
        try {
            return objectMapper.readValue(new File(filepath),
                    objectMapper.getTypeFactory().constructCollectionType
                            (List.class, Customer.class));
        } catch (Exception e) {
            return new ArrayList<>(); // Ha hiba történik üres lista.
        }
    }

    /**
     * Új ügyfél regisztrálása.
     */
    public boolean registerCustomer(String customerId,
                                    String username,
                                    String password,
                                    String name,
                                    String address,
                                    String phoneNumber,
                                    String email)
    {

        /**
         * Ellenőrizzük, hogy a felhasználónév már létezik-e.
         */
        for (Customer customer : customers) {
            if (customer.getName().equals(username)) {
                return false; // A felhasználónév már foglalt.
            }
        }

        /**
         *  új ügyfél létrehozása.
         */

        Customer newCustomer = new Customer(customerId, username, password, name,
                address, phoneNumber, email, new ArrayList<>());
        customers.add(newCustomer); // Ügyfél hozzáadása a listához.
        saveCustomers();  // Ügxfelek mentése a file-ba.
        return true; // Sikeres regisztráció
    }

    /**
     * Ügyfelek mentése a JSON file-ba.
     */
    private void saveCustomers() {
        ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper példány
        try {
            objectMapper.writeValue(new File(filepath), customers);
        } catch (Exception e) {
            e.printStackTrace(); // Hibakezelés
        }
    }
}
