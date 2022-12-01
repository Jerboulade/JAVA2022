package be.technifutur.decouverte.api.texte;

public class StringTest
{
    public static void main(String[] args)
    {
        isEqual();
        testStringBuilder();
        testStringBloc();
    }

    public static void isEqual()
    {
        String s1 = "coucou";
        String s2 = "cou";
        String s3 = s2 + s2;

        System.out.println(s3 == s1); // /!\ address comparaison
        System.out.println(s3.equals(s1)); // String comparaison
    }

    public static void testStringBuilder()
    {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder("cou");

        s1.append("coucou petite perruche");
        s2.append("cou petite perruche")
                .append(2)
                .append(true)
                .replace(0, 6, "ciao");
        System.out.printf("%s\n%s", s1, s2);
    }

    public static void testStringBloc()
    {
        String s = """
                \n\033[31;1mpetit
                \033[32;1mtexte
                \033[33;1men
                \033[34;1mplusieurs
                \033[35;1mlignes
                """;
        System.out.print(s);
    }
}
