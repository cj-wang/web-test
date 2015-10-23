// -- Walle Framework --

angular.module('walleApp', [])
.controller('walleCtrl', ['$scope', '$interval', '$timeout', '$http', function($scope, $interval, $timeout, $http) {
	
}])
.directive('walleSelectcode', ['$http', function($http) {
	return {
		scope : {},
		link : function(scope, element, attrs) {
			scope.loading = true;
			scope.value = attrs.value;
			$http.get('/selectCode/' + attrs.walleSelectcode)
			.success(function(data, status, headers, config) {
				scope.loading = false;
				scope.data = data;
			})
			.error(function(data, status, headers, config) {
				scope.loading = false;
				scope.error = "Error loading data";
			});
		},
		template :
			'<option ng-if="loading">Loading...</option>' +
			'<option ng-if="error">Error Loading data</option>' +
			'<option ng-repeat="dataItem in data.dataList"' +
			'		value="{{dataItem[data.keyFieldName]}}"' +
			'		ng-selected="dataItem[data.keyFieldName] == value">' +
			'	{{dataItem[data.labelFieldName]}}' +
			'</option>'
	};
}]);
