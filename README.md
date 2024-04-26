## JDBC (java Database connectivity)
JDBC stand for java database connectivity, it is a standard API provide by oracle
for java 

application to interact with different set of databases.

` Java App --------> { JDBC } --------> DataBase`

------
Why JDBC :
1. Store data Permanent
2. databases are essential in software development for managing and accessing data efficiently, ensuring data integrity and security, and supporting the scalability and reliability of applications

------
#### How JDBC architecture work 

` [ Java App <=====> JDBC api ] <=====> [ JDBC <===> Database ]`

------
#### how to set JDBC Driver ClassPath:

DownLoad the JDBC driver for use particular DB.
and place the driver in your C drive and set the classpath in your environment variable
 
---

#### How to connect with DB your Java Program

1. step 1. load the driver 
   `Class.forName("org.postgresql.Driver")`
2. 