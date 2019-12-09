$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SocialNetworkingFeature.feature");
formatter.feature({
  "line": 2,
  "name": "",
  "description": "Imagine you are building a social network. Starting from simple functionality. Users are now able to make posts and comment on them.\r\nYou are working in the backend team that exposes the service: https://jsonplaceholder.typicode.com/ which has the following endpoints:\r\n\r\n1. Make posts: https://jsonplaceholder.typicode.com/posts\r\n2. Comment on posts: https://jsonplaceholder.typicode.com/comments\r\n3. List of users: https://jsonplaceholder.typicode.com/users\r\n\r\nUsing Rest-Assured, Cucumber, and Java, create a few scenarios to test this functionality",
  "id": "",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 29,
  "name": "Test that existing posts can be retreived with a GET request",
  "description": "",
  "id": ";test-that-existing-posts-can-be-retreived-with-a-get-request",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 28,
      "name": "@devEnvironment"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "service is up and running A",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "i search for \"\u003cid\u003e\" of a post with a GET method A",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "i should get the correct \"\u003cid\u003e\", \"\u003ctitle\u003e\" and \"\u003cbody\u003e\" returned with status code of 200 A",
  "keyword": "Then "
});
formatter.match({
  "location": "TestSocialNetworkingStepDep.java:71"
});
formatter.result({
  "duration": 174019200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cid\u003e",
      "offset": 14
    }
  ],
  "location": "TestSocialNetworkingStepDep.java:75"
});
formatter.result({
  "duration": 3623693100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cid\u003e",
      "offset": 26
    },
    {
      "val": "\u003ctitle\u003e",
      "offset": 34
    },
    {
      "val": "\u003cbody\u003e",
      "offset": 48
    },
    {
      "val": "200",
      "offset": 85
    }
  ],
  "location": "TestSocialNetworkingStepDep.java:81"
});
formatter.result({
  "duration": 179800,
  "status": "passed"
});
});