/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingcompetition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.ValidationException;



public class BoxingService {
    
    private static long nextCompetitionID = 1;
    private static long nextFighterID = 1;
    private static final List<Fighter> FIGHTERS = new ArrayList<>();
    private static final List<Competition> COMPETITIONS = new ArrayList<>();

    public Competition getCompetition(long id, String token) {
        checkToken(token);
        for (Competition competition : COMPETITIONS) {
            if (competition.getId() == id) {
                return competition;
            }
        }
        return null;
    }
    
    public void addCompetiton(NewCompetition newCompetition, String token) {
        checkToken(token);
        Competition competition = new Competition();
        competition.setId(nextCompetitionID++);
        competition.setBoxingType(newCompetition.getBoxingType());
        competition.setDate(newCompetition.getDate());
        competition.setRounds(newCompetition.getRounds());
        COMPETITIONS.add(competition);
    }
    
    public Fighter getFighter(long id, String token) {
        checkToken(token);
        for (Fighter fighter : FIGHTERS) {
            if (fighter.getId() == id) {
                return fighter;
            }
        }
        return null;
    }
    
    public List<Fighter> getFighters(String name, Integer weight, Integer wins, Integer losses, String token) {
        checkToken(token);
        return FIGHTERS.stream()
                .filter(fighter -> name == null || fighter.getName().equalsIgnoreCase(name))
                .filter(fighter -> weight == null || fighter.getWeight() == weight)
                .filter(fighter -> wins == null || fighter.getWins() == wins)
                .filter(fighter -> losses == null || fighter.getLosses() == losses)
                .collect(Collectors.toList());
    }
    
    public void addFighter(NewFighter newFighter, String token) throws ValidationException {
        checkToken(token);
        newFighter.validate();
        Fighter fighter = new Fighter();
        fighter.setId(nextFighterID++);
        fighter.setName(newFighter.getName());
        fighter.setLosses(newFighter.getLosses());
        fighter.setWeight(newFighter.getWeight());
        fighter.setWins(newFighter.getWins());
        FIGHTERS.add(fighter);
    }
    
    public List<Competition> getCompetitionList(String token) {
        checkToken(token);
        return COMPETITIONS;
    }
    
    public List<Fighter> getFighterList(String token) {
        checkToken(token);
        return FIGHTERS;
    }
    
    public void addCompetitionFighter(long fighterId, long competitionId, String token) {
        checkToken(token);
        Fighter fighter = null;
        for (Fighter f : FIGHTERS) {
            if (f.getId() == fighterId) {
                fighter = f;
            }
        }
        Competition competition = null;
        for (Competition c : COMPETITIONS){
            if (c.getId() == competitionId){
                competition = c;
            }
        }
        if (fighter != null && competition != null){
            if (!competition.getFighters().contains(fighter)) {
                competition.getFighters().add(fighter);
            }
        }
    }
    
    public List<Fighter> getCompetitionFighters(long id, String token) {
        checkToken(token);
        for (Competition competition : COMPETITIONS) {
            if (competition.getId() == id) {
                return competition.getFighters();
            }
        }
        return null;
    }
    
    private void checkToken(String token){
        if (!"salajane".equalsIgnoreCase(token)){
            throw new IllegalArgumentException();
        }
    }
}
