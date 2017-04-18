# javaee-interceptor
JavaEE - Injection of Persisting Unit using Interceptor
  
Dynamic injection of different Persistence Unit for persisting in different Entities in run time using Interceptor.  
  
  Create two JDBC Resources in glassfish as "jdbc/jpaDatabase1" and "jdbc/jpaDatabase2"  
  with respective connection pools.  
  Applcation will generate "tableA" in "jdbc/jpaDatabase1" and "tableB" in "jdbc/jpaDatabase2"   
   