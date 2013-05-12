@echo off
cd \
cd program files\comex\comexfiles
javac comex.java
appletviewer -J-Djava.security.policy=permit.policy comex.html
