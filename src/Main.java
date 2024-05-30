import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiciuAuto serviciu = new ServiciuAuto();
        InterfataUtilizator interfata = new InterfataUtilizator();
        MasinaService masinaService = new MasinaService();
        MecanicService mecanicService = new MecanicService();
        ProgramareService programareService = new ProgramareService();

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            interfata.afisareMeniu();
            System.out.print("Introduceți opțiunea: ");
            optiune = interfata.citireNumar();

            switch (optiune) {
                case 1:
                    masinaService.adaugaMasina(serviciu, scanner);
                    break;
                case 2:
                    programareService.programareMasina(serviciu, scanner);
                    break;
                case 3:
                    masinaService.afiseazaMasini(serviciu);
                    break;
                case 4:
                    programareService.afiseazaProgramari(serviciu);
                    break;
                case 5:
                    mecanicService.afiseazaMecanici(serviciu);
                    break;
                case 6:
                    actualizeazaDetalii(serviciu, scanner, masinaService, programareService);
                    break;
                case 7:
                    stergeElement(serviciu, scanner, masinaService, programareService);
                    break;
                case 8:
                    mecanicService.afiseazaProgramariMecanic(serviciu, scanner);
                    break;
                case 9:
                    mecanicService.adaugaMecanic(serviciu, scanner);
                    break;
                case 10:
                    adaugaClient(serviciu, scanner);
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

    private static void actualizeazaDetalii(ServiciuAuto serviciu, Scanner scanner, MasinaService masinaService, ProgramareService programareService) {
        System.out.println("Ce doriți să actualizați?");
        System.out.println("1. Detalii mașină");
        System.out.println("2. Detalii programare");
        int optiune = scanner.nextInt();
        scanner.nextLine();

        switch (optiune) {
            case 1:
                masinaService.actualizeazaDetaliiMasina(serviciu, scanner);
                break;
            case 2:
                programareService.actualizeazaDetaliiProgramare(serviciu, scanner);
                break;
            default:
                System.out.println("Opțiune invalidă.");
                break;
        }
    }

    private static void stergeElement(ServiciuAuto serviciu, Scanner scanner, MasinaService masinaService, ProgramareService programareService) {
        System.out.println("Ce doriți să ștergeți?");
        System.out.println("1. Mașină");
        System.out.println("2. Programare");
        int optiune = scanner.nextInt();
        scanner.nextLine();

        switch (optiune) {
            case 1:
                masinaService.stergeMasina(serviciu, scanner);
                break;
            case 2:
                programareService.stergeProgramare(serviciu, scanner);
                break;
            default:
                System.out.println("Opțiune invalidă.");
                break;
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
}

