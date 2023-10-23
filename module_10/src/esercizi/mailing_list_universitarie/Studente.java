package esercizi.mailing_list_universitarie;

import java.util.ArrayList;
import java.util.List;

public class Studente implements Observer
{
    List<String> casellaUniversitaria = new ArrayList<>();
    List<Corso> corsi = new ArrayList<>();

    public void iscriviACorso(Corso corso) {
        corsi.add(corso);
        corso.iscriviStudente(this);
    }

    @Override
    public void update(String email) { casellaUniversitaria.add(email); }
}
