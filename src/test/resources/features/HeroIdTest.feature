Feature: HeroIdTest
Scenario : hero id by name

  Given hero data known
  | name          | id      |
  | Iron%20Man    | 1009368 |
  | Groot         | 1010743 |
  | Yondu         | 1011542 |
  | Black%20Widow | 1009189 |

  When make a request for the service "http://gateway.marvel.com/v1/public/characters?name=" by the name of the hero

  Then compare the result with the existing id