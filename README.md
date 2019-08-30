# Spring Boot Web Application Template
Example of JPA Application. Just for the testing purpose, Embedded H2 database is used.

## Environment
* Framework : Spring Boot - 2.1.6
* ORM : JPA / Hibernate
* Database : H2 - h2-2017-04-23
* Unit Test : jUnit + AssertJ
* Code Quality : Jacoco

## Services
* __/campaignmessage__ - `POST` - Create a new Campaign message
* __/campaignmessage/{campaignId} - `GET` - Get a Campaign message by ID
* __/campaignmessage/{campaignId}__ - `PUT` - Update a Campaign message by ID
* __/campaignmessage/{campaignId} `DELETE` - Delete a Campaign message by ID

## Initialization

After run the application, connect to `/h2-console` on the browser. Then you will see the following screen. Click connect to login

![docs/images/h2_console.jpg](docs/images/h2_console.jpg)


Once you are logged in, you will see something similar with following screen. 
![docs/images/h2_logged_in.jpg](docs/images/h2_logged_in.jpg)

Run the following SQL to create a table and add some initial test data

#### Create Test Database
```
CREATE TABLE CAMPAIGN(
    CAMPAIGN_ID INT AUTO_INCREMENT PRIMARY KEY,
    CUSTOMERNAME VARCHAR(50),
    MESSAGETEXT VARCHAR(200)
);
```

#### Add some test data
```
// Hibernate side test data
INSERT INTO CAMPAIGN(CUSTOMERNAME, MESSAGETEXT) VALUES('John Doe', 'Your credit card is ready');
INSERT INTO CAMPAIGN(CUSTOMERNAME, MESSAGETEXT) VALUES('Mary Tan', 'Your master card is ready');
INSERT INTO CAMPAIGN(CUSTOMERNAME, MESSAGETEXT) VALUES('Jerry Holland', 'Your visa card is ready');
```

#### H2 setup - (in application.properties)
* H2 is a embedded Database service. H2 will up and running as long as your application is running by the following dependency in Gradle script.

```
    runtime 'com.h2database:h2'     // Test Database
```

* Database connection setup 
We are using default JPA-Hibernate property names.

```
    # H2
    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console
    
    # Datasource
    spring.datasource.url=jdbc:h2:file:~/test;DB_CLOSE_ON_EXIT=FALSE
    spring.datasource.username=sa
    spring.datasource.password=
    spring.datasource.driver-class-name=org.h2.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
    spring.jpa.properties.hibernate,format_sql=true
    spring.jpa.show-sql=true
    spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.DefaultNamingStrategy
```


## Relationship
* Between TestUser and Post
It is One to Many relationship between TestUser and Post

TestUser.java

```java
    ...
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "testUser")
    private Set<Post> posts = new HashSet<>();
```
Post.java

```java
    ...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    @JsonIgnore
    private TestUser testUser;
```
@JsonIgnore is added, so it won't fall into infinite loop when translated to JSON

## Repository methods
Other than specified method below, it uses JPA provided method to use database.

TestUserRepository.java

```
@Repository
public interface TestUserRepository extends CrudRepository<TestUser, Integer>{

    public TestUser findByUserId(String userId);

}
```

PostRepository.java

```
@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
    
    public Post findByPostId(Integer postId);
}
```


## Unit Testing (TBD)

## Integration Test (TBD)

## Code Quality Check (TBD)

