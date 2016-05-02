'use strict';

angular.module('ngApp')
.config(function($stateProvider) {
	$stateProvider
	.state('app.ellipsable-table-demo', {
		url : 'ellipsable-table-demo',
		views : {
			'content@' : {
				templateUrl : 'app/demo/ellipsable-table-demo.html',
				controller : 'ellipsableTableDemoCtrl'
			}
		}
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
