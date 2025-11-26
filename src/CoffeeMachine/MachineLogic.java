package CoffeeMachine;

import java.util.Scanner;

public class MachineLogic {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;
    private final Scanner scanner = new Scanner(System.in);

    public void process() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> printState();
                case "exit" -> { return; }
            }
        }
    }

    private void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private boolean canMake(int w, int m, int b) {
        if (water < w) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < m) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans < b) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        String choice = scanner.next();
        if (choice.equals("back")) return;

        switch (choice) {
            case "1" -> { if (canMake(250, 0, 16)) { water -= 250; beans -= 16; cups--; money += 4; } }
            case "2" -> { if (canMake(350, 75, 20)) { water -= 350; milk -= 75; beans -= 20; cups--; money += 7; } }
            case "3" -> { if (canMake(200, 100, 12)) { water -= 200; milk -= 100; beans -= 12; cups--; money += 6; } }
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }

    private void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }
}
