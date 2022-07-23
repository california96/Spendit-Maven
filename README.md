# Spendit (Maven Edition)
This is a proof of concept of converting Spendit to a Maven project

# Tools for the job
Java SDK 8

https://www.oracle.com/ph/java/technologies/javase/javase8-archive-downloads.html

Tomcat (9.0 or later. This project is on Servlet 3.0)

https://tomcat.apache.org/

MySQL Community Server

https://dev.mysql.com/downloads/mysql/

Node

https://nodejs.org/en/

Maven (3.6.3)

https://maven.apache.org/

# Setup tutorial

>Clone/Download the project

>Run the following commands inside the cloned repository:

```
cd src\main\webapp

npm install admin-lte@^3.0 --save
```

>Edit `src\main\webapp\WEB-INF\web.xml` data accordingly. This includes schema url, image folder directories, etc

>Edit pom.xml's `<webXml>` tag to match with your directory

>Edit this line inside your `tomcat-directory/webapps/manager/WEB-INF/web.xml` otherwise the deployment will fail due to the large size of the WAR
```
<max-file-size>82914560</max-file-size>
<max-request-size>82914560</max-request-size>
```
>Inside the project directory, run the command below
```
mvn clean install
```

>When running the project with Tomcat (9.0 or later), begin with /createTables.action. This initializes the database tables as well as the predefined values

>To get audit trails, go to /downloadlogs.action

>Enjoy

# Future Patches in the Cards

>Admin authentication of audit download via web.xml

>Implement audit logging using Log4j 2.17

>Implementation of SSL

>Redesigning of email template for forgotten password requests

>Add documentation of endpoints used via Swagger Docs