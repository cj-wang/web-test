'use strict';

angular.module('ngApp')
.config(function($routeProvider) {
	$routeProvider.when('/ellipsable-table-demo', {
		templateUrl: 'views/demo/ellipsable-table-demo.html',
		controller: 'ellipsableTableDemoCtrl'
	});
})

.controller('ellipsableTableDemoCtrl', function($scope, $http) {
	$http.get('/querySlaMissedTickets')
	.then(function(response) {
		$scope.sla_missed_tickets = response.data.records;
	})
	.catch(function(error) {
		$scope.sla_missed_tickets = [{
			task : error || "Error"
		}];
	});
});
