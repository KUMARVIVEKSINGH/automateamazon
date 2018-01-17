Narrative: 

In order to show the basic checkout functionality
As a user
I want to chekcout items in my cart

Scenario: Item can be checkout
Given I login to the amazon website
And Search for a product <productName>
And I click on the first record
When I select capacity <capacity>
Then I can View the product details <price> and <discount>
When I Select <quantity>
And I Click on Add to cart
And I Click on proceed to checkout
Then I can Look for payment options
And I can Logout
Examples:
|productName					|capacity	|price		|discount		|quantity	|
|seagate external hard drive 	|4TB	  	|$104.00	|$25.99 (20%)	|2			|