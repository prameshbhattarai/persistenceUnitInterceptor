/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.resources;

import com.pramesh.dao.TableBDao;
import com.pramesh.entities.TableB;
import com.pramesh.persistingObject.PersistObject;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Rest api for persisiting in Database2
 * @author prames
 */
@Path("database2")
public class PersistInDatabase2 {

    @Inject
    TableBDao tableBDao;

    /**
     * Api for persisting persistObjectin tableB of database2
     * @param persistObject
     * @return Response 
     */
    @POST
    public Response save(PersistObject persistObject) {

        TableB tableB = new TableB();
        tableB.setPersistenceUnitName(persistObject.getPersistenceUnitName());
        tableB.setDescription(persistObject.getDescription());

        return Response.ok().entity(tableBDao.save(new Object(), tableB)).build();
    }

    /**
     * Api for fetching all rows from tableB of database2
     * @param persistObject
     * @return Response 
     */
    @GET
    public Response getAll() {
        return Response.ok().entity(tableBDao.getAll(new Object())).build();
    }
}
