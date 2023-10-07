# Author: Carl Jones III
  # Date: 8/4/22
  # Description: n/a

@RegressionFeature
Feature: feature to test loading of the Homepage

  @regressiontest
  Scenario: Check the ui elements of the homepage Navigation

    Given user has started a web browser
    And user navigates to application home
    Then cookie overlay appears
    And home screen is clear
    Then user clicks on tab home
    Then user is redirected to the current page of the web application

