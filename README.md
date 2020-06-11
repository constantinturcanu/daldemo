# Data Access Layer Demo


## Resources / Prerequisites

### MySql Database

**Install MariaDB**

https://linuxize.com/post/how-to-install-mariadb-on-ubuntu-18-04/

**MySql Employees Sample Database**
**GitHub repo**: 

https://github.com/datacharmer/test_db

Docs: 
https://dev.mysql.com/doc/employee/en/

**Create demo_user**

**Grant permissions to 'demo_user' on 'employees' database**

**Download the MySql JDBC Connector** - v 5.1.48 - mysql-connector-java-5.1.48.jar

https://downloads.mysql.com/archives/c-j/
https://downloads.mysql.com/archives/get/p/3/file/mysql-connector-java-5.1.48.zip


```
constantin@constantin-VirtualBox:~$ ls -l /usr/share/java/
java-atk-wrapper.jar             juh.jar                          mysql-connector-java-8.0.20.jar  unoloader.jar
java_defaults.mk                 jurt-6.4.2.jar                   ridl-6.4.2.jar                   
java_uno.jar                     jurt.jar                         ridl.jar                         
juh-6.4.2.jar                    libintl.jar                      unoloader-6.4.2.jar              
constantin@constantin-VirtualBox:~$ cd /usr/share/java/
constantin@constantin-VirtualBox:/usr/share/java$ ls -l mysql-connector-java-8.0.20.jar 
-rw-r--r-- 1 root root 2385581 mar  9 12:46 mysql-connector-java-8.0.20.jar
constantin@constantin-VirtualBox:/usr/share/java$
```





**Java SE Development Kit 8**
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

**Eclipse JPA**
https://www.eclipse.org/webtools/dali/docs/3.2/user_guide/task_create_new_project.htm#CIHHEJCJ
https://www.eclipse.org/webtools/dali/docs/3.2/user_guide/tasks006.htm

https://www.eclipse.org/downloads/packages/

**Windows**:
 
Eclipse IDE for Enterprise Java Developers

https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip

Download eclipse-jee-2020-03-R-incubation-win32-x86_64.zip

https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-03/R/eclipse-jee-2020-03-R-incubation-win32-x86_64.zip&mirror_id=1099







**EclipseLink / Hibernate**

**Hibernate** 

http://hibernate.org/orm/releases/5.4/


http://sourceforge.net/projects/hibernate/files/hibernate-orm/5.4.17.Final/hibernate-release-5.4.17.Final.zip/download


**Hibernate persistence.xml properties**

https://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/session-configuration.html#configuration-hibernatejdbc


## JOOQ
https://www.jooq.org/download/

https://www.jooq.org/doc/latest/manual/code-generation/codegen-configuration/

https://www.jooq.org/doc/3.13/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step3/


**JOOQ Code Generation**

Run
`java -cp jooq-3.13.2.jar;jooq-meta-3.13.2.jar;jooq-codegen-3.13.2.jar;reactive-streams-1.0.2.jar;[JDBC-driver].jar org.jooq.codegen.GenerationTool <XML-file>`

`java -cp jooq-3.13.2.jar;jooq-meta-3.13.2.jar;jooq-codegen-3.13.2.jar;reactive-streams-1.0.2.jar;[JDBC-driver].jar org.jooq.codegen.GenerationTool demo.xml`

`constantin@constantin-VirtualBox:~/Downloads/jOOQ-3.13.2/jOOQ-lib$ java -cp jooq-3.13.2.jar;jooq-meta-3.13.2.jar;jooq-codegen-3.13.2.jar;reactive-streams-1.0.2.jar;/usr/share/java/mysql-connector-java-8.0.20.jar org.jooq.codegen.GenerationTool demo.xml` 


**On Linux: Use ":" instead of ";" to separate jar files list!**

`constantin@constantin-VirtualBox:~/Downloads/jOOQ-3.13.2/jOOQ-lib$ java -classpath jooq-3.13.2.jar:jooq-meta-3.13.2.jar:jooq-codegen-3.13.2.jar:reactive-streams-1.0.2.jar:mysql-connector-java-5.1.48.jar:. org.jooq.codegen.GenerationTool demo.xml` 



**JPQL Exmples**:  
https://en.wikibooks.org/wiki/Java_Persistence/JPQL


**Mapping SQL and Java Data Types**

https://www.service-architecture.com/articles/database/mapping_sql_and_java_data_types.html

