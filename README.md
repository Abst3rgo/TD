TD = TowerDefence Game
======================  

##  Programm Diskription
##  Installation
##  User Information
##  Structur
##  Componeten Analyse
##  Code deklaration
##  Developer Infos


### **Programm Diskription**
Ein Spiel nach dem Tower Defence Prinzip.

### **Installation**
Herunterladen des Codes und mit ausführung mit einem Java Editor 

### User Information
Nach Start des Spiel wird man gebeten die große des zu genieriendes Spielfeld zu wählen. 
Es werden 3 Größen angeboten.
Danach hat man etwa 30 Sec Zeit seine Tower auf dem Spielfeld zu platzieren.
Dazu wählt man erst einen belieben Tower aus und platziert ihr anschliesend auf dem gewünschten Feld.
Falls der Tower beim setzen den Weg der Mobs zum Ziel verhindern würde wird dieser Tower erntfernt und es muss neu gesetzt werden.
Das setzen kann solang ausgeführt werden bis die Zeitspanne abgelaufen ist.
Nach ablauf der Zeit werden Mob genieriert die speziefische Eigenschaften besietzen und sich ihren Weg zum Ziel suchen.
Sollte sich ein Mob in der Reichweite eines Tower befinden wird dieser Mob angegriffen und es wird im Lebenerngie abgezogen.
Fällt die Lebensernergie des Mobs auf 0 wird er zerstört und verschwindet vom Spielfeld.
Sollte es jedoch ein Mob in Ziel schaffen wird dem Spieler eines seiner Leben abgezogen, sind alle Leben des Spielers weg ist das Spiel vorbei.
Wenn alle Mobs im Ziel angekommen sind oder zerstört wurden beginnt eine neue Runde.
In dieser kann der Spieler eneut einen neuen Tower setzen woraufhin die Mobs die nun in größer Anzahl erscheinen wieder loslaufen.  

### Structur
Das Spiel besteht aus mehren Schichten
* Oberflächen
  * Tui
  * Gui
* Controller
* Model
  * Spielfeld
  * Mobs
  * Tower



