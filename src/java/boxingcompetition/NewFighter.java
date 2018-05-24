/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingcompetition;

import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eliise
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "NewFighterRequest")
public class NewFighter {
    @XmlElement(required=true)
    String name;
    @XmlElement(required=true)
    int weight;
    @XmlElement(required=true)
    int wins;
    @XmlElement(required=true)
    int losses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
    
    public void validate() throws ValidationException {
        if (weight <= 0) {
            throw new ValidationException("Kaal peab olema suurem nullist!");                    
        }
        if (wins < 0) {
            throw new ValidationException("Võitude arv ei tohi olla negatiivne!");                    
        }
        if (losses < 0) {
            throw new ValidationException("Kaotuste arv ei tohi olla negatiivne!");                    
        }
    }
}
