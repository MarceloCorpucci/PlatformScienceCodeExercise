Feature: Driver management
	This application receives a List of Drivers organized by name.

	Scenario: Driver options
		Given I've entered the following drivers 
			| John   |
			| Walter |
			| Dan    |
		When I get the name calculation
		Then I should get the following results
			| Vowels | Consontants |
			| 1      | 3           |
			| 2      | 4           |
			| 1      | 2           |
