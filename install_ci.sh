mvn install -pl .
mvn --projects db,core clean install -DskipTests;
mvn --projects rest clean compile;