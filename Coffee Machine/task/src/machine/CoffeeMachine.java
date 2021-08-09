package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Machine coffeeMachine = new Machine();

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");

            command = scanner.nextLine();

            if (command.matches("(buy|fill|take|remaining|exit)")) {
                coffeeMachine.toDo(command);
            }

        }
    }

}
