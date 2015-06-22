name := "CSR"

organization := "com.itickets"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

//playJavaSettings

//ebeanEnabled := false

//Disable Java Doc, Sources while publishing

publishArtifact in (Compile, packageDoc) := false

publishArtifact in (Compile, packageSrc) := false

resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
	"Alfresco Maven Repository" at "https://maven.alfresco.com/nexus/content/groups/public/",
	"Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository",
	"Maven repository" at "http://morphia.googlecode.com/svn/mavenrepo/"
)

libraryDependencies ++= Seq(
  	javaJdbc,
  	cache,
    javaWs,
  	javaCore,
  	filters,
  	//Hibernate 4.3.5 needs JPA 2.1, see:  http://stackoverflow.com/questions/20734540/nosuchmethoderror-in-javax-persistence-table-indexesljavax-persistence-index/20800857#20800857
    javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.3",
	"com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % "2.1.3",
	"com.google.guava" % "guava" % "18.0",
  	"com.typesafe.play" %% "play" % "2.2.2",
    "com.typesafe.play" %% "play-java" % "2.2.2",
    "commons-collections" % "commons-collections" % "3.2.1",
	"commons-dbcp" % "commons-dbcp" % "1.4",
	"commons-io" % "commons-io" % "2.4",
	"commons-lang" % "commons-lang" % "2.5",
	"commons-logging" % "commons-logging" % "1.1.1",
	"org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final",
	"org.hibernate.javax.persistence" % "hibernate-jpa-2.1-api" % "1.0.0.Final",
	"org.springframework" % "spring-aop" % "4.1.1.RELEASE",
    "org.springframework" % "spring-aspects" % "4.1.1.RELEASE",
    "org.springframework" % "spring-beans" % "4.1.1.RELEASE",
    "org.springframework" % "spring-context" % "4.1.1.RELEASE",
    ("org.springframework" % "spring-core" % "4.1.1.RELEASE" notTransitive())
      .exclude("org.springframework", "spring-asm")
      .exclude("commons-logging", "commons-logging")
    ,
    "org.springframework" % "spring-expression" % "4.1.1.RELEASE",
    "org.springframework" % "spring-jdbc" % "4.1.1.RELEASE",
    "org.springframework" % "spring-jms" % "4.1.1.RELEASE",
    "org.springframework" % "spring-orm" % "4.1.1.RELEASE",
    "org.springframework" % "spring-test" % "4.1.1.RELEASE",
    "org.springframework" % "spring-tx" % "4.1.1.RELEASE",
    "xml-apis" % "xml-apis" % "1.4.01",
    "mysql" % "mysql-connector-java" % "5.1.25",
    "com.google.code.morphia" % "morphia" % "0.99",
  	"org.mongodb" % "mongo-java-driver" % "2.7.3",
	"de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "1.36" % "test"
)

//publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository")))

 
