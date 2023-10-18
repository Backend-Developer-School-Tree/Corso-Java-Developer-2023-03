package esempi.annotations;

import lombok.*;

@Getter(AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @NonNull
    Integer id;
    @Setter @NonNull
    String nome;
    @Setter @ToString.Exclude
    String email;

    public static void main(String[] args) {
        new User();
        new User(1, "Andrea");
        User user = new User(1, "Andrea", "andrea@opinno.it");
        System.out.println(user);
        System.out.println(user.getEmail());
    }
}