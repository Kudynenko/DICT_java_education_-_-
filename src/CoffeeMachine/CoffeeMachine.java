package CoffeeMachine;

import  java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        MachineLogic machineLogic = new MachineLogic();
        Scanner sc = new Scanner(System.in);

        while(!machineLogic.exitStatus){
            machineLogic.updatedMachineAction(sc.nextLine());
        }
    }
}
