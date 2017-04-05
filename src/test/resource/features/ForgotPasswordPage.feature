Feature: Forgot Password Page

@Verify_ForgotPassword
Scenario:TS-001 Verify user can able to send forgot password request.
Given User open the application url
When User clicks on the login link
And User clicks on forgot password link
Then forgot password screen opens
When User enter email and send forgot password request
Then Login screen with valid messsages displays






