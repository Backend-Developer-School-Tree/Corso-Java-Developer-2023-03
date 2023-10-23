package esercizi.my_string_builder;

public class Test
{
    public static void main(String[] args) {
        MyStringBuilder msb = new MyStringBuilder();

        msb.append("Facilissimo")
                .append(" concatenare")
                .append(" stringhe!");

        String finalString = msb.toString();

        System.out.println(finalString.equals("Facilissimo concatenare stringhe!"));
        System.out.println(finalString);
    }
}
