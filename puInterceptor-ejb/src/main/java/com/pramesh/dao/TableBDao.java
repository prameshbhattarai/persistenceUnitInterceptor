/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.dao;

import com.pramesh.annotation.Database;
import com.pramesh.annotation.PersistUnit;
import com.pramesh.entities.TableA;
import com.pramesh.entities.TableB;
import com.pramesh.response.Responses;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author prames
 */
@Stateless
public class TableBDao implements Serializable {

    @PersistUnit
    @Database(name = "database2")
    public JsonObject save(Object obj, TableB tableB) {
        try {
            EntityManager em = (EntityManager) obj;
            em.persist(tableB);

            return Responses.createResponse("Saved in database2");
        } catch (Exception e) {
            e.printStackTrace();
            return Responses.errorResponse(e.getMessage());
        }
    }

    @PersistUnit
    @Database(name = "database2")
    public List<TableA> getAll(Object obj) {
        try {
            EntityManager em = (EntityManager) obj;
            Query query = em.createQuery("Select tb from TableB tb");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
