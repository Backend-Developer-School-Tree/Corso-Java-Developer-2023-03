package module_07.src.esempi.generics_e_liste;

public class Contenitore<T, S> {

    private T myGenericVar;
    private S mySecondGenericVar;

    public Contenitore(T myGenericVar) {
        this.myGenericVar = myGenericVar;
    }

    public Contenitore(T myGenericVar, S mySecondGenericVar) {
        this.myGenericVar = myGenericVar;
        this.mySecondGenericVar = mySecondGenericVar; 
    }

    public T getMyIstanceVar() {
        return myGenericVar;
    }

    public void setMyGenericVar(T myGenericVar) {
        this.myGenericVar = myGenericVar;
    }

    @Override
    public String toString() {
        return "Contenitore [myGenericVar=" + myGenericVar + ", myInt=" + mySecondGenericVar + "]";
    }

}