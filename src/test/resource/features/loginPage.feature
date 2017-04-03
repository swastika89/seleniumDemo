Feature: LOGIN

@Verify_ValidLogin
Scenario:TS-001 Verify login pageuser with valid credentials
Given User open the application url
When User clicks on the login link
Then User should see login screen
When User perform login with valid credentials
Then User should see my account screen

@Verify_InvalidUsername
Scenario:TS-002 Verify login pageuser with invalid user.
Given User open the application url
When User clicks on the login link
Then User should see login screen
When User perform login with invalid username
Then error message for invalid username should display

@Verify_InvalidPassword
Scenario:TS-003 Verify login pageuser with invalid password.
Given User open the application url
When User clicks on the login link
Then User should see login screen
When User perform login with invalid password
Then error message for invalid password should display

@Verify_BlankCredentials
Scenario:TS-004 Verify login pageuser with invalid password.
Given User open the application url
When User clicks on the login link
Then User should see login screen
When User perform login with blank username and password
Then error message for blank username and password should display

