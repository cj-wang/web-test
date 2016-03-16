call mvn install:install-file -Dfile=walle-core-5.0-20160317.jar -DgroupId=cn.walle -DartifactId=walle-core -Dversion=5.0-20160317 -Dpackaging=jar

call mvn install:install-file -Dfile=walle-json-1.0.jar -DgroupId=cn.walle -DartifactId=walle-json -Dversion=1.0 -Dpackaging=jar

call mvn install:install-file -Dfile=ojdbc5-11.1.0.6.0.jar -DgroupId=ojdbc5 -DartifactId=ojdbc5 -Dversion=11.1.0.6.0 -Dpackaging=jar

pause
