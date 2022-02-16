Feature: Positive request by comics

  Request: http://gateway.marvel.com/v1/public/comics?ts=1&apikey=<apikey>

  Scenario: Checking the response for data
    Given We make a request for the service "http://gateway.marvel.com/v1/public/comics" to the comics
    Then We check status "Ok", response code "200" and number of comics "20" in response
    Then check if response contains id, title and number of comic pages
