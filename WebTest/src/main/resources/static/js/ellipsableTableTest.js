angular.module('wbApp', ['ngEllipsable'])
.controller('myController', ['$scope', '$interval', '$timeout', '$http', function($scope, $interval, $timeout, $http) {
	
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
