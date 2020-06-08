# Covid-19 Tracking and Monitor Database

## Introduction

This repository is a theoritical project that aims to build a database according to a person situation:
1- Healthy.
2- Suspect.
3- Confirmed.
4- Cured.

Track down their movements through geolocatization data, and with that simulate how will COVID-19 spread. 

The project was built on the assumption that all data needs to be anonymn, thus everything was built using UUIDs.

Also the Window Sliding Technique was used to achieve two key points:
1. Reduce the time complexity and amount of data.
2. Simulate an amount of time the virus remains airborn.

All the data used was dummy data to assure that no privacy laws were broken, and finally the implementation was built using Object-oriented programming with Java.

## Getting Started
### Dependencies
* Java SDK14
* SQL

### Intructions

In the main directory you can see the queries for the creation of the database as well as the stored procedured created to track and update the person situation as needed, as well as a query with the tables created for unit testing.

The Data generator folder contains an old version of the JAVA implementation of the database and dummy data generation.

And the Covid folder is the most recent version of the implementation. 

Finally this project was merged with a ORM implementation version and a web interface which you can find [here](https://github.com/GustavoLiraRB/NextDataEngineering/tree/master/Next).

## License
[MIT](https://opensource.org/licenses/MIT)

## Issue/Bug

Please open issues on github to report bugs or make feature requests.


