Feature: Validate Login Api's

  @tokengenerate
  Scenario Outline: Verify if token not generated for Valid login credentails
    Given Enter credentials as "<Username>" "<Password>"
    When User calls "GenerateToken" with post http request
    Then the API call is success with status code 200
    And "reason" in response body is "Bad credentials"

    Examples: 
      | Username | Password     |
      | admin    | admin        |
      | admin    | password1235 |

  @tokengenerate
  Scenario Outline: Verify if token generated for Valid login credentails
    Given Enter credentials as "<Username>" "<Password>"
    When User calls "GenerateToken" with post http request
    Then the API call is success with status code 200
    And "token" in response body is ""

    Examples: 
      | Username | Password    |
      | admin    | password123 |
