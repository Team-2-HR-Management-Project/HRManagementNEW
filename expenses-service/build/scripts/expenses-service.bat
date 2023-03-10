@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  expenses-service startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and EXPENSES_SERVICE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\expenses-service-v.0.1-plain.jar;%APP_HOME%\lib\spring-boot-starter-web-2.7.4.jar;%APP_HOME%\lib\lombok-1.18.24.jar;%APP_HOME%\lib\mapstruct-1.5.2.Final.jar;%APP_HOME%\lib\springdoc-openapi-ui-1.6.11.jar;%APP_HOME%\lib\graphql-spring-boot-starter-13.0.0.jar;%APP_HOME%\lib\graphql-spring-boot-autoconfigure-13.0.0.jar;%APP_HOME%\lib\spring-boot-starter-validation-2.7.4.jar;%APP_HOME%\lib\spring-cloud-starter-openfeign-3.1.4.jar;%APP_HOME%\lib\java-jwt-4.0.0.jar;%APP_HOME%\lib\spring-boot-starter-data-redis-2.7.4.jar;%APP_HOME%\lib\graphql-java-tools-13.0.0.jar;%APP_HOME%\lib\graphiql-spring-boot-starter-11.1.0.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-2.7.4.jar;%APP_HOME%\lib\postgresql-42.5.1.jar;%APP_HOME%\lib\spring-cloud-config-client-3.1.4.jar;%APP_HOME%\lib\spring-boot-starter-json-2.7.4.jar;%APP_HOME%\lib\spring-cloud-starter-3.1.4.jar;%APP_HOME%\lib\spring-cloud-openfeign-core-3.1.4.jar;%APP_HOME%\lib\spring-boot-starter-aop-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-2.7.4.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.7.4.jar;%APP_HOME%\lib\springdoc-openapi-webmvc-core-1.6.11.jar;%APP_HOME%\lib\spring-webmvc-5.3.23.jar;%APP_HOME%\lib\springdoc-openapi-common-1.6.11.jar;%APP_HOME%\lib\feign-form-spring-3.8.0.jar;%APP_HOME%\lib\spring-webflux-5.3.23.jar;%APP_HOME%\lib\spring-web-5.3.23.jar;%APP_HOME%\lib\swagger-ui-4.14.0.jar;%APP_HOME%\lib\webjars-locator-core-0.50.jar;%APP_HOME%\lib\classgraph-4.8.149.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.65.jar;%APP_HOME%\lib\hibernate-validator-6.2.5.Final.jar;%APP_HOME%\lib\spring-cloud-commons-3.1.4.jar;%APP_HOME%\lib\feign-slf4j-11.8.jar;%APP_HOME%\lib\feign-core-11.8.jar;%APP_HOME%\lib\graphql-kickstart-spring-webflux-13.0.0.jar;%APP_HOME%\lib\graphql-java-servlet-13.0.0.jar;%APP_HOME%\lib\graphql-java-kickstart-13.0.0.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.4.jar;%APP_HOME%\lib\swagger-core-2.2.2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.4.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.4.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.13.4.jar;%APP_HOME%\lib\jackson-core-2.13.4.jar;%APP_HOME%\lib\swagger-models-2.2.2.jar;%APP_HOME%\lib\jackson-annotations-2.13.4.jar;%APP_HOME%\lib\jackson-module-kotlin-2.13.4.jar;%APP_HOME%\lib\jackson-databind-2.13.4.jar;%APP_HOME%\lib\spring-data-redis-2.7.3.jar;%APP_HOME%\lib\lettuce-core-6.1.9.RELEASE.jar;%APP_HOME%\lib\kotlin-reflect-1.6.21.jar;%APP_HOME%\lib\kotlinx-coroutines-reactive-1.6.4.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.6.4.jar;%APP_HOME%\lib\kotlinx-coroutines-jdk8-1.6.4.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.6.21.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.6.21.jar;%APP_HOME%\lib\kotlin-stdlib-1.6.21.jar;%APP_HOME%\lib\graphql-java-annotations-9.1.jar;%APP_HOME%\lib\graphql-java-extended-scalars-18.1.jar;%APP_HOME%\lib\graphql-java-18.3.jar;%APP_HOME%\lib\antlr4-runtime-4.9.3.jar;%APP_HOME%\lib\hibernate-core-5.6.11.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\graphiql-spring-boot-autoconfigure-11.1.0.jar;%APP_HOME%\lib\commons-text-1.9.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\spring-data-jpa-2.7.3.jar;%APP_HOME%\lib\spring-data-keyvalue-2.7.3.jar;%APP_HOME%\lib\java-dataloader-3.1.2.jar;%APP_HOME%\lib\reflections-0.10.2.jar;%APP_HOME%\lib\HikariCP-4.0.3.jar;%APP_HOME%\lib\spring-data-commons-2.7.3.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.7.4.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\log4j-to-slf4j-2.17.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\feign-form-3.8.0.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\spring-aspects-5.3.23.jar;%APP_HOME%\lib\checker-qual-3.5.0.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.7.4.jar;%APP_HOME%\lib\spring-cloud-context-3.1.4.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\spring-boot-2.7.4.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\spring-context-support-5.3.23.jar;%APP_HOME%\lib\spring-context-5.3.23.jar;%APP_HOME%\lib\spring-aop-5.3.23.jar;%APP_HOME%\lib\spring-orm-5.3.23.jar;%APP_HOME%\lib\spring-jdbc-5.3.23.jar;%APP_HOME%\lib\spring-tx-5.3.23.jar;%APP_HOME%\lib\spring-oxm-5.3.23.jar;%APP_HOME%\lib\spring-beans-5.3.23.jar;%APP_HOME%\lib\spring-expression-5.3.23.jar;%APP_HOME%\lib\spring-core-5.3.23.jar;%APP_HOME%\lib\snakeyaml-1.30.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.65.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.65.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.2.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.3.Final.jar;%APP_HOME%\lib\spring-security-rsa-1.0.11.RELEASE.jar;%APP_HOME%\lib\spring-security-crypto-5.7.3.jar;%APP_HOME%\lib\netty-handler-4.1.82.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.82.Final.jar;%APP_HOME%\lib\netty-codec-4.1.82.Final.jar;%APP_HOME%\lib\netty-transport-4.1.82.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.82.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.82.Final.jar;%APP_HOME%\lib\netty-common-4.1.82.Final.jar;%APP_HOME%\lib\reactor-core-3.4.23.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.6.21.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\graphql-kickstart-spring-support-13.0.0.jar;%APP_HOME%\lib\graphql-kickstart-starter-utils-11.1.0.jar;%APP_HOME%\lib\aspectjweaver-1.9.7.jar;%APP_HOME%\lib\byte-buddy-1.12.17.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.4.2.Final.jar;%APP_HOME%\lib\jaxb-runtime-2.3.6.jar;%APP_HOME%\lib\httpcore-4.4.15.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\spring-jcl-5.3.23.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.69.jar;%APP_HOME%\lib\commons-fileupload-1.4.jar;%APP_HOME%\lib\javax.servlet-api-4.0.1.jar;%APP_HOME%\lib\javax.websocket-api-1.1.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\javassist-3.28.0-GA.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\txw2-2.3.6.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.12.jar;%APP_HOME%\lib\jakarta.activation-1.2.2.jar;%APP_HOME%\lib\logback-core-1.2.11.jar;%APP_HOME%\lib\log4j-api-2.17.2.jar;%APP_HOME%\lib\swagger-annotations-2.2.2.jar;%APP_HOME%\lib\bcutil-jdk15on-1.69.jar;%APP_HOME%\lib\bcprov-jdk15on-1.69.jar


@rem Execute expenses-service
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %EXPENSES_SERVICE_OPTS%  -classpath "%CLASSPATH%"  %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable EXPENSES_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%EXPENSES_SERVICE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
