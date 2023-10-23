package esempi.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Con Lombok possiamo usare il pattern Builder aggiungendo l'annotazione @Builder alla classe
// senza necessità di implementarlo da zero come in questo esempio
// @Builder
public class User
{
    private String firstName;
    private String lastName;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    private static class Builder
    {
        private String firstName;
        private String lastName;

        public Builder() {}

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build() { return new User(this); }
    }

    public static void main(String[] args) {
        User.Builder ub = new Builder();
        ub.firstName("Andrea");
        ub.lastName("Gasparini");
        User u = ub.build();

        // per concatenare le chiamate ai metodi del builder, dobbiamo tornare l'istanza (this) e non void
        User u2 = new Builder()
                .firstName("Andrea")
                .lastName("Gasparini")
                .build();


        // StringBuilder è un esempio concreto di applicazione del pattern Builder che possiamo utilizzare tutti i giorni
        String s = new StringBuilder()
                // operazioni intermedie analoghe ai metodi che settano i campi (.firstName, .lastName, ecc)
                .append("hello")
                .append(" world!")
                // operazione terminale analoga al metodo .build()
                .toString();


        List<User> users = new ArrayList<>();
        // anche i Java Stream (che vedremo nel prossimo modulo) hanno un'implementazione analoga a quella del pattern Builder
        users.stream()
                // operazioni intermedie analoghe ai metodi che settano i campi (.firstName, .lastName, ecc)
                .filter(user -> user.firstName.equals("Andrea"))
                .map(user -> user.firstName)
                // operazione terminale analoga al metodo .build()
                .collect(Collectors.toList());
    }
}
