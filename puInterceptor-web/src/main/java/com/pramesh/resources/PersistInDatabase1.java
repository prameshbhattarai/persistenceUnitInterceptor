/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.resources;

import com.pramesh.dao.TableADao;
import com.pramesh.entities.TableA;
import com.pramesh.persistingObject.PersistObject;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Rest api for persisiting in Database2
 * @author pramesh.bhattarai
 */
@Path("database1")
public class PersistInDatabase1 {

    @Inject
    TableADao tableADao;

    /**
     * Api for persisting persistObjectin tableA of database1
     * @param persistObject
     * @return Response 
     */
    @POST
    public Response save(PersistObject persistObject) {
        
        TableA tableA = new TableA();
        tableA.setPersistenceUnitName(persistObject.getPersistenceUnitName());
        tableA.setDescription(persistObject.getDescription());
        
        return Response.ok().entity(tableADao.save(new Object(), tableA)).build();
    }

    /**
     * Api for fetching all rows from tableA of database1
     * @param persistObject
     * @return Response 
     */
    @GET
    public Response getAll() {
        return Response.ok().entity(tableADao.getAll(new Object())).build();
    }

}
