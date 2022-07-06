Feature: Destination management
	The application allows to calculate the parity of the Destination Address to be assigned to each Driver.

	Scenario: Destination Address parity calculation
		Given I have the available destinations
			| fake st. 123   |
			| none st. 1122  |
			| false ave. 332 |
		When I calculate the Address characters parity
		Then I should get the result below
			| true    |
			| false   |
			| true    |