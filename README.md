# Data Access Layer for Test Automation

This code was written for demo purposes and used in a presentation I've done at a local testers community meetup. It is on Youtube: https://youtu.be/q4HYbCabr3o?t=2009


## Resources / Prerequisites installation

**Install Ubuntu image on VirtualBox**

**Java SE Development Kit 8**
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

### MySql Database

**Install MariaDB**

https://linuxize.com/post/how-to-install-mariadb-on-ubuntu-18-04/

 - Bridge network connection in VirtualBox to expose mySql server port 3306.
 - configure bind-address to interface's local network address (e.g. in our tests: 192.168.200.55)

**MySql Employees Sample Database**

**GitHub repo**: https://github.com/datacharmer/test_db

**Docs**: https://dev.mysql.com/doc/employee/en/


**Create demo_user and grant permissions on 'employees' database**

**Download the MySql JDBC Connector** - mysql-connector-java-5.1.48.jar

https://downloads.mysql.com/archives/c-j/
https://downloads.mysql.com/archives/get/p/3/file/mysql-connector-java-5.1.48.zip


```
VirtualBox:/usr/share/java$ ls -l /usr/share/java/mysql-connector-java-8.0.20.jar 
-rw-r--r-- 1 root root 2385581 mar  9 12:46 mysql-connector-java-8.0.20.jar
irtualBox:/usr/share/java$
```


**HeidiSQL**

https://www.heidisql.com/download.php



**Eclipse IDE for Enterprise Java Developers**

https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip


Download eclipse-jee-2020-03-R-incubation-win32-x86_64.zip

https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip&mirror_id=1099

**Eclipse JPA**
https://www.eclipse.org/webtools/dali/docs/3.2/user_guide/task_create_new_project.htm#CIHHEJCJ
https://www.eclipse.org/webtools/dali/docs/3.2/user_guide/tasks006.htm

https://www.eclipse.org/downloads/packages/








**EclipseLink / Hibernate**

**Hibernate** 

http://hibernate.org/orm/releases/5.4/


http://sourceforge.net/projects/hibernate/files/hibernate-orm/5.4.17.Final/hibernate-release-5.4.17.Final.zip/download


**Hibernate persistence.xml properties**

https://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/session-configuration.html#configuration-hibernatejdbc


## JOOQ

Download jooq and unzip it.

https://www.jooq.org/download/

https://www.jooq.org/doc/latest/manual/code-generation/codegen-configuration/

https://www.jooq.org/doc/3.13/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step3/


**JOOQ Code Generation**

https://www.jooq.org/doc/3.13/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step3/


**Note:**  On Linux: Use ":" instead of ";" to separate jar files list

`VirtualBox:~/Downloads/jOOQ-3.13.2/jOOQ-lib$ java -classpath jooq-3.13.2.jar:jooq-meta-3.13.2.jar:jooq-codegen-3.13.2.jar:reactive-streams-1.0.2.jar:mysql-connector-java-5.1.48.jar:. org.jooq.codegen.GenerationTool demo.xml` 


## Useful resources

**JPQL Exmples**:  
https://en.wikibooks.org/wiki/Java_Persistence/JPQL


**Mapping SQL Data Types to Java Data Types**

https://www.service-architecture.com/articles/database/mapping_sql_and_java_data_types.html


```
SQL data type	              Java data type
                    Simply mappable	Object mappable

CHARACTER                               String
VARCHAR                                 String
LONGVARCHAR                             String
NUMERIC                                 java.math.BigDecimal
DECIMAL                                 java.math.BigDecimal
BIT                 boolean             Boolean
TINYINT             byte                Integer
SMALLINT            short               Integer
INTEGER             int                 Integer
BIGINT              long                Long
REAL                float               Float
FLOAT               double              Double
DOUBLE PRECISION    double              Double
BINARY                                  byte[]
VARBINARY                               byte[]
LONGVARBINARY                           byte[]
DATE                                    java.sql.Date
TIME                                    java.sql.Time
TIMESTAMP                               java.sql.Timestamp
```
