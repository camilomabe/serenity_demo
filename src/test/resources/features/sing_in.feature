Feature: Login in with correct credentials

  As a user of the StartSharp web side
  I want to sing in
  To verify that my credentials are correct

  @Login @Regression
  Scenario Outline: Login with correct credentials
    Given Camilo opens the browser in the home page
    When he enters his credentials, <user> and <pass>
    Then he should see the <user> in the login home
    Examples:
      | user  | pass     |
      | admin | serenity |

  @Unit @Regression
  Scenario Outline: Create Business unit
    Given Camilo opens the browser in the home page
    When he enters his credentials, <user> and <pass>
    And he creates new business unit as <businessUnits>
    Then he should see the business unit name
    And he should delete business unit
    Examples:
      | user  | pass     | businessUnits |
      | admin | serenity | Business Unit |

  @Schedule @Regression
  Scenario Outline: Schedule a meeting
    Given Camilo opens the browser in the home page
    When he enters his credentials, <user> and <pass>
    And he creates new business unit as <businessUnits>
    And he schedules a business meeting
      | Meeting Name   | <businessMeeting> |
      | Meeting Type   | <meetingType>     |
      | Meeting Number | <meetingNumber>   |
      | Location       | <location>        |
      | Organized By   | <organizedBy>     |
      | Reporter       | <organizedBy>     |
      | Attendee List  | <organizedBy>     |
    Then he should see the business meeting
    And he should delete meeting and unit
    Examples:
      | user  | pass     | businessUnits | businessMeeting  | meetingType | meetingNumber | location | organizedBy  |
      | admin | serenity | Business Unit | Business Meeting | Customer    | 28112022      | HQ-01    | Adam Edwards |