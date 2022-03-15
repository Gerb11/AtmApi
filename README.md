# ATM API Overview
This project has 3 end points: /balance, /withdrawal and /deposit. Each of these end points will require authentication
based on the current users in the DB.

The following users exist: 

Username: Jeremy, Password: 1234

Username: Sam, Password: 5432

Username: Bill, Password: 7765

Username: Jake, Password: 4321

You can add to these by disabling the frame options in the WebSecurityConfig.java, running the app, and opening the h2 console by going to `localhost:8080/h2` The credentials for the DB are in application.properties.

### Installing Java

1) If running on a unix based operating system, download sdkman by running `curl -s "https://get.sdkman.io" | bash` in your terminal
   1) From here, you can run `sdk install java 11.0.14.9.1-amzn` to install java 11. After it's finished installing, type `Y`
2) If running on Windows, go to `https://www.oracle.com/java/technologies/downloads/#java11` and install the `.exe` and run it.

### Running the app

1) Using command line from the root of the project, run `./gradlew bootRun` and the server will start
   1) From here you can also run `./gradlew clean build` to build the project from scratch (this also runs the tests, and the jar will appear in the `./build/libs` location)
      1) Note the Jar Needs access to the `data` folder for the DB, so if running the jar by itself, you need to copy the `data` folder over as well
   2) To just run the tests, run `./gradlew clean test`
2) Once the server is running on localhost:8080, you can utilize any process that allows you to hit an API end point. For this README, it will explain what to do using postman

### Setting up postman
You can download postman from: `https://www.postman.com/downloads/`

Once it is installed:
1) Create a new request using the `+` icon at the top of the page. This will create a new request. The instructions below will explain how to set up each request

### /balance end point

1) Choose `GET` from the dropdown 
2) Type `localhost:8080/balance` into the URL 
3) Under the authentication header, select type: `Basic Auth`
4) Enter a username and password from the above list of available users
5) Hit send. If you typed in an existing username and password, you'll get a balanced returned, with a 200 status
   1) If authentication failed, the user / password was wrong or doesn't exist and you'll get a `401 Unauthorized`

### /deposit end point

1) Choose `POST` from the dropdown
2) Type `localhost:8080/deposit` into the URL
3) Under the Body header, select `raw` and choose `JSON` from the drop down
4) Now enter what value you would like to deposit into the form below. Ie 50
5) Under the authentication header, select type: `Basic Auth`
6) Enter a username and password from the above list of available users
7) Hit send. If you typed in an existing username and password, you'll get a success message, with a 200 status
   1) If authentication failed, the user / password was wrong or doesn't exist and you'll get a `401 Unauthorized`

### /withdrawal end point

1) Choose `POST` from the dropdown
2) Type `localhost:8080/withdrawal` into the URL
3) Under the Body header, select `raw` and choose `JSON` from the drop down
4) Now enter what value you would like to withdrawal into the form below. Ie 50
5) Under the authentication header, select type: `Basic Auth`
6) Enter a username and password from the above list of available users
7) Hit send. If you typed in an existing username and password, you'll get a success message, with a 200 status
   1) If authentication failed, the user / password was wrong or doesn't exist and you'll get a `401 Unauthorized`

### Additional info about the project

The project utilizes spring boot for rest related functionality. It uses WebSecurityConfigurerAdapter 
for basic authentication and a persistent h2 database to keep track of the user's balance.   

