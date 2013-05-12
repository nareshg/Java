@echo off
cd \
cd program files\comex\comexfiles
javac comex.java -Xlint
appletviewer -J-Djava.security.policy=permit.policy comex.html
