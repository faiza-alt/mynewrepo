Feature: Login Test

  Login Successfully

  @ValidAccount
  Scenario:  Login Successfully
    Given user enter correct account information
    Then system should let the user to login

    @InvalidAccount
  Scenario:   UnSuccessful Login
    Given user enter invalid account information
    Then system should not let the user to login

