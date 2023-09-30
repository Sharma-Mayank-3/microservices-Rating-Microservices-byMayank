# microservices-Rating-Microservices-byMayank
This is a part of a microservice project, where out aim is to create a different microservices, like user, hotel
and rating microservice, also establish a synchronous communication between these respective services.

# Rating-Microservice
      ---------------------------------------------------------------

# Rating Entity
1. Create, getAll, findByUserId,  getByHotelId operation on Rating entity.
2. Update and Delete Rating by Id.


# Add Eureka Server Client Rating-Service to eureka server.
# Add 2 dependencies in Rating-service.
# Add Eureka Server Client like add Rating service to eureka server.
1. cloud Bootstrap
2. eureka discovery client.

       <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter</artifactId>
       </dependency>

       <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
       </dependency>

# After Dependencies tag over
Add

    <dependencyManagement>
     <dependencies>
     <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>${spring-cloud.version}</version>
      <type>pom</type>
      <scope>import</scope>
     </dependency>
     </dependencies>
    </dependencyManagement>


# Add spring cloud version to the above properties, what ever is mentioned above.

    <properties>
     <java.version>17</java.version>
     <spring-cloud.version>2022.0.4</spring-cloud.version>
    </properties>


# Now Add configuration in the application.properties file

      eureka.instance.preferIpAddress=true
      eureka.client.register-with-eureka=true
      eureka.client.fetch-registry=true
      eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
      spring.application.name=RATING-SERVICE

# Add annotation in main class of user

    @EnableDiscoveryClient