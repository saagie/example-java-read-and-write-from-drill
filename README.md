Example for read & write into Drill
==================

Package for saagie : mvn package and get the package in target.

Usage in local :

 - mvn package
 - java -jar target/example-java-read-and-write-from-drill-1.0-SNAPSHOT-jar-with-dependencies.jar jdbc:drill:drillbit=namenode:31010,datanode1:31010,datanode2:31010,datanode3:31010

Usage in Saagie :

 - mvn package (in local, to generate jar file)
 - create new Java Job
 - upload the jar (target/example-java-read-and-write-from-drill-1.0-SNAPSHOT-jar-with-dependencies.jar)
 - copy URL from Drill connection details panel and add it in first argument in the command line
 - choose java 8
 - create and launch.
