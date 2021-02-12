###Given a balance scale and 9 gold bars of the same size and look. You don’t know the exact weight of each
#bar, but you know they are the same weight, except for only one fake bar. It weighs less than others. You need to
#find the fake gold bar by only bars and balance scales.
#You can only place gold bars on scale plates (bowls) and find which scale weighs more or less.

  Feature: As a user I should be able to use the scale to find a fake gold bar
    Scenario: I should be able to find a fake gold bars
      Given user is on the scale page
      When user scale the gold bars by inserting nums
      And user clicks on "weights"
      Then user should be able to find the fake bar



      ##
    #| 0, 1    |  | 2, 3    |
    #| 3, 4    |  | 6, 5    |
    #| 6, 7    |  | 0, 8    |
    #| 1, 2    |  | 0, 3    |
    #| 3, 5    |  | 4, 6    |
    #| 3, 4, 5 |  | 0, 1 ,2 |
    #| 3, 4, 5 |  | 6, 7, 8 |
    #| 0, 4, 6 |  | 1, 7, 0 |
    ##