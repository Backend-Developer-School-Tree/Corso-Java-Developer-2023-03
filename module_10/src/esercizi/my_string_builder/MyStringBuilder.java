package esercizi.my_string_builder;

public class MyStringBuilder
{
    private String str;

    public MyStringBuilder() { this.str = ""; }

    public MyStringBuilder(String str) { this.str = str; }

    public MyStringBuilder(char ch) { this(String.valueOf(ch)); }

    public MyStringBuilder append(String str) {
        this.str += str;
        return this;
    }

    public MyStringBuilder append(char ch) { return append(String.valueOf(ch)); }

    public String toString() { return build(); }

    public String build() { return str; }
}
