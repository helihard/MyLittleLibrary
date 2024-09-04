Objektorienterad programmering

Uppgift Bibliotek
Använd en Lista för att lagra alla böcker i ett bibliotek
1.
I denna uppgift ska vi skapa ett enkelt bokningssystem för ett bibliotek. Vi ska börja med
att skapa en klass som heter Book. Varje bok ska ha:

- Ett namn
- En författare
- Ett år
- En upplaga
- Status: tillgänglig eller inte

Dessutom ska klassen Book ha:

* Status ska vara tillgänglig by default när en bok skapas.
* En metod loan som kollar om en bok går att låna eller inte (dvs tillgänglig eller inte) och göra följande:
  - Om boken är tillgänglig, då ska bokens status ändras till otillgänglig och metoden ska returnera true. Annars returnera false
  - En metod returnBook som gör motsatsen till loan.
  - En toString metod som returnerar en sträng med bokinformationen.

Skriv en Main funktion som kör ditt program:

Programmet skriver ut en meny först:
1. Add a book to the library
2. Search for a book by name
3. List all available books
4. Return a book
5. Quit

Hur programmet ska bete sig får du hitta på själv. Tänk på följande:
* I alternativ 2, om den boken som man söker efter finns, då ska steget efter vara att fråga användaren om den vill låna boken eller inte och fortsätta beroende på vad användaren matar in.
* Gör strängen som toString-metoden returnerar omfattande och presenterar informationen om boken på ett tydligt sätt.
