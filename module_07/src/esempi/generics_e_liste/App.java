package module_07.src.esempi.generics_e_liste;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Contenitore<Integer, String> c1 = new Contenitore<>(42, "42");
        Contenitore<Integer, String> c2 = new Contenitore<>(5, "5");

        List myListNoGenerics = new ArrayList();
        myListNoGenerics.add(42);
        myListNoGenerics.add("42");
        myListNoGenerics.add(false);

        for (Object obj : myListNoGenerics) {
            // errore a tempo dinamico Integer myNewInt = (Integer) obj;

            if (obj instanceof Integer) {
                Integer myNewInt = (Integer) obj;
                System.out.println(myNewInt);
            }

        }

        ArrayList<Integer> myCollectionWithGeneric = new ArrayList<>();
        myCollectionWithGeneric.add(42);

        for (Integer myInt : myCollectionWithGeneric) {
            System.out.println(myInt);
        }

        for (int i = 0; i < 10; i++) {
            myCollectionWithGeneric.add(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(myCollectionWithGeneric.get(i));
        }

        /** */
        ArrayList<Contenitore<Integer, String>> myListContainer = new ArrayList<>();
        myListContainer.add(c1);
        myListContainer.add(c2);

        System.out.println(myListContainer);




        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Student());

        for (Person p : persons){
            System.out.println(p);

            Student sCast = (Student) p; 
            sCast.metodoSoloDiStudente(); 
        }


        myCollectionWithGeneric.contains(42); 
        myCollectionWithGeneric.indexOf(42); 
        
        /* 
        Errore statico
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Person());

        for (Student s : students)
            System.out.println(s);*/

    }
}
