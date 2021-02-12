###Given a balance scale and 9 gold bars of the same size and look. You don’t know the exact weight of each
#bar, but you know they are the same weight, except for only one fake bar. It weighs less than others. You need to
#find the fake gold bar by only bars and balance scales.
#You can only place gold bars on scale plates (bowls) and find which scale weighs more or less.

  Feature: As a user i should be able to identify to fake gold bar
    Scenario: locating a fake gold bar
      Given user is on the scale page
      When user scales the gold bar inserting numbers
      And user clicks on "Weigh"
      Then user should be easily identify the fake gold bar







