Feature: Online shopping for iPhone at Vodafone Shop
  As a customer
  I want to buy an iPhone from Vodafone Shop
  So that I can enjoy its features and services

  Background:
    Given Navigates successfully to VfShop homepage
    When User changes language to english

  Scenario: Correct error message gets displayed if user missed adding the order delivery contact name
    When User selects Apple products from shop by brand section
    And User selects any iPhone product from the shop
    And User clicks on add to card
    And User presses proceed to checkout
    And User enters delivery options as "Cairo", "Ain Shams"
    And User selects "Deliver to My Address" at "El-Hegaz" street, Building "9", floor "1", apartment "1"
    And User submits personal info tab empty
    Then User should see an error message for "Full Name" field