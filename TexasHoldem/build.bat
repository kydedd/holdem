REM build.bat
REM A Windows script to create executable jar file for Texas Hold'em application
REM JDK must be installed with javac and jar commands on environmental path variable
REM This script must be executed in the directory containing the src directory

@echo off

echo Compiling java files from src directory...

javac -d bin src\nrp\*.java src\*.java

echo Compiled java files sent to bin directory.

echo Creating executable jar file...

jar cfvm manifests\TexasHoldem.txt TexasHoldem.jar bin\*.class

echo Manifest files sent to manifests directory.

echo Done.