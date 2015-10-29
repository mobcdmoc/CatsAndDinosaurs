Go to https://glassfish.java.net/download.html

Copy the contents of glassfishDependencies\lib to \glassfish4\glassfish\domains\domain1\lib
Copy the resources folder  from glassfishDependencies to \glassfish4\glassfish\domains\domain1

the go to glassfish4\bin and run:

asadmin.bat
when the console opens give it 'start-domain'

or run '.\asadmin start-domain' on linux without quotes

the open a web browser and go to localhost:4848

once it loads go to the applications tab on the left and click deploy.
browse for and select the PizzaWebService.war from the glassfishDependencies and click deploy.

you should now have the ability to hit the web service by requesting in your web browser

http://localhost:8080/PizzaWebService/webresources/PizzaService/Get/Items