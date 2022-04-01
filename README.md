# JAVA EE Rest API

### SERVER
Use Wildfly > 20

### DATABASE SCRIPT START

```json
----------------------------------------------------------
--------------------------- USER -------------------------
----------------------------------------------------------
-- ROLE: sa_rest
-- DROP ROLE IF EXISTS sa_rest;
CREATE ROLE sa_rest WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'md59abe2e3a6c1228e6486adcca3d57d5de';

----------------------------------------------------------
------------------------ DATABASE ------------------------
----------------------------------------------------------
-- DATABASE: rest
-- DROP DATABASE IF EXISTS rest;
CREATE DATABASE rest
    WITH 
    OWNER = sa_rest
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

----------------------------------------------------------
-------------------------- SCHEMA ------------------------
----------------------------------------------------------
-- CREATING SCHEMA
-- SCHEMA: sa_rest
-- DROP SCHEMA IF EXISTS sa_rest ;

CREATE SCHEMA IF NOT EXISTS sa_rest AUTHORIZATION sa_rest;
```

### DATASOURCE

**Database:** Postgresql

**Driver:** Put files from src/main/resources/db/postgresql.zip into WILDFLY_HOME/modules/system/layers/base/org/

**Standalone Location:** WILDFLY_HOME/standalone/configuration/standalone.xml

```json
 <datasources>
    <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
        <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
        <driver>h2</driver>
        <security>
            <user-name>sa</user-name>
            <password>sa</password>
        </security>
    </datasource>
    <datasource jta="false" jndi-name="java:jboss/datasources/restDS" pool-name="restDS" enabled="true" use-ccm="false">
        <connection-url>jdbc:postgresql://localhost:5432/rest</connection-url>
        <driver-class>org.postgresql.Driver</driver-class>
        <connection-property name="autoCommit">
            false
        </connection-property>
        <driver>postgresql</driver>
        <new-connection-sql>SELECT 1</new-connection-sql>
        <pool>
            <min-pool-size>1</min-pool-size>
            <max-pool-size>10</max-pool-size>
        </pool>
        <security>
            <user-name>sa_rest</user-name>
            <password>stranger</password>
        </security>
        <validation>
            <validate-on-match>false</validate-on-match>
            <background-validation>false</background-validation>
        </validation>
        <statement>
            <share-prepared-statements>false</share-prepared-statements>
        </statement>
    </datasource>
    <drivers>
        <driver name="h2" module="com.h2database.h2">
            <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
        </driver>
        <driver name="postgresql" module="org.postgresql">
            <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
        </driver>
    </drivers>
</datasources>
```


