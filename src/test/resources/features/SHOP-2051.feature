Feature: SHOP-2051 - [QA] (Schools) Sign in

Scenario: Successful sign in
    Given an unsigned in user has been directed to the school sign in screen
    When the user enters the correct sign in details and activates the continue button
    Then the user will be taken to the school version of the shop

Scenario: Email address check
    Given the user has entered an email address that is is not recognised as an existing account
    When the user activates the continue button
    Then the user will see a message to tell them their account could not be found

Scenario: Incorrect details message
    Given a user has entered an incorrect password
    When the user activates the 'Continue' button
    Then the user will see a message to inform them that their sign in details are incorrect

Scenario: Forgot password link
    Given a user is on the school sign in page
    When a user activates the Forgot password link
    Then the user will be taken to the 'Reset your password' page

Scenario: Redirection at end of reset password journey
    Given a user has activated the reset password journey
    When the user activates the sign in button at the end of the Reset Password journey
    Then the user will be returned to the school sign in page

Scenario: Wrapping on 'Sign in for schools' on mobile
    Given a user is viewing the school sign in page
    When there is not enough room for the text to appear on a single line
    Then the text will wrap on to two lines

