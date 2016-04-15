'use strict';

angular.module('ngApp').config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/ellipsable-table-demo', {
		templateUrl: 'views/demo/ellipsable-table-demo.html',
		controller: 'ellipsableTableDemoCtrl'
	});
}])

.controller('ellipsableTableDemoCtrl', ['$scope', '$interval', '$timeout', '$http', function($scope, $interval, $timeout, $http) {
	$http.get('/querySlaMissedTickets')
	.success(function(data, status, headers, config) {
		$scope.sla_missed_tickets = data.records;
	})
	.error(function(data, status, headers, config) {
		$scope.sla_missed_tickets = [{
			task : data && data.error ? data.error : "Error"
		}];
	});
}]);
