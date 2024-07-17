package org.example;

import jspas.VilleRepository;
import jspas.Villes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VilleRepository villeRepo = new VilleRepository();

        Villes paris = new Villes(11, "Paris");
        Villes lyon = new Villes(20, "Lyon");
        Villes marseille = new Villes(30, "Marseille");

        villeRepo.ajouterVille(paris);
        villeRepo.ajouterVille(lyon);
        villeRepo.ajouterVille(marseille);

        // Tester la recherches par ID
        String nomVille = villeRepo.findById(2);
        System.out.println("Ville trouvée avec ID 2: " + nomVille);
    }
}
