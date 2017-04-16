/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.dao;

import com.pramesh.annotation.PersistUnit;
import com.pramesh.entities.TableA;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.pramesh.annotation.Database;
import com.pramesh.response.Responses;
import javax.json.JsonObject;

/**
 *
 * @author prames
 */
@Stateless
public class TableADao implements Serializable {

    @PersistUnit
    @Database(name = "database1")
    public JsonObject save(Object obj, TableA tableA) {
        try {
            EntityManager em = (EntityManager) obj;
            em.persist(tableA);

            return Responses.createResponse("Saved in database1");

        } catch (Exception e) {
            e.printStackTrace();
            return Responses.errorResponse(e.getMessage());
        }
    }

    @PersistUnit
    @Database(name = "database1")
    public List<TableA> getAll(Object obj) {
        try {
            EntityManager em = (EntityManager) obj;
            Query query = em.createQuery("Select ta from TableA ta");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
