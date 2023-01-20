import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        List<String> cartItems = new ArrayList<String>();

        Console cons = System.console();
        String input = "";
        while (!input.equals("quit")) {         
            input = cons.readLine("What do you like to do? (type 'help' to show list of commands)");

            if (input.equals("help")) {
                System.out.println("'list' to show a list of items in shopping cart");
                System.out.println("add <item name>");
                System.out.println("delete <item number>");
                System.out.println("'quit' to exit program");
            } 

            if (input.equals("list")) {

                if (cartItems.size() > 0) {
                    // for (String item: cartItems)
                    //     System.out.printf("%s\n", item);

                    for (int i = 0; i < cartItems.size(); i++)
                        System.out.printf("%d: %s\n", i, cartItems.get(i));
                } else {
                    System.out.println("Your cart is empty");
                }
            }

            if (input.startsWith("add")) {
                input = input.replace(',', ' ');

                String stringVal = "";
                Scanner scan = new Scanner(input.substring(4));

                while(scan.hasNext()) {
                    stringVal = scan.next();
                    // System.out.printf("%s\n", stringVal);
                    cartItems.add(stringVal);
                }
            }

            if (input.startsWith("delete")) {
                String stringVal = "";
                Scanner scan = new Scanner(input.substring(6));

                while(scan.hasNext()) {
                    stringVal = scan.next();

                    int listItemIndex = Integer.parseInt(stringVal);

                    if (listItemIndex < cartItems.size()) {
                        cartItems.remove(listItemIndex);
                    } else {
                        System.out.println("Incorrect item index");
                    }

                }
            }
        }

        System.out.println("Goodbye!!! See you again... ...");
    }
}
