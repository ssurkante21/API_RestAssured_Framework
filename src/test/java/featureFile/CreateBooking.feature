Feature: Validate Booking Api's
  @regression
  Scenario Outline: Verify functionlity for booking API's
    Given Booking "CreateBookingAPI" Payload <firstname> <lastname> <price> <depositpaid> <checkin> <checkout> <additionalneeds> 
    When User calls "CreateBookingAPI" with http request as "POST" method 
    Then the API call is success with status code 200
    And Verify if data created is same as posted <firstname> <lastname> <price> <depositpaid> <checkin> <checkout> <additionalneeds>
    And Capture bookingid created 
    Examples:
    |firstname|lastname|price|depositpaid|checkin|checkout|additionalneeds|
    |Salmon|Jain|420|true|2021-05-15|2021-05-16|Breakfast|
    
    
Scenario Outline: Verify functionlity for booking API's
    Given Booking "updateBookingAPI" Payload <firstname> <lastname> <price> <depositpaid> <checkin> <checkout> <additionalneeds> 
		When User calls "updateBookingAPI" with http request as "PUT" method 
		Then the API call is success with status code 200
		And Verify if data created is same as posted <firstname> <lastname> <price> <depositpaid> <checkin> <checkout> <additionalneeds>
		Examples:
    |firstname|lastname|price|depositpaid|checkin|checkout|additionalneeds|
    |Salman|Lhan|420|true|2021-05-15|2021-05-16|Breakfast|