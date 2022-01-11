@negative
Feature: Verify Hotel Booking Functionality

  Scenario Outline: Verify  user cannot able to save records with invalid first name
    Given user is on website
    When user enters first name with prefix "<firstname>"
    And user enters last name "<lastname>"
    And user enters price "<price>"
    And select deposit "<deposit>"
    And enter check in date "<checkindate>"
    And enter checko out date "<checkoutdate>"
    And click on save button
    Then verify record is not displayed on page

    Examples:
      | firstname | lastname | price | checkindate | checkoutdate | deposit |
      |           | Smith    | 100   | 2022-01-10  | 2022-01-11   | true    |
      |           | Smith    | 100   | 2022-01-10  | 2022-01-11   | false   |

  Scenario Outline: Verify  user cannot able to save records with invalid last name
    Given user is on website
    When user enters first name with prefix "<firstname>"
    And user enters last name "<lastname>"
    And user enters price "<price>"
    And select deposit "<deposit>"
    And enter check in date "<checkindate>"
    And enter checko out date "<checkoutdate>"
    And click on save button
    Then verify record is not displayed on page

    Examples:
      | firstname | lastname | price | checkindate | checkoutdate | deposit |
      | Jack      |          | 100   | 2022-01-10  | 2022-01-11   | true    |
      | Jack      |          | 100   | 2022-01-10  | 2022-01-11   | false   |

  Scenario Outline: Verify  user cannot able to save records with invalid price
    Given user is on website
    When user enters first name with prefix "<firstname>"
    And user enters last name "<lastname>"
    And user enters price "<price>"
    And select deposit "<deposit>"
    And enter check in date "<checkindate>"
    And enter checko out date "<checkoutdate>"
    And click on save button
    Then verify record is not displayed on page

    Examples:
      | firstname | lastname | price | checkindate | checkoutdate | deposit |
      | Jack      | Smith    | 0     | 2022-01-10  | 2022-01-11   | true    |
      | Jack      | Smith    | -100  | 2022-01-10  | 2022-01-11   | false   |
      | Jack      | Smith    | abc   | 2022-01-10  | 2022-01-11   | true    |
      | Jack      | Smith    |       | 2022-01-10  | 2022-01-11   | false   |
      | Jack      | Smith    |       | 2022-01-10  | 2022-01-11   | true    |

  Scenario Outline: Verify  user cannot able to save records with check out date
    Given user is on website
    When user enters first name with prefix "<firstname>"
    And user enters last name "<lastname>"
    And user enters price "<price>"
    And select deposit "<deposit>"
    And enter check in date "<checkindate>"
    And enter checko out date "<checkoutdate>"
    And click on save button
    Then verify record is not displayed on page

    Examples:
      | firstname | lastname | price | checkindate | checkoutdate | deposit |
      | Jack      | Smith    | 0     | 2018-01-10  | 2022-01-11   | true    |
      | Jack      | Smith    | -100  | 234354350   | 2022-01-11   | false   |
      | Jack      | Smith    | abc   | abcdedad    | 2022-01-11   | true    |
      | Jack      | Smith    |       |             | 2022-01-11   | false   |
      | Jack      | Smith    |       |             | 2022-01-11   | true    |

  Scenario Outline: Verify  user cannot able to save records with invalid check in date
    Given user is on website
    When user enters first name with prefix "<firstname>"
    And user enters last name "<lastname>"
    And user enters price "<price>"
    And select deposit "<deposit>"
    And enter check in date "<checkindate>"
    And enter checko out date "<checkoutdate>"
    And click on save button
    Then verify record is not displayed on page

    Examples:
      | firstname | lastname | price | checkindate | checkoutdate | deposit |
      | Jack      | Smith    | 0     | 2022-01-10  | 2018-01-10   | true    |
      | Jack      | Smith    | -100  | 2022-01-10  | 234354350    | false   |
      | Jack      | Smith    | abc   | 2022-01-10  | abcdedad     | true    |
      | Jack      | Smith    |       | 2022-01-10  |              | false   |
      | Jack      | Smith    |       | 2022-01-10  |              | true    |
      | Jack      | Smith    | 100   | 15-01-2022  | 16-01-2022   | true    |
