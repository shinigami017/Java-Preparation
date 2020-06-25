import java.util.*;
class TowerOfHanoi{
    public static void move(int numberOfDiscs, char fromTower, char toTower, char usingTower){
        if(numberOfDiscs == 1){
            System.out.println("Moving Disc 1 from Tower " + fromTower + " to Tower " + toTower);
        } else {
            move(numberOfDiscs - 1, fromTower, usingTower, toTower);
            System.out.println("Moving Disc " + numberOfDiscs + " from Tower " + fromTower + " to Tower " + toTower);
            move(numberOfDiscs - 1, usingTower, toTower, fromTower);
        }
    }
    public static void main(String args[])throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("===========================================================================================================================================================");
        System.out.println("Welcome to Tower of Hanoi Problem");
        System.out.println("We have three Towers A, B and C. We assume all discs are present in a sorted order in Tower A and they need to be shifted to Tower C in same sorted order.");
        System.out.print("To how you can transfer discs from Tower A to Tower C, please enter number of discs in Tower A : ");
        int numberOfDiscs = sc.nextInt();
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        move(numberOfDiscs, 'A', 'B', 'C');
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        sc.close();
    }
}