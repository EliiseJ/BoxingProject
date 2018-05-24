/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingcompetition;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.XmlElement;


@WebService(serviceName = "BoxingService")
public class SOAPService {
    
    private BoxingService boxingService = new BoxingService();
    
    @WebMethod(operationName = "GetCompetition")
    public Competition getCompetition(@WebParam(name = "id") long id, @WebParam(name = "token") @XmlElement(required=true) String token) {
        return boxingService.getCompetition(id, token);
    }
    
    @WebMethod(operationName = "AddCompetition")
    public void addCompetiton(@WebParam(name = "newCompetition") @XmlElement(required=true) NewCompetition newCompetition, @WebParam(name = "token") @XmlElement(required=true) String token) {
        boxingService.addCompetiton(newCompetition, token);
    }
    
    @WebMethod(operationName = "GetFighterById")
    public Fighter getFighter(@WebParam(name = "id") long id, @WebParam(name = "token") @XmlElement(required=true) String token) {
        return boxingService.getFighter(id, token);
    }
    
    @WebMethod(operationName = "GetFighters")
    public List<Fighter> getFighters(@WebParam(name = "name") String name, 
            @WebParam(name = "weight") Integer weight, 
            @WebParam(name = "wins") Integer wins, 
            @WebParam(name = "losses") Integer losses, 
            @WebParam(name = "token") @XmlElement(required=true) String token) {
        return boxingService.getFighters(name, weight, wins, losses, token);
    }
    
    @WebMethod(operationName = "AddFighter")
    public void addFighter(@WebParam(name = "newFighter") @XmlElement(required=true) NewFighter newFighter, @WebParam(name = "token") @XmlElement(required=true) String token) throws ValidationException {
        boxingService.addFighter(newFighter, token);
    }
    
    @WebMethod(operationName = "GetCompetitionList")
    public List<Competition> getCompetitionList(@WebParam(name = "token") @XmlElement(required=true) String token) {
        return boxingService.getCompetitionList(token);
    }
    
    @WebMethod(operationName = "GetFighterList")
    public List<Fighter> getFighterList(@WebParam(name = "token") @XmlElement(required=true) String token) {
        return boxingService.getFighterList(token);
    }
    
    @WebMethod(operationName = "AddCompetitionFighter")
    public void addCompetitionFighter(@WebParam(name = "fighterId") long fighterId, @WebParam(name = "competitionId") long competitionId, @WebParam(name = "token") @XmlElement(required=true) String token) {
        boxingService.addCompetitionFighter(fighterId, competitionId, token);
    }
    
    @WebMethod(operationName = "GetCompetitionFighters")
    public List<Fighter> getCompetitionFighters(@WebParam(name = "id") long id, @WebParam(name = "token") @XmlElement(required=true) String token) {
        return boxingService.getCompetitionFighters(id, token);
    }
}
