rem use start created demodb file in hsqldb folder,-> testdb database
set JAVA_HOME=C:\A18\jdk1.8.0_231
set PATH=%JAVA_HOME%\bin;%PATH%
java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/demodb --dbname.0 testdb