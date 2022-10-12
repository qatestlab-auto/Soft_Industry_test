Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario Outline: Test search by fruits
    When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/test/<fruits>"
    Then he sees the results displayed for <fruits>
    Examples:
      | fruits |
      | mango  |
      | apple  |
      | tofu   |
      | water  |

  Scenario: Negative search request
    When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/test/car"
    Then he do not see the results