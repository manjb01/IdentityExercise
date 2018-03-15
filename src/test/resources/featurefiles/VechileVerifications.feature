@VechicleRegistrationEnquiry
Feature: Test to validate vechile make and colour
  Scenario: Verify vehicle color and make match to expected value in dvla site  from mime type Excel file type
    Given I scan the directory to retrieve the supported "xlsx" files
    And I read vehicle reg numbers from one of the file
    And I launch dvla site
    When I search for vehicle info by reg number
    Then I should be able match the expected color and make from the given file

  Scenario: Verify vehicle color and make match to expected value in dvla site from mime type CSV file type
    Given I scan the directory to retrieve the supported "csv" files
    And I read vehicle reg numbers from one of the file
    And I launch dvla site
    When I search for vehicle info by reg number
    Then I should be able match the expected color and make from the given file