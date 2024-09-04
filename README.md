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

2.
Refaktorisera din kod (gör om den) genom att skapa en klass Library som innehåller all funktionalitet för ett bibliotek och ändra din main funktion så att den i stället skapar ett Library objekt som du sedan skriver kod för att testa.

3.
Extrauppgift: Implementera Reserverings-system

För att utöka funktionaliteten i bibliotekssystemet ska vi nu lägga till ett reservningssystem för böcker som är utlånade.

Instruktioner
Lägg till en reservlista i Book-klassen:

* Utöka din Book-klass med en lista som lagrar namn på personer som har reserverat boken.
* Denna lista ska vara tom när en bok skapas.
* Implementera en metod för reservation:

Skapa en metod reserve i Book-klassen som tillåter användare att reservera en bok om den är utlånad.
* Om boken redan är utlånad, lägg till användarens namn i reservlistan och returnera ett meddelande som bekräftar reservationen.
* Om boken är tillgänglig, meddela användaren att boken är tillgänglig och kan lånas direkt.
Uppdatera returnBook-metoden:

* När en bok returneras, kontrollera om det finns någon i reservlistan.
* Om det finns reserveringar, ändra bokens status till otillgänglig och flytta den första personen i reservlistan till bokningslistan.
* Meddela användaren att boken nu är reserverad för den första personen i listan och att de kan hämta den.
Uppdatera menyn i Main-funktionen:

Lägg till ett alternativ "6. Reserve a book".
* När användaren väljer detta alternativ, ska programmet fråga efter boknamnet och användarnamnet.
* Om boken inte är tillgänglig, reservera boken för användaren och ge ett bekräftelsemeddelande.
* Om boken är tillgänglig, fråga om användaren vill låna den direkt istället.
