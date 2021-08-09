package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {

    private long water = 400;
    private long milk = 540;
    private long beans = 120;
    private long cups = 9;
    private long money = 550;

    final static Scanner scanner = new Scanner(System.in);

    public long getWater() {
        return water;
    }

    public long getMilk() {
        return milk;
    }

    public long getBeans() {
        return beans;
    }

    public void setWater(long water) {
        this.water = water;
    }

    public void setMilk(long milk) {
        this.milk = milk;
    }

    public void setBeans(long beans) {
        this.beans = beans;
    }

    public long getCups() {
        return cups;
    }

    public long getMoney() {
        return money;
    }

    public void setCups(long cups) {
        this.cups = cups;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void buyEspresso() {

        List<String> whatIsNotEnough = new ArrayList<>();

        if (this.getWater() - 250 < 0) whatIsNotEnough.add("water");
        if (this.getBeans() - 16 < 0) whatIsNotEnough.add("beans");
        if (this.getCups() - 1 < 0) whatIsNotEnough.add("cups");

        if (whatIsNotEnough.isEmpty()) {

            this.setWater(this.getWater() - 250);
            this.setBeans(this.getBeans() - 16);
            this.setMoney(this.getMoney() + 4);
            this.setCups(this.getCups() - 1);

            System.out.println("I have enough resources, making you a coffee!");

        } else {

            StringBuilder notEnoughResources = new StringBuilder();

            for (String resource : whatIsNotEnough) {
                notEnoughResources.append(resource).append(", ");
            }

            System.out.println("Sorry, not enough " +
                    notEnoughResources.substring(0, notEnoughResources.length() - 2) + "!");

        }

    }

    public void buyLatte() {

        List<String> whatIsNotEnough = new ArrayList<>();

        if (this.getWater() - 350 < 0) whatIsNotEnough.add("water");
        if (this.getMilk() - 75 < 0) whatIsNotEnough.add("milk");
        if (this.getBeans() - 20 < 0) whatIsNotEnough.add("beans");
        if (this.getCups() - 1 < 0) whatIsNotEnough.add("cups");

        if (whatIsNotEnough.isEmpty()) {

            this.setWater(this.getWater() - 350);
            this.setMilk(this.getMilk() - 75);
            this.setBeans(this.getBeans() - 20);
            this.setMoney(this.getMoney() + 7);
            this.setCups(this.getCups() - 1);

            System.out.println("I have enough resources, making you a coffee!");

        } else {

            StringBuilder notEnoughResources = new StringBuilder();

            for (String resource : whatIsNotEnough) {
                notEnoughResources.append(resource).append(", ");
            }

            System.out.println("Sorry, not enough " +
                    notEnoughResources.substring(0, notEnoughResources.length() - 2) + "!");
        }

    }

    public void buyCappuccino() {

        List<String> whatIsNotEnough = new ArrayList<>();

        if (this.getWater() - 200 < 0) whatIsNotEnough.add("water");
        if (this.getMilk() - 100 < 0) whatIsNotEnough.add("milk");
        if (this.getBeans() - 12 < 0) whatIsNotEnough.add("beans");
        if (this.getCups() - 1 < 0) whatIsNotEnough.add("cups");

        if (whatIsNotEnough.isEmpty()) {

            this.setWater(this.getWater() - 200);
            this.setMilk(this.getMilk() - 100);
            this.setBeans(this.getBeans() - 12);
            this.setMoney(this.getMoney() + 6);
            this.setCups(this.getCups() - 1);

            System.out.println("I have enough resources, making you a coffee!");

        } else {

            StringBuilder notEnoughResources = new StringBuilder();

            for (String resource : whatIsNotEnough) {
                notEnoughResources.append(resource).append(", ");
            }

            System.out.println("Sorry, not enough " +
                    notEnoughResources.substring(0, notEnoughResources.length() - 2) + "!");

        }
    }

    public void toDo(String command) {

        switch (command) {

            case "fill":

                System.out.println("Write how many ml of water you want to add:");
                this.setWater(this.getWater() + Long.parseLong(scanner.nextLine()));

                System.out.println("Write how many ml of milk you want to add:");
                this.setMilk(this.getMilk() + Long.parseLong(scanner.nextLine()));

                System.out.println("Write how many grams of coffee beans you want to add:");
                this.setBeans(this.getBeans() + Long.parseLong(scanner.nextLine()));

                System.out.println("Write how many disposable cups of coffee you want to add:");
                this.setCups(this.getCups() + Long.parseLong(scanner.nextLine()));

                break;

            case "take":

                this.setMoney(0);
                System.out.println("I gave you $" + this.getMoney());

                break;

            case "buy":

                String choice = "";

                while (!choice.matches("(1|2|3|back)")) {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                            " back - to main menu:");
                    choice = scanner.nextLine();
                }

                switch (choice) {
                    case "1":
                        this.buyEspresso();
                        break;
                    case "2":
                        this.buyLatte();
                        break;
                    case "3":
                        this.buyCappuccino();
                        break;
                    default:
                        break;
                }

                break;

            case "remaining":

                printState();

                break;
        }
    }


    public void printState() {

        System.out.println("\nThe coffee machine has:\n" +
                this.getWater() + " ml of water\n" +
                this.getMilk() + " ml of milk\n" +
                this.getBeans() + " g of coffee beans\n" +
                this.getCups() + " disposable cups\n" +
                "$" + this.getMoney() + " of money\n" +
                "\n");

    }
}
