package esercizi.conto_bancario;

import java.time.LocalDateTime;

public abstract class Operazione {

    private static int idGlobal = 0;

    private final int id = idGlobal++;

    private final LocalDateTime creazione = LocalDateTime.now();

    private ContoBancario contoBancario;

    abstract void esegui();

    public int getId() { return id; }
    public LocalDateTime getCreazione() { return creazione; }

    public void setContoBancario(ContoBancario contoBancario) {
        this.contoBancario = contoBancario;
    }

    public ContoBancario getContoBancario() { return this.contoBancario; }

    @Override
    public String toString() {
        return "Operazione{" +
                "id=" + id +
                ", creazione=" + creazione +
                ", contoBancario=" + contoBancario +
                '}';
    }
}
