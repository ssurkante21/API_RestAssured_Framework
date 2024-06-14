Feature: Validate Booking Api's

 

  @tokengenerate
  Scenario Outline: Verify functionlity for booking API's
    Given CreateBookingAPI Payload "<firstname>" "<lastname>" "<price>" "<depositpaid>" "<checkin>" "<checkout>" "<additionalneeds>"
    When User calls "CreateBookingAPI" with "POST" http request
    Then the API call is success with status code 200
    Amd Verify if data created is same as posted
    And verify bookingid created 
    
