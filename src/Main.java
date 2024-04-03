import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ServiciuAuto serviciu = new ServiciuAuto(); // Inițializăm serviciul auto

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            afisareMeniu();
            System.out.print("Introduceți opțiunea: ");
            optiune = scanner.nextInt();
            scanner.nextLine(); // Consumă newline

            switch (optiune) {
                case 1:
                    adaugaMasina(serviciu, scanner);
                    break;
                case 2:
                    programareMasina(serviciu, scanner);
                    break;
                case 3:
                    afiseazaMasini(serviciu);
                    break;
                case 4:
                    afiseazaProgramari(serviciu);
                    break;
                case 5:
                    afiseazaMecanici(serviciu);
                    break;
                case 6:
                    actualizeazaDetalii(serviciu, scanner);
                    break;
                case 7:
                    stergeElement(serviciu, scanner);
                    break;
                case 8:
                    afiseazaProgramariMecanic(serviciu, scanner);
                    break;

                case 9:
                    adaugaMecanic(serviciu,scanner);
                    break;
                case 10:
                    adaugaClient(serviciu,scanner);
                    break;
                case 0:
                    System.out.println("Aplicația a fost închisă.");
                    break;
                default:
                    System.out.println("Opțiune invalidă.");
                    break;
            }
        } while (optiune != 0);

        scanner.close();
    }


    private static void afisareMeniu() {
        System.out.println("\n===== Meniu =====");
        System.out.println("1. Adăugare mașină");
        System.out.println("2. Programare mașină");
        System.out.println("3. Afișare mașini");
        System.out.println("4. Afișare programări");
        System.out.println("5. Afișare mecanici");
        System.out.println("6. Actualizare detaliilor unei mașini sau programări");
        System.out.println("7. Ștergere mașină sau programare");
        System.out.println("8. Afișare programări pentru un anumit mecanic");
        System.out.println("9. Adaugare mecanic");
        System.out.println("10. Adaugare client");
        System.out.println("0. Ieșire");
        System.out.println("=================\n");
    }

    private static void adaugaMasina(ServiciuAuto serviciu, Scanner scanner) {
        System.out.print("Introduceți ID-ul mașinii: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumă newline
        System.out.print("Introduceți marca mașinii: ");
        String marca = scanner.nextLine();
        System.out.print("Introduceți modelul mașinii: ");
        String model = scanner.nextLine();
        System.out.print("Introduceți anul fabricației mașinii: ");
        int anFabricatie = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

        Masina masina = new Masina(id, marca, model, anFabricatie);
        serviciu.adaugaMasina(masina);
        System.out.println("Mașină adăugată cu succes.");
    }
    private static void adaugaMecanic(ServiciuAuto serviciu, Scanner scanner) {
        System.out.print("Introduceți ID-ul mecanicului: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumă newline
        System.out.print("Introduceți numele mecanicului: ");
        String nume = scanner.nextLine();
        System.out.print("Introduceți specializarea mecanicului: ");
        String specializare = scanner.nextLine();

        Mecanic mecanic = new Mecanic(id, nume, specializare);
        serviciu.adaugaMecanic(mecanic);
        System.out.println("Mecanic adăugat cu succes.");
    }

    private static void programareMasina(ServiciuAuto serviciu, Scanner scanner) {
        System.out.println("Introduceți detalii despre programare:");
        System.out.print("Introduceți ID-ul programării: ");
        int idProgramare = scanner.nextInt();
        scanner.nextLine(); // Consumă newline
        System.out.print("Introduceți ID-ul mașinii: ");
        int idMasina = scanner.nextInt();
        scanner.nextLine(); // Consumă newline
        System.out.print("Introduceți data programării (YYYY-MM-DD): ");
        String dataProgramareString = scanner.nextLine();
        System.out.print("Introduceți numele mecanicului: ");
        String numeMecanic = scanner.nextLine();

        Date dataProgramare = null;
        try {
            dataProgramare = new SimpleDateFormat("yyyy-MM-dd").parse(dataProgramareString);
        } catch (ParseException e) {
            System.out.println("Formatul datei este invalid. Reîncercați.");
            return;
        }

        Programare programare = new Programare(idProgramare, idMasina, dataProgramare, numeMecanic);
        serviciu.programareMasina(programare);
        System.out.println("Programare realizată cu succes.");
    }
    private static void afiseazaMasini(ServiciuAuto serviciu) {
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
    private static void adaugaClient(ServiciuAuto serviciu, Scanner scanner) {
        System.out.print("Introduceți ID-ul clientului: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumă newline
        System.out.print("Introduceți numele clientului: ");
        String nume = scanner.nextLine();
        System.out.print("Introduceți numărul de telefon al clientului: ");
        String telefon = scanner.nextLine();

        Client client = new Client(id, nume, telefon);
        serviciu.adaugaClient(client);
        System.out.println("Client adăugat cu succes.");
    }


    private static void afiseazaProgramari(ServiciuAuto serviciu) {
        List<Programare> programari = serviciu.getListaProgramari();
        if (programari.isEmpty()) {
            System.out.println("Nu există programări în baza de date.");
        } else {
            System.out.println("Programările existente:");
            for (Programare programare : programari) {
                System.out.println(programare);
            }
        }
    }

    private static void afiseazaMecanici(ServiciuAuto serviciu) {
        Set<Mecanic> mecanici = serviciu.getListaMecanici();
        if (mecanici.isEmpty()) {
            System.out.println("Nu există mecanici în baza de date.");
        } else {
            System.out.println("Mecanicii disponibili:");
            for (Mecanic mecanic : mecanici) {
                System.out.println(mecanic);
            }
        }
    }

    private static void actualizeazaDetalii(ServiciuAuto serviciu, Scanner scanner) {
        System.out.println("Ce doriți să actualizați?");
        System.out.println("1. Detalii mașină");
        System.out.println("2. Detalii programare");
        int optiune = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

        switch (optiune) {
            case 1:
                actualizeazaDetaliiMasina(serviciu, scanner);
                break;
            case 2:
                actualizeazaDetaliiProgramare(serviciu, scanner);
                break;
            default:
                System.out.println("Opțiune invalidă.");
                break;
        }
    }

    private static void actualizeazaDetaliiMasina(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaMasini(serviciu);
        System.out.print("Introduceți ID-ul mașinii pentru actualizare: ");
        int idMasina = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

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

    private static void actualizeazaDetaliiProgramare(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaProgramari(serviciu);
        System.out.print("Introduceți ID-ul programării pentru actualizare: ");
        int idProgramare = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

        Programare programare = serviciu.cautaProgramare(idProgramare);
        if (programare == null) {
            System.out.println("Programarea nu a fost găsită.");
        } else {
            System.out.print("Introduceți noua dată (YYYY-MM-DD): ");
            String newDataString = scanner.nextLine();
            Date newData = null;
            try {
                newData = new SimpleDateFormat("yyyy-MM-dd").parse(newDataString);
            } catch (ParseException e) {
                System.out.println("Formatul datei este invalid. Reîncercați.");
                return;
            }
            programare.setData(newData);

            System.out.println("Detaliile programării au fost actualizate cu succes.");
        }
    }

    private static void stergeElement(ServiciuAuto serviciu, Scanner scanner) {
        System.out.println("Ce doriți să ștergeți?");
        System.out.println("1. Mașină");
        System.out.println("2. Programare");
        int optiune = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

        switch (optiune) {
            case 1:
                stergeMasina(serviciu, scanner);
                break;
            case 2:
                stergeProgramare(serviciu, scanner);
                break;
            default:
                System.out.println("Opțiune invalidă.");
                break;
        }
    }

    private static void stergeMasina(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaMasini(serviciu);
        System.out.print("Introduceți ID-ul mașinii pentru ștergere: ");
        int idMasina = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

        if (serviciu.stergeMasina(idMasina)) {
            System.out.println("Mașina a fost ștearsă cu succes.");
        } else {
            System.out.println("Mașina nu a fost găsită.");
        }
    }

    private static void stergeProgramare(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaProgramari(serviciu);
        System.out.print("Introduceți ID-ul programării pentru ștergere: ");
        int idProgramare = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

        if (serviciu.stergeProgramare(idProgramare)) {
            System.out.println("Programarea a fost ștearsă cu succes.");
        } else {
            System.out.println("Programarea nu a fost găsită.");
        }
    }

    private static void afiseazaProgramariMecanic(ServiciuAuto serviciu, Scanner scanner) {
        System.out.print("Introduceți numele mecanicului: ");
        String numeMecanic = scanner.nextLine();
        List<Programare> programariMecanic = serviciu.getProgramariMecanic(numeMecanic);

        if (programariMecanic.isEmpty()) {
            System.out.println("Nu există programări pentru acest mecanic.");
        } else {
            System.out.println("Programările pentru mecanicul " + numeMecanic + ":");
            for (Programare programare : programariMecanic) {
                System.out.println(programare);
            }
        }
    }
}

