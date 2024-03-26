# CitizenDash
Website to help others keep track of critical information all in one place.
The technology stack involved in creating this project was:

- Java
- Spring
- Spring 
- Thymeleaf
- MySQL
- HTML/CSS
- JavaScript
- Bootstrap

Once Signed-In the user can create 1 of 3 modules. 

ToDo: Create a card for a particular subject listing benchmarks the user can check off for accomplishing that task

Price Tracker: User can enter prices for the places that they shop to track them and determine the least expensive place to buy their groceries ultimately saving more money.

Triple-Search: Instead of picking from a certain search, try all three at the same time. Entering one search query yields 3 search engine results: DuckDuckGo, Bing, and Google.

The user should be able to do all this from one single landing page, but there are other options like editing from a wider dashboard.

There is also an admin page where the Admin user's will be able to add and delete users.

*** Controllers *** 

Main Controller : Controller routing requests for any functionality of the main view

User Controller : Controller routing requests for any functionality dealing with the user(s) in particular and signing-in / security

*** Database ***

The values listed in this project are persisted through the use of records in a database. For this project I personally used MySQL.

*** Disclaimer ***

As of right now the function that is fully implemented is the ToDo functionality. Upcoming will be triple search, and the price tracking system. The bones of the price tracking functionality is in place, but the controllers for this have to be implemented as well as the additional appropriate web pages associated with that.
