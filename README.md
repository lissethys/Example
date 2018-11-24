benodigdheden:
- 2 spelers
- beurt > speler 1 (max 3x gooien) en speler 2 (max. gooien wat speler 1 heeft gegooid)
- streepjes, starten met vast aantal vb 5 > winnaar = hoogst aan aantal punten 
- punten per worp 
- gooien met dobbelstenen (max 3) > er hoeft niet altijd met alle 3 de dobbelstenen te gooien > selectie maken 
- knop Roll
- knop Stop > beurt aan de volgende > verplicht met alle 3 dobbelstenen te werpen
- speler 2 gooit hoger dan speler 1 > speler 2 is gewonnen (Feest!) > turf gaat weg van speler 2 > nieuwe beurt voor speler 1
- bij gelijke stand > nieuwe beurt

UI
Player: streepjes/punten/aanduiden beurt/aantal worpen (=scorebord)
Dobbelsteen: cijfer/welke vaststaan kunnen aanduiden
Button werp en stop

Requirement 1: spel kan 1 scherm hebben, maar moet minstens 2
> scherm 1: instellingen
> scherm 2: spel zelf

Requirement 2: share

Requirement 3: online connectie opzetten > data bijhouden ahv firebase


Layout:
textview: speler 1
textview: speler 2
checkbox: dobbel 1
checkbox: dobbel 2
checkbox: dobbel 3
button: roll
button: pass

start > gooien speler 1 beurt 1 (pass button staat uit, werp is 3 nieuwe getallen werpen en vorige getallen overschrijven) > speler 1 beurt 2 (pass button staat aan) > speler 1 beurt 3
of > speler 1 past na beurt 2 > speler 2 beurt 1  (pass button staat uit) > speler 2 beurt 2 
var voor elke speler en elke beurt
