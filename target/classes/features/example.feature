Feature: ZOO visiting

  Scenario: I am a crocodile visitor
    Given I am in the front of crocodile terrarium
    And I have KFC hot wings in my pocket
    When I take a wing from my pocket
    Then Crocodile is coming to me

  Scenario Outline: I hear the animals voice
    Given I am in ZOO
    And I am in front of <animal> cage
    When I call the <animal>
    Then Animal says <voice>
    Examples:
      | animal   | voice     |
      | cat      | meow meow |
      | dog      | 2         |
      | elephant | !@#%!@#^  |
      | fish     | silent    |

  Scenario: I am a crocodile stealer
    Given I am in the front of crocodile terrarium
    And I have KFC hot wings in my pocket
    When I take a wing from my pocket
    Then Crocodile is coming to me
    And I put into a car