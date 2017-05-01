# javaee-interceptor
JavaEE - Injection of Persisting Unit using Interceptor
  
Dynamic injection of different Persistence Unit for persisting in different Entities in run time using Interceptor. 

Scenario: Dynamic injection of different Persistence Unit for persisting in different Entities in run time using Interceptor.   

        Requirement: Create two JDBC Resource as "jdbc/jpaDatabase1" and "jdbc/jpaDatabase2".  
        
        For persisting in ##database1##:               
        
        Request method: ##GET method##       
        Response format: ##JSON format##       
        API: ##http://localhost:8080/puInterceptor-web/api/database1##              
            
            
        Request method: ##POST method##       
        Request body: <code>
            {
                "persistenceUnitName": "Database1-PU", 
                "description": "Persisting in tableA"
            }</code>       
        Response format: ##JSON format##       
        API: ##http://localhost:8080/puInterceptor-web/api/database1##              
        
        For persisting in ##database2##:               
        
        Request method: ##GET method##       
        Response format: ##JSON format##       
        API: ##http://localhost:8080/puInterceptor-web/api/database2##              
            
            
        Request method: ##POST method##       
        Request body: <code>
            {
                "persistenceUnitName": "Database2-PU", 
                "description": "Persisting in tableB"
            }</code>       
        Response format: ##JSON format##       
        API: ##http://localhost:8080/puInterceptor-web/api/database2##              
   