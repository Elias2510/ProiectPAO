import java.util.List;
import java.util.Scanner;

public class MasinaService {
    public void adaugaMasina(ServiciuAuto serviciu, Scanner scanner) {
        System.out.print("Introduceți ID-ul mașinii: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduceți marca mașinii: ");
        String marca = scanner.nextLine();
        System.out.print("Introduceți modelul mașinii: ");
        String model = scanner.nextLine();
        System.out.print("Introduceți anul fabricației mașinii: ");
        int anFabricatie = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Este mașina electrică? (da/nu): ");
        String raspuns = scanner.nextLine();
        if (raspuns.equalsIgnoreCase("da")) {
            System.out.print("Introduceți autonomia mașinii: ");
            int autonomie = scanner.nextInt();
            scanner.nextLine();

            Masina masina = new MasinaElectrica(id, marca, model, anFabricatie, autonomie);
            serviciu.adaugaMasina(masina);
            System.out.println("Mașină electrică adăugată cu succes.");
        } else {
            Masina masina = new Masina(id, marca, model, anFabricatie);
            serviciu.adaugaMasina(masina);
            System.out.println("Mașină adăugată cu succes.");
        }
    }

    public void afiseazaMasini(ServiciuAuto serviciu) {
        List<Masina> masini = serviciu.getListaMasini();
        if (masini.isEmpty()) {
            System.out.println("Nu există mașini în baza de date.");
        } else {
            System.out.println("Mașinile din baza de date:");
            for (Masina masina : masini) {
                System.out.println(masina);
            }
        }
    }

    public void stergeMasina(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaMasini(serviciu);
        System.out.print("Introduceți ID-ul mașinii pentru ștergere: ");
        int idMasina = scanner.nextInt();
        scanner.nextLine();

        if (serviciu.stergeMasina(idMasina)) {
            System.out.println("Mașina a fost ștearsă cu succes.");
        } else {
            System.out.println("Mașina nu a fost găsită.");
        }
    }

    public void actualizeazaDetaliiMasina(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaMasini(serviciu);
        System.out.print("Introduceți ID-ul mașinii pentru actualizare: ");
        int idMasina = scanner.nextInt();
        scanner.nextLine();

        Masina masina = serviciu.cautaMasina(idMasina);
        if (masina == null) {
            System.out.println("Mașina nu a fost găsită.");
        } else {
            System.out.print("Introduceți noua marcă: ");
            String marca = scanner.nextLine();
            masina.setMarca(marca);

            System.out.print("Introduceți noul model: ");
            String model = scanner.nextLine();
            masina.setModel(model);

            System.out.println("Detaliile mașinii au fost actualizate cu succes.");
        }
    }
}
