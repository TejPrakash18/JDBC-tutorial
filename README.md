## JDBC (java Database connectivity)
JDBC stand for java database connectivity, it is a standard API provide by oracle
for java application to interact with different set of databases.

The JDBC driver is a collection of predefined java classes enabling the communication
based on a defined database. 

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
### statement

the statement interface defines a generalized construct to run different SQL statement. it
shows the resultant dataset implementing the resultSet object.

```java
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Collection;

Collection conn = DriverManager.getConnection(dbrl,username, psswrd);
Statement stmt = conn.createStatement();

```
the statement can be executed for the retrieval of the dataset based on resulSet.

```Java
import java.sql.ResultSet;

ResultSet res = stmt.executeQuery("select * from EMP");
while(res.next()){
    System.out.println(res.getString("E_id"));
    System.out.println(res.getString("E_name"));
        }

```
------

### preparedStatement

PreparedStatement remains under the statement as a sub interface hierarchically. preparedStatement is comparably faster than the statement interface
preparedStatement object  is retrieved from the object of connection using the function

```java
import java.sql.PreparedStatement;

PreparedStatement psmt = conn.prepareStatement("insert into EMP values('1010', 1)");
psmt.executeUpdate();
```
---------------

### ResultSet

The resultSet interface provide a data set in the form of a table.it is given as the output of the resultSet data by implementing a SQL statement within JDBC program. it 
defines an iterative process based on the "res.next()" method returning false if the EOF(end of file maker) is reached.

```java
import java.sql.ResultSet;

ResultSet res = stmt.executeQuery("Select E_id, E_name, E_sal, E_Dept from EMP");
while(res.next()){
    System.out.println(res.getString("E_name"));
        }
```

```java

        Short notes
    step 1: import the different package 
        defining the driver name and jdbc and defined the dburl
        database initialisation
    step 2: Registeration of the JDBC driver
        Class.forName("driver url");
    step 3: commence a connection
    step 4: Generate a statement
    step 5: run a query
    step 6: Take out required data based on the result set
    step 7: data cleaning;
```


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
| "r"           | Open for reading only. Invoking any of the write methods of the resulting object will cause an IOException to be thrown|
| "rw"          |Open to reading and writing. If the file does not already exist then an attempt will be made to create it.|
| "rws"         |Open for reading and writing, as with “rw”, and also require that every update to the file’s content or metadata be written synchronously to the underlying storage device.|
|"rwd"|Open for reading and writing, as with “rw”, and also require that every update to the file’s content be written synchronously to the underlying storage device.|

**Sysntax**

```Java
import java.io.File;
import java.io.RandomAccessFile;

File file = new File(fileName);
RandomAccessFile raf = new RandomAccessFile(file, mode);
```

### CRUD Operation using file handling

--------

`How to Create a file`

```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCRUDExample {
    private static final String FILE_PATH = "items.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = readItemsFromFile();

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add an item");
            System.out.println("2. View all items");
            System.out.println("3. Update an item");
            System.out.println("4. Delete an item");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter item name:");
                    String newItem = scanner.nextLine();
                    items.add(newItem);
                    writeItemsToFile(items);
                    break;
                case 2:
                    System.out.println("Items:");
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i + 1) + ". " + items.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Enter item number to update:");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new item name:");
                    String updatedItem = scanner.nextLine();
                    items.set(updateIndex, updatedItem);
                    writeItemsToFile(items);
                    break;
                case 4:
                    System.out.println("Enter item number to delete:");
                    int deleteIndex = scanner.nextInt() - 1;
                    items.remove(deleteIndex);
                    writeItemsToFile(items);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static List<String> readItemsFromFile() {
        List<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return items;
    }

    private static void writeItemsToFile(List<String> items) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String item : items) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

```
