# README #


### Synopsis ###

It is a web application containing both client-side and server-side projects. The client-side is made using Bootstrap Framework and Angular JS along with Jquery.
The server-side is REST API made using Java and Spring Framework. 
This project uses MongoDB as database and JSON Object to communicate with each other.

### How do I get set up? ###

After cloning the repository, you need to set up some things. The Tomcat Server and MongoDB Instance.

To set up place both client-side-ui and server side code in the webapps directory. Start the tomcat server. After this you can check if clint-side-ui is working or not by going to the browser and hitting http://localhost:8080/client-side-ui/index.html

But it won't be showing the data. For this you need to run the MongodB first because to run our application we first need to set up MongoDB and then need to restart the server.

In this project I am including the database also. After setting up the MongoDB, you need to dump the project database on your localhost. You might need to search for steps to dump your Mongo database with the name 'test-db'. After dumping the database, first restart MongoDB and then restart the tomcat-server.

By default the server-side api is pointing to local database with the name 'test-db'. You can change this by gping to the application.properties and change the database name. Or you can also change the machine IP also if your database is running on another machince.


If you want any help or have any queries contact me : jangra.vatan94@gmail.com


### Best Of Luck!! ###