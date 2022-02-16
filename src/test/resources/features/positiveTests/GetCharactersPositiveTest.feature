Feature: Positive request by characters

  Description: Asking for super heroes. We check whether there are such as ours in the answer. Check if id matches
  Request: http://gateway.marvel.com/v1/public/characters?ts=1&apikey=<apikey>

  Scenario: Comparison of the name and id of heroes
    Given We know information about superheroes
  #|   name                       | id   |
  |  A-Bomb (HAS)                |1017100|
  |  Aaron Stack                 |1010699|
  |  Abomination (Emil Blonsky)  |1009146|
  |  Abomination (Ultimate)      |1016823|
  |  Absorbing Man               |1009148|
  |  Abyss                       |1009149|
  |  Adam Warlock                |1010354|
  |  Aegis (Trey Rollins)        |1010846|
  |  Agatha Harkness             |1012717|
  |  Agent X (Nijo)              |1011031|
  |  Agent Zero                  |1009150|
  |  Agents of Atlas             |1011198|
  |  Air-Walker (Gabriel Lan)    |1011136|

    When We make a request for the service "http://gateway.marvel.com/v1/public/characters?" to the heroes
    And Check status "Ok" and response code "200"
    And Converting the received data
    Then Compare the existing id and name with the received data
