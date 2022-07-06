Feature: Suitability Score
	The top-secret algorithm is:
	
	If the length of the shipment's destination street name is even, the base suitability score (SS) is the number of vowels in the driver’s
	name multiplied by 1.5.
	
	If the length of the shipment's destination street name is odd, the base SS is the number of consonants in the driver’s name multiplied by
	1.

	Background: Prerequisites to get SS calculation
		Given I already count with a list of Drivers
		 	| John   |
			| Walter |
			| Dan    |
		
	Scenario: Suitability Score calculation types
		Given I have the following destination list
			| fake st. 123   |
			| none st. 1122  |
			| false ave. 332 |
		When I calculate the suitability score
		Then I should get the results bellow
			| Driver | Score | Destination Address |
			| John   | 3.0   | none st. 1122       |
			| Walter | 3.0   | fake st. 123        |
			| Dan    | 1.5   | false ave. 332      |
			
