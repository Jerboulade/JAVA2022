package be.technifutur.decouverte.testinterface;

public class HelloWorldAnonymousClasses {
    private String name;

    public HelloWorldAnonymousClasses(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* interface interne à la classe */
    interface HelloWorld {
        public void greet();

        public void greetSomeone(String someone);
    }

    public void sayHello(String other) {
        final String format;
        if (!"name".equals("toto")) {
            format = "%s: \"%s %s\" %n";
        } else {
            format = "%s: \"%s %s\" toto %n";
        }

        /* classe interne anonyme*/
        HelloWorld englishGreeting = new HelloWorld() {
            String name = "Hello";

            @Override
            public void greet() {
                greetSomeone("world");
            }

            @Override
            public void greetSomeone(String name) {
                System.out.printf(format, HelloWorldAnonymousClasses.this.name, this.name, name);
            }
        };

        /* classe interne à une méthode*/
        class FrenchGreeting implements HelloWorld {
            String salutation = "salut";

            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.printf(format, name, this.salutation, someone);
            }
        }

        HelloWorld frenchGreeting = new FrenchGreeting();

        englishGreeting.greet();
        englishGreeting.greetSomeone("dédé");
        englishGreeting.greetSomeone(other);
        frenchGreeting.greet();
        frenchGreeting.greetSomeone("dédé");
        frenchGreeting.greetSomeone(other);
    }

    public void test() {
    }
}

