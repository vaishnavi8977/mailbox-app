<h1 align=”center”>
<br> Email Application <br>
</h1>

This Email is just like every email application which is used to send and receive messages, what makes it special is that it is `very scalable and highly available`.
This email like every other email application has 
Folders such as Inbox, Sent items and Important. 
User folders such as Family, Home and Work.
Email compose option
List of emails.


A point to note is that the recipients to whom we can send emails are the Git users. We can write the git hub id in the “To” column. 


The key steps in the development process include:
Planning, Architecture, design and coding. 
## **Prerequisites:**
### We need JDK installed.
### IDE used is VS code. You can also use eclipse or intellij.
### For Designing Login Page we took Oauth support.
Git Hub account user can come to this login page use his github credentials and start using the application. In a broader perspective its like we are outsourcing the authentication mechanism to Github.
### For data we used Apache Cassandra DB.
Cassandra is a No SQL DB. It is highly scalable and highly available DB. Needless to say it is very good at autoscaling where it add nodes or bring down nodes as per traffic.
The Apache Cassandra DB we used is a hosted DB solution called `Astra DB by DataStax`.
Why we used this is because we need not setup the whole Cassandra as it is already made, all it needs is few clicks to deploy. 
We need a Free data stacks account as we don’t want to have Apache Cassandra on our machine and want a true distributed Apache Cassandra as we can’t get a true distributed instance if we only have one node.
### For Front end tier you can do it with Javascript framework like Angular reach but we used `Thyme leaf template`.
### For Backend tier we used `Spring Boot` as it’s a very famous choice for building backend of application with Java.
### For Security we used Spring Security. We did `oauth login` with Git Hub
### For Webpage UI rendering we used `Thyme leaf`

