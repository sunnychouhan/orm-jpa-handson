# orm-jpa-handson


### Sonar Qube Integration

Bring the Sonar Server Up locally and configure pom with Jacoco and fails safe plugin to generate report for Test :
Run below command to push report to sonar server

**mvn clean verify sonar:sonar -Dsonar.projectKey=orm-jpa-handson -Dsonar.host.url=http://localhost:9000
-Dsonar.login=sqp_7a25d92356c4f3929e55b91adaaaa12764bec991**_