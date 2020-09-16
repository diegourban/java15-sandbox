package urban.sandbox.java15.jep378;

public class Main {

    public static void main(final String[] args) {
        String htmlTheOldWay = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, World!</p>\n" +
                "    </body>\n" +
                "</html>\n";

        System.out.println(htmlTheOldWay);

        String htmlWithTextBlock = """
                <html>
                    <body>
                        <p>Hello, World!</p>
                    </body>
                </html>
                """;

        System.out.println(htmlWithTextBlock);

        System.out.println("Equal? " + htmlTheOldWay.equals(htmlWithTextBlock));
    }

}
