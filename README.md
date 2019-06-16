Inside of client folder there are 4 projects  
  - client-rest : The REST interfaces of the Client service and return objects (genereates JAR)
  - client-api : The service implementation of the REST interface and DAL implementation (generates JAR)
  - client-war : War build of the API project (generates WAR)
  - client-ear : Ear build of the WAR project (generates EAR)
  - soapui : projecto de soapui utilizado nos testes dos serviços
  
  All these projects depends the parent POM on the root of the client folder.
  
  To build these projects and generate the EAR to run in the wildfly just run maven in the root folder.
