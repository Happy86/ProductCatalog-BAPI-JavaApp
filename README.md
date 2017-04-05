# ProductCatalog-BAPI-JavaApp
ERP Projekt - JAVA SAP BAPI - ProductCatalog


## Einleitung

Dieses Projekt soll im Rahmen des ERP Unterrichts an der Akademie für
Datenverarbeitung Böblingen das ProductCatalog Objekt der SAP BAPI
über die Java Schnittstelle (SAP Java Connector) zugänglich machen.

Es soll eine leicht zu bedienende grafische Oberfläche entstehen.


## Anforderungen
* sapjco.jar Version 2 inkl. Betriebssystem-Bibliotheken (.so unter
  GNU/Linux, .dll unter Microsoft Windows, .jnilib unter Apple Macintosh).
* Java Laufzeitumgebung / JDK mindestens in Version 7


## Anleitung (Entwicklung)
1. Projekt in Eclipse (oder eine andere IDE) importieren
2. sapjco.jar (Version 2!) importieren. Erhältlich im SAP Market(?).
  * Unter Linux im lib Verzeichnis von Java (unter Arch Linux z.B. 
    /usr/lib/jvm/default/lib/amd64 oder /usr/lib32/jvm/default/lib/i386)
    die libsapjco3.so für i386 oder x86_64 hinterlegen.
  * Unter Windows .dll Dateien hinterlegen. 
3. Die Datei sap-zugangsdaten.properties.CHANGE-ME in sap-zugangsdaten.properties
   umbennenen und Zugangsdaten hinterlegen.
4. Happy Coding. :-)

## Debugging
### Verbindung zum SAP System
Wenn beim Verbindungsaufbau Fehler auftreten wird im Projektverzeichnis eine
dev_rfc.trc erstellt.

In diese Datei werden Fehlermeldungen geschrieben.