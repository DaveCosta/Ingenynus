# Ingenynus
A java project for the Mau Génio Website.

How to compile
=

Typically you can do a full build of the application in the example with

    mvn clean install
Multi-module examples will potentially require an attached device or emulator and deploy the application and the integrations tests as part of the above invocation.

In all cases you can deploy the application with

    mvn android:deploy
and even start it with

    mvn android:run


Issues
=

The compiler incremental option 

    <properties>
     <kotlin.compiler.incremental>true</kotlin.compiler.incremental>
    </properties> 
seems not to be compatible with android compilation.

