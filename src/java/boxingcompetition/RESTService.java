/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxingcompetition;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/boxingcompetition")
public class RESTService {
    
    BoxingService boxingService = new BoxingService();

    @Context
    private UriInfo context;

    
    public RESTService() {
    }

    @GET
    @Path("/fighter/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fighter getFighter(@PathParam("id") long id, @QueryParam("token") String token) {
        return boxingService.getFighter(id, token);
    }
    
    @GET
    @Path("/competition/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Competition getCompetition(@PathParam("id") long id, @QueryParam("token") String token) {
        return boxingService.getCompetition(id, token);
    }
    
    @POST
    @Path("/competition")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCompetiton(NewCompetition newCompetition, @QueryParam("token") String token) {
        boxingService.addCompetiton(newCompetition, token);
    }
    
    @GET
    @Path("/fighters/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fighter> getFighters(@QueryParam("name") String name, 
            @QueryParam("weight") Integer weight, 
            @QueryParam("wins") Integer wins, 
            @QueryParam("losses") Integer losses, 
            @QueryParam("token") String token) {
        return boxingService.getFighters(name, weight, wins, losses, token);
    }
    
    @POST
    @Path("/fighter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addFighter(NewFighter newFighter, @QueryParam("token") String token) {
        boxingService.addFighter(newFighter, token);
    }
    
    @GET
    @Path("/competitions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Competition> getCompetitionList(@QueryParam("token") String token) {
        return boxingService.getCompetitionList(token);
    }
    
    @GET
    @Path("/fighters")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fighter> getFighterList(@QueryParam("token") String token) {
        return boxingService.getFighterList(token);
    }
    
    @POST
    @Path("/competitionFighter")
    @Produces(MediaType.APPLICATION_JSON)
    public void addCompetitionFighter(@QueryParam("fighterId") long fighterId, @QueryParam("competitionId") long competitionId, @QueryParam("token") String token) {
        boxingService.addCompetitionFighter(fighterId, competitionId, token);
    }
    
    @GET
    @Path("/competitionFighters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fighter> getCompetitionFighters(@PathParam("id") long id, @QueryParam("token") String token) {
        return boxingService.getCompetitionFighters(id, token);
    }
}
