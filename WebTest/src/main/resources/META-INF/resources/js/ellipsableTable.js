angular.module('wbApp', [])
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
	
}])
//truncate table cells with ellipsis
//ref: http://stackoverflow.com/questions/5239758/css-truncate-table-cells-but-fit-as-much-as-possible
.directive('ngCustEllipsable', function() {
	return {
		restrict : 'C',
		transclude: true,
		template :
			'<div style="position:relative">' +
			'	<div ng-transclude style="position:absolute; max-width:100%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;"></div>' +
			'	<div ng-transclude style="display:inline-block; height:0; overflow:hidden;"></div>' +
			'</div>'
	};
});
