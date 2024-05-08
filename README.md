# jsp_learning

해당 프로그램은은 아래와 같은 프로그램들을 사용했습니다.

    IDE : eclispe
    Server : apache-tomcat-9.0.86 / apache-tomcat-10.1.20
    JDK : jdk-17.0.10 / jdk-21.0.2
    SQL : Oracle 21c & sqldeveloper

서버 설정에 추가한 것 
    
    # Server.xml
    <Connector URIEncoding="UTF-8" connectionTimeout="20000" maxParameterCount="1000" port="8088" protocol="HTTP/1.1" redirectPort="8444"/>

    # tomcat-user.xml
    <role rolename="tomcat"/>
  	 <role rolename="role1"/>
  	 <role rolename="admin"/>
  	 <user username="tomcat" password="tomcat1234" roles="tomcat"/>
  	 <user username="both" password="both1234" roles="tomcat,role1"/>
  	 <user username="role1" password="role1234" roles="role1"/>
  	 <user username="admin" password="admin1234" roles="admin"/>

책으로 공부한 내용들이 기록됩니다.
