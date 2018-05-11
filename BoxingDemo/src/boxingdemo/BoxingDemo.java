/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingdemo;

import boxingcompetition.Fighter;
import boxingcompetition.NewFighter;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Eliise
 */
public class BoxingDemo {
    private static String token = "salajane";

    public static void main(String[] args) {
        
        Scanner obj = new Scanner(System.in);
        while(true) {
            System.out.println("Võistleja lisamiseks vajuta 1, võistleja kuvamiseks vajuta 2, väljumiseks 3");
            String option = obj.next();
            if (option.equals("1")){
                NewFighter fighter = new NewFighter();
                System.out.println("Sisesta võistleja nimi: ");
                fighter.setName(obj.next());
                System.out.println("Sisesta võistleja kaal: ");
                fighter.setWeight(Integer.valueOf(obj.next()));
                System.out.println("Sisesta võistleja võidud: ");
                fighter.setWins(Integer.valueOf(obj.next()));
                System.out.println("Sisesta võistleja kaotused: ");
                fighter.setLosses(Integer.valueOf(obj.next()));
                addFighter(fighter, token);
            }
            else if (option.equals("2")){
                List<Fighter> fighters = getFighterList(token);
                for(Fighter fighter : fighters) {
                    System.out.println("Võistleja:");
                    System.out.println("\tnimi: " + fighter.getName());
                    System.out.println("\tkaal: " + fighter.getWeight());
                    System.out.println("\tvõidud: " + fighter.getWins());
                    System.out.println("\tkaotused: " + fighter.getLosses());
                }
            } else {
                break;
            }
        }
    }

    private static void addFighter(boxingcompetition.NewFighter newFighter, java.lang.String token) {
        boxingcompetition.BoxingService service = new boxingcompetition.BoxingService();
        boxingcompetition.SOAPService port = service.getSOAPServicePort();
        port.addFighter(newFighter, token);
    }

    private static java.util.List<boxingcompetition.Fighter> getFighterList(java.lang.String token) {
        boxingcompetition.BoxingService service = new boxingcompetition.BoxingService();
        boxingcompetition.SOAPService port = service.getSOAPServicePort();
        return port.getFighterList(token);
    }
    
}
