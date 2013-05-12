@echo off
cd \
cd program files\comex\comexfiles\login\
javac login.java
appletviewer -J-Djava.security.policy=permit.policy login.html
exit