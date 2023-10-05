package esempi.persona;

import java.util.Objects;

public class Professore extends Persona{
    private int id;

    public Professore(String name) {
        super(name);
    }

    @Override
    public void sayMyName(){
        super.sayMyName();
        System.out.println("Sono un professore");
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        //Cast da classe Object a classe Professore
        Professore that = (Professore) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
