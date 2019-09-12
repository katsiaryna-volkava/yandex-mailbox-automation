yandex mail automation
=================

Java WebDriver test automation project for Yandex Mail

Java
====

Run from command line: mvn -DTimeout=30 -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml -Denvironment=dev clean test

Possible options:
Dbrowser: chrome, firefox
Dsurefire.suiteXmlFiles: src\test\resources\testng-all.xml, src\test\resources\testng-smoke.xml
Denvironment: dev, qa
