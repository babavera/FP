Feature: Negative request by characters

  Request: http://gateway.marvel.com/v1/public/characters?<parameter=value>&ts=1&apikey=<apikey>

  Scenario Outline: Checking the code and status when requesting with incorrect parameters
    Given we have a resource "http://gateway.marvel.com/v1/public/characters?"
    When  we make a request with incorrect parameters "<parameter>" and value "<values>"
    Then  we should get a response with a code and status
    And   compare the received data with existing ones "<code>" and "<status>"

  Examples: Request parameters and response results
   | parameter | values | code | status                                                                 |
   | name      | 0      | 409  | name cannot be blank if it is set                                      |
   | comics    | 0      | 409  | You must pass at least one valid issue id if you set the issue filter. |
   | limit     | -1     | 409  | You must pass an integer limit greater than 0.                         |
   | limit     | 0      | 409  | You must pass an integer limit greater than 0.                         |
   | limit     | 101    | 409  | You may not request more than 100 items.                               |