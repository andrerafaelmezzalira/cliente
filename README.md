# Cliente

Para construir o aplicativo, foi usado as seguintes ferramentas:

Eclipse como IDE para codificação.

Java 8

J2EE 7

Servidor Jboss EAP 7

Maven como organizador de pacotes

Banco de dados Postgresql e o driver postgresql para java

HTML 5, AngularJs e Materializecss na camada view.

JAX-RS para comunicação entre a view e o server.

EJB 3.1 para a camada de negócio.

Repository (entityManager), com JPA e hibernate na camada de acesso a dados.

Para instalar, basta criar a base de dados de nome 'cliente', conforme definido em persistence.xml.

Adicionar o banco de dados em arquivo standalone.xml, na parte de datasources, conforme abaixo

                <datasource jta="true" jndi-name="java:jboss/cliente" pool-name="cliente" enabled="true" use-ccm="true">
                    <connection-url>jdbc:postgresql://localhost:5432/cliente</connection-url>
                    <driver-class>org.postgresql.Driver</driver-class>
                    <driver>postgresql-9.4-1204.jdbc4.jar</driver>
                    <security>
                        <user-name>postgres</user-name>
                        <password>postgres</password>
                    </security>
                    <validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker"/>
                        <background-validation>true</background-validation>
                        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter"/>
                    </validation>
                </datasource>


Se rodar pelo eclipse, pode importar o projeto do tipo maven project via eclipse e rodar o comando maven install. Adicione o projeto no jboss e start o servidor.
Caso contrário, poderá rodar o comando mvn install via linha de comando, pegar o arquivo war gerado e adicionar ao jboss.

O url do sistema deverá ser: http://localhost:8080/cliente
