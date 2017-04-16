/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.interceptor;

import javax.interceptor.Interceptor;
import com.pramesh.annotation.PersistUnit;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.pramesh.annotation.Database;

/**
 *
 * @author prames
 */
@Interceptor
@PersistUnit
public class PersistUnitInterceptor {

    @PersistenceContext(unitName = "database1-PU")
    private EntityManager database1Em;

    @PersistenceContext(unitName = "database2-PU")
    private EntityManager database2Em;

    @AroundInvoke
    public Object methodInterceptor(InvocationContext ctx) throws Exception {
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("Intercepted by interceptor ");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        applyPerisitenceUnit(ctx);
        try {
            return ctx.proceed();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected void applyPerisitenceUnit(InvocationContext ctx) {

        if (ctx.getMethod().isAnnotationPresent(Database.class)) {
            Database database = ctx.getMethod().getAnnotation(Database.class);
            String databaseName = database.name();
            if (databaseName.equalsIgnoreCase("database1")) {
                Object[] params = ctx.getParameters();
                params[0] = database1Em;
                System.out.println("Injected database1-PU");
                ctx.setParameters(params);
            } else if (databaseName.equalsIgnoreCase("database2")) {
                Object[] params = ctx.getParameters();
                params[0] = database2Em;
                System.out.println("Injected database2-PU");
                ctx.setParameters(params);
            }
        }
    }
    
}    
