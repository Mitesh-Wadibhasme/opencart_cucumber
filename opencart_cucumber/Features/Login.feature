Feature: Login with Valid Credentials

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "mkw2@gmail.com" and password as "Password@2"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page

  #@regression
  #Scenario Outline: Login Data Driven               #this outline refers this will execute mutiple times depending upon the parameter we write
    #Given the user navigates to login page
    #When user enters email as "<email>" and password as "<password>"    /#Email and password are header and that need to specify in double quotes along with angular bracket
    #And the user clicks on the Login button
    #Then the user should be redirected to the MyAccount Page

   # Examples: 
      #| email                     | password |
      #| pavanol@gmail.com         | test123  |
      #| pavanoltraining@gmail.com | test@123 |
