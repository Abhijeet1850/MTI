# Test Scenario
Feature: I want to verify Google page

  ###################################### PMS ######################################################################################
  @dummy
  Scenario: opening Google
    Given I login into Chrome Browser and I entered URL "http://www.google.com"
    When I use below data in google search textbox
      | username | password | designation |
      | abc      | abc      |  test1      |
      | werty    | werty    |  test 2     |
    And I click Search Button
    Then I am verifying first Search Result

    
     @dummy1
  Scenario: Testing Get Request
    When I hit a Get Request to fetch Post with PostID "1"
    Then the API Response Status Code should be 200
    
    
         @dummy2
  Scenario: Testing Post Request
    When I hit a Post Request to create Post with below Request body
      | title    | body     | userId |
      | test     | bar      |  1     |
    Then the API Response Status Code should be 201
    Then the API Response Body would contain following values
      |  title  |  body   |  userID  |  id   |
      |  test    |  bar    |   1      |  101  |	 