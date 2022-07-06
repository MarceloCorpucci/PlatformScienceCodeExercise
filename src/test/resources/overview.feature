Feature: Platform Science Code Exercise
	Our sales team has just struck a deal with Acme Inc to become the exclusive provider for routing their product shipments via 3rd party trucking
	fleets. The catch is that we can only route one shipment to one driver per day.
	
	Each day we get the list of shipment destinations that are available for us to offer to drivers in our network. Fortunately our team of highly trained
	data scientists have developed a mathematical model for determining which drivers are best suited to deliver each shipment.
	
	For this implementation, we will find a library intended to get a list of Drivers and Destination and to calculate one destination per Driver.
	This library can be connected to any kind of Application (desktop, web, API, etc).
	
	The BDD scenarios written here act as the Living documentation of the whole project.
	
	Background: Available Entities
		Given I have the following domain entities
			| Driver |
			| Destination |
			| SuitabilityScore |
		When I want to consume their functionality
			
	Scenario: Driver features
		Then I should get the following Driver features
			| setName |
			| getName |
			| calculateNameAlgorithm |
			| getVowelAmount |
			| getConsonantAmount |
	
	Scenario: Destination features
		Then I should get the following Destination features
			| getAddress |
			| setAddress |
			| hasEvenChars |
			| isAssigned |
			| setAssignation |
			| defineAdressCharAmountParity |
			
	Scenario: Suitability Score features
		Then I should get the following Suitability Score features
			| calculate |
			| getMaxScorePerDriver |
			| getDriverPerDestination |