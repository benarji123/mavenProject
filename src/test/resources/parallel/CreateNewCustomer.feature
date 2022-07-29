Feature: Add new Customer in telecom application
    
       
 Scenario:  Add new customer

 When open an application with Url AS "https://demo.guru99.com/V4"
 And click on telecom project link
 When i click on add customer 
 Then i entr all details in application
 And click on submit button
 Then i should see one message as "Access Details to Guru99 Telecom"
 
 @addTariff
 Scenario: Add tariff 
   
   When open an application with Url AS "https://demo.guru99.com/V4"
   And click on telecom project link
   When i click on add tariff plan
   Then i entr all details in add tariff plan
   And click on submit button of tariff plan
   Then i should see one message as "Congratulation you add Tariff Plan"
 
 