# Covid-19


This repository is a theoritical project that aims to build a database according to a person situation:
1- Healthy.
2- Suspect.
3- Confirmed.
4- Cured.

Track down their movements through geolocatization data, and with that simulate how will COVID-19 spread. 

The project was built on the assumption that all data needs to be anonymn, thus everything was built using UUIDs.

Also the Window Sliding Technique was used to achieve two key points:
1-Reduce the time complexity and amount of data.
2-Simulate an amount of time the virus remains airborn.


All the data used was dummy data to assure that no privacy laws were broken.

In the main directory you can see the queries for the creation of the database as well as the stored procedured created to track and update the person situation as needed.

The Data generator folder contains an old version of the JAVA implementation of the database and dummy data generation.

And the Covid folder is the most recent version of the implementation. Everything was built using Object-oriented programming.


Finally this project was merged with a ORM implementation version which you can find here:

