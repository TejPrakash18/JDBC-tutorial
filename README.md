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

` [ Java App <=====> JDBC api ] <=====> [ JDBC Driver <===> Database ]`

------
#### how to set JDBC Driver ClassPath:

DownLoad the JDBC driver for use particular DB.
and place the driver in your C drive and set the classpath in your environment variable
 
---

#### How to connect with DB your Java Program

1. step 1. load the driver 
   `Class.forName("org.postgresql.Driver")`
add the jdbc driver in your project ("external library folder")
2. Create a Connection:
   Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/your_database_name");


3. Create query, Statement , PreparedStatement , CallableStatement
eg
String q="select * from students";

Statement stmt=con.createStatement();

ResultSet set=stmt.executeQuery(q);

4. Process the data :

while(set.next())
{
int id=set.getInt("studentID");
String name=set.getString("studentName");
System.out.println(id);
System.out.println(name);

}

5. Close the connection:
   con.close();

----------

solve this problems using postgreSql in java

1.  `How to create a table `
2. `insert data into a table using "preparedStatement" in java `
3. `insert data into table with dynamic input`
4. `insert image to DB and large image `
5. `updating data of table in DB`
6. `Selecting data using java app from database`
7. `How to select image from DB`
8. `What is resultSet in JDBC , how to fetch Data?`

---------------------------------


## `File Handling in Java`

----
A file is a container that is used to store various of information. Data is permanently stored secondary
memory by creating file with a unique name. A file may consist of text, image or any other information

* ` different operation that can be performed on a file`

       creating, opening, reading or writing a file and moving or close  file

we learn how **java** ` ByteStreams ` are used to perform input and output f 8-bit(1-byte) using class `RandomAccessFile` which 
consist of method `writeByte()` and `readByte()` to write and read the data in the form of bytes

 ### **various** method used to perform file operation

* `writeBytes(String s)` write the string to the file as a sequence of bytes
*  `readLines()` reads the next line of text from this file
*  `getFilePointer()` Return the current offset in this file
*  `length()` return the length of this file and return type is long
*  `close()` closes this random access file stream and release any system resources associated with the stream
*  `setLength(Long newLength)` sets the length of this file
*  `seek(Long pos)` sets the file-pointer offset, measured form the beginning of this file, at which the next read or write occurs

| values / mode | meaning                |
|---------------|------------------------|
| "r"           | open the file for reading|
| "rw"          ||
| "rws"         ||
|"rwd"|

**Sysntax**

```Java
import java.io.File;
import java.io.RandomAccessFile;

File file = new File(fileName);
RandomAccessFile raf = new RandomAccessFile(file, mode);
```
