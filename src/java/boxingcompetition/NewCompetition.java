/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingcompetition;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eliise
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "NewCompetitionRequest")
public class NewCompetition {
    
    @XmlElement(name = "boxingType", required = true)
    String boxingType;
    @XmlElement(name = "date", required = true)
    Date date;
    @XmlElement(name = "rounds", required = true)
    int rounds;

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

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
    
    
    
}
