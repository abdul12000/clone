Feature:
  Imagine you are building a social network. Starting from simple functionality. Users are now able to make posts and comment on them.
  You are working in the backend team that exposes the service: https://jsonplaceholder.typicode.com/ which has the following endpoints:

  1. Make posts: https://jsonplaceholder.typicode.com/posts
  2. Comment on posts: https://jsonplaceholder.typicode.com/comments
  3. List of users: https://jsonplaceholder.typicode.com/users
  Using Rest-Assured, Cucumber, and Java, create a few scenarios to test this functionality

  Scenario Outline: 1. Test that existing posts can be retreived with a GET request
    Given service is up and running
    When i search for "<id>" of a post with a GET method
    Then i should get the correct "<id>", "<title>" and "<body>" returned with status code of 200
    Examples:
      | id | title                | body                                                                                                                                                                                              |
      | 4  | eum et est occaecati | ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit |

  Scenario Outline: 2. Test that New posts can be created with a POST request
    Given service is up and running
    When i create a new post with the following details "<uId>", "<title>" and "<body>"
    Then I should get the correct "<uId>", "<title>" and "<body>" returned with a new ID in the response
    Examples:
      | uId  | title           | body                        |
      | 1001 | my first title  | my first body to test with  |
      | 1022 | my second title | my second body to test with |

  @devEnvironment
  Scenario: Test that existing posts can be retreived with a GET request
    Given service is up and running A
    When i search for "<id>" of a post with a GET method A
    Then i should get the correct "<id>", "<title>" and "<body>" returned with status code of 200 A