Använd den här filen för att skriva din code review.

Du kommer att få möjlighet att presentera den även direkt till oss.


______________________________________________________________________________________
Generellt + Konstruktorn VeryBasicStack():

*****PROBLEM*****

När klassen anropas så skapas direkt en stack med 1000 platser för objekten. Detta i kombination med att det INTE finns någon metod för att utöka stacken betyder att den är helt och hållet statisk och begränsad. 
Anrop till push fungerar så länge stackpekaren är mindre än 1000 men så fort den slår om från 999 -> 1000, så kommer nästa push-anrop att kasta ett IndexOutOfBoundException undantag (eller mer korrekt i detta fall Stack Overflow om man ska prata minneshantering). 
Anrop till pop fungerar så länge stackpekaren är större (eller lika med) 0 på andra raden i pop-metoden. Problem uppstår om stackpekaren är mindre än 0 i detta tillfälle, dvs tar ett objekt som inte finns.


*****LÖSNING*****

Om tanken är att stacken ska vara en förbestämd storlek så måste detta IndexOutOfBoundException hanteras korrekt. Antingen i koden som anropar denna push-metod eller så gör man om push-metoden att kontrollera vilket värde stackpekaren har så man inte försöker accessa en plats i stacken som är större än storleken själv (i detta fall kontrollera att stackpekaren har värdet < 1000 genom en enkel if-sats före genomförandet av push. 
Om tanken istället är en dynamisk stack så behöver den ovannämnda if-satsen finnas. 
Detta för att då genomföra en utökning av stacken i det fall stacken har nått sin maxgräns i ett tidigare anrop av push. Här kan man välja antingen #1 att direkt genomföra en utökning av stacken i samband med att den sista platsen occuperas, så att nästa anrop inte behöver göra något. Eller #2 att genomföra utökningen vid nästa anrop av push där stacken då är full. 
Lösning #2 är att föredra då #1 kan resultera i en onödig minnesanvändning (utökning av minnet trots att kanske inga fler push kommer att göras), medan #2 alltid gör en utökning i de fall det behövs. 

Oavsett om det är en dynamisk eller statisk stack så behövs det en extra koll på pop-metoden som undersöker om stacken redan är tom eller inte. Dvs, en pop ska INTE genomföras om stackpekaren redan är på 0, för annars kommer man försöka accessa ett objekt med plats -1, vilket kommer kasta ett undantag. Att föredra är att ha både if-satsen kollar om värdet är större än 0 och annars kasta ett eget undantag likt det access-metoden gör redan nu.  
