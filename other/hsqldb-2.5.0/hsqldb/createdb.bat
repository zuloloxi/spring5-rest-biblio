rem use server.properties to create db
set JAVA_HOME=C:\A18\jdk1.8.0_231
set PATH=%JAVA_HOME%\bin;%PATH%
java -classpath lib/hsqldb.jar org.hsqldb.server.Server
pause