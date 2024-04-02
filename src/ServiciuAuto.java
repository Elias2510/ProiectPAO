import java.util.*;

public class ServiciuAuto {
    private List<Masina> listaMasini;
    private List<Programare> listaProgramari;
    private Set<Mecanic> listaMecanici;

    public ServiciuAuto() {
        listaMasini = new ArrayList<>();
        listaProgramari = new ArrayList<>();
        listaMecanici = new HashSet<>();
    }

    // Metode pentru gestionarea listei de mașini
    public void adaugaMasina(Masina masina) {
        listaMasini.add(masina);
    }

    public List<Masina> getListaMasini() {
        return listaMasini;
    }

    public Masina cautaMasina(int id) {
        for (Masina masina : listaMasini) {
            if (masina.getId() == id) {
                return masina;
            }
        }
        return null;
    }

    public boolean stergeMasina(int id) {
        Masina masina = cautaMasina(id);
        if (masina != null) {
            listaMasini.remove(masina);
            return true;
        }
        return false;
    }

    // Metode pentru gestionarea listei de programări
    public void programareMasina(Programare programare) {
        listaProgramari.add(programare);
    }

    public List<Programare> getListaProgramari() {
        return listaProgramari;
    }

    public Programare cautaProgramare(int id) {
        for (Programare programare : listaProgramari) {
            if (programare.getId() == id) {
                return programare;
            }
        }
        return null;
    }

    public boolean stergeProgramare(int id) {
        Programare programare = cautaProgramare(id);
        if (programare != null) {
            listaProgramari.remove(programare);
            return true;
        }
        return false;
    }

    public List<Programare> getProgramariMecanic(String numeMecanic) {
        List<Programare> programariMecanic = new ArrayList<>();
        for (Programare programare : listaProgramari) {
            if (programare.getNumeMecanic().equals(numeMecanic)) {
                programariMecanic.add(programare);
            }
        }
        return programariMecanic;
    }

    // Metode pentru gestionarea setului de mecanici
    public void adaugaMecanic(Mecanic mecanic) {
        listaMecanici.add(mecanic);
    }

    public Set<Mecanic> getListaMecanici() {
        return listaMecanici;
    }
}
