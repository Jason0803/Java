#!/bin/sh


# this script shows how to test client


# (1) compile the client

# TODO: have to change the path to the correct
# where the axis2 lib folder is.
path=axis2-1.6.2/lib

javac -extdirs $path MyBMIClient.java

# (2) run the client with different parameters

# 60kg 1.7 meters
java -Djava.ext.dirs=$path MyBMIClient calcBMI 60 1.70


# add a few ranges 
java -Djava.ext.dirs=$path MyBMIClient addRange admin bodymass '*' 18.49 UNDERWEIGHT false
java -Djava.ext.dirs=$path MyBMIClient addRange admin bodymass 18.50 24.99 "NORMAL RANGE" true
java -Djava.ext.dirs=$path MyBMIClient addRange admin bodymass 25.00 29.99 OVERWEIGHT false
java -Djava.ext.dirs=$path MyBMIClient addRange admin bodymass 30.00 '*' OBESE false

# 60kg 1.7 meters
java -Djava.ext.dirs=$path MyBMIClient calcBMI 60 1.70
java -Djava.ext.dirs=$path MyBMIClient calcBMI 70 1.70
java -Djava.ext.dirs=$path MyBMIClient calcBMI 80 1.70
java -Djava.ext.dirs=$path MyBMIClient calcBMI 100 1.70



