package CoffeeMachine;

import java.util.Scanner;

public class MachineLogic {
    Scanner sc = new Scanner(System.in);
    private int reqWater = 200;
    private int reqMilk = 50;
    private int reqCoffeeBeans = 15;
    public void Greetings(){
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring milk into the cup\n" +
                "Coffee into the ready!");
    }

    public void machineActions(){
        System.out.println("Write how many cups coffee you will need: ");
        Integer uInp = Integer.parseInt(userInput());
        System.out.println(String.format("For %d cups of coffee you will need:\n" +
                "%d ml of water\n" +
                "%d ml of mick\n" +
                "%d g of coffee beans", uInp,uInp*reqWater,uInp*reqMilk,uInp*reqCoffeeBeans));
    }

    private String userInput(){
        System.out.print(">>> ");
        return sc.nextLine();
    }
}
