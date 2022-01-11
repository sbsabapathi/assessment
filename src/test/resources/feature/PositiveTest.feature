@positive
Feature: Verify Hotel Booking Functionality


  Scenario Outline: verify user can save records with valid values
    Given user is on website
    When user enters first name with prefix "<firstname>"
    And user enters last name "<lastname>"
    And user enters price "<price>"
    And select deposit "<deposit>"
    And enter check in date "<checkindate>"
    And enter checko out date "<checkoutdate>"
    And click on save button
    Then verify saved record is displayed on page
    When user click on delete for newly added record
    Then verify record is not displayed on page

    Examples:
      | firstname | lastname | price               | deposit | checkoutdate | checkindate |
      | Jack      | Smith    | 100                 | true    | 2022-01-15   | 2022-01-16  |
#      | Jack      | Smith    | 100                 | true    | 2022/01/15   | 2022/01/16  |
#      | Jack      | Smith    | 100                 | true    | 01-15-2022   | 01-16-2022  |
#      | Jack      | Smith    | 100                 | false   | 2022-01-15   | 2022-01-16  |
#      | Jack      | Smith    | 100                 | false   | 2022-01-15   | 2022-01-16  |
#      | !@;$%^&*  | Smith    | 100                 | false   | 2022-01-15   | 2022-01-16  |
#      | Jack      | !@;$%^&* | 100                 | false   | 2022-01-15   | 2022-01-16  |
#      | Jack      | Smith    | 0.0001              | true    | 2022-01-15   | 2022-01-16  |
#      | Jack      | Smith    | 1111111111111111111 | true    | 2022-01-15   | 2022-01-16  |
