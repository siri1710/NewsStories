Feature: Test the Stories API

  Scenario: Testing stories endpoint positive scenario
    Given User hits the stories endpoint
    When User adds the credentials and send request
    Then the http status code is 200
    #And Verify the content of the result


  Scenario: Stories endpoint without passing headers
    Given User hits the stories endpoint
    When User sends request with out passing credentials
    Then the http status code is 401


