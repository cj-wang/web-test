// -- Walle Framework --

angular.module('walleApp', [])
.controller('walleCtrl', ['$scope', '$interval', '$timeout', '$http', function($scope, $interval, $timeout, $http) {
	$scope.selectCodes = {};
}])
.directive('walleSelectCode', ['$http', function($http) {
	return {
		restrict : 'A',
		scope : {},
		link : function(scope, element, attrs) {
			scope.attrs = attrs;
			if (scope.$parent.selectCodes[attrs.walleSelectCode]) {
				scope.selectCode = scope.$parent.selectCodes[attrs.walleSelectCode];
			} else {
				scope.selectCode = scope.$parent.selectCodes[attrs.walleSelectCode] = {};
				scope.selectCode.loading = true;
				$http.get('/selectCode/' + attrs.walleSelectCode)
				.success(function(data, status, headers, config) {
					scope.selectCode.loading = false;
					scope.selectCode.data = data;
				})
				.error(function(data, status, headers, config) {
					scope.selectCode.loading = false;
					scope.selectCode.error = true;
				});
			}
		},
		template :
			'<option ng-if="selectCode.loading">Loading...</option>' +
			'<option ng-if="selectCode.error">Error Loading data</option>' +
			'<option ng-repeat="dataItem in selectCode.data.dataList"' +
			'		value="{{dataItem[selectCode.data.keyFieldName]}}"' +
			'		ng-selected="dataItem[selectCode.data.keyFieldName] == attrs.value">' +
			'	{{dataItem[selectCode.data.labelFieldName]}}' +
			'</option>'
	};
}]);
