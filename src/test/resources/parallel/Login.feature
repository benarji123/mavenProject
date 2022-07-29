Feature: login
    login into the r and hm website
    @login
  Scenario: login
     
     When i opened orange hrm application using url as "url"
     Then i should able to orange hrm logo
     When i enter username as "Admin" and password as "admin123" in login field
     And  i click on login button
     Then i should see the dashboard 
     
  @datadriven
 Scenario Outline: datadriven
    
     
     When i opened orange hrm application using url as "url"
     Then i should able to orange hrm logo
     When i enter username as "<username>" and password as "<password>" in login field
     And  i click on login button
     Then i should see the dashboard 
     
     Examples:
         |username|password|
         |Admin|admin123|
         |alekh|admin|
         |Admin|admin123|