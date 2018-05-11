/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingcompetition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eliise
 */
public class Competition {
    long id;
    String boxingType;
    Date date;
    int rounds;
    List<Fighter> fighters = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }
    

    public String getBoxingType() {
        return boxingType;
    }

    public void setBoxingType(String boxingType) {
        this.boxingType = boxingType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
