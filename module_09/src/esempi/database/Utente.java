package esempi.database;

public record Utente(int id, String nome)
{
    public static Utente readByCsv(String utenteString)
    {
        // separiamo gli attributi sulle virgole
        String[] attributi = utenteString.split(","); // ["1", "andrea", ...]
        // creiamo un oggetto utente a partire dagli attributi recuperati dalla riga del csv
        return new Utente(Integer.parseInt(attributi[0]), attributi[1]);
    }

    public String toCsv() {
        return id + "," + nome;
    }
}
