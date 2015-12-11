// -- Walle Framework --

angular.module('walleApp', ['ui.bootstrap'])

.controller('walleCtrl', ['$scope', '$interval', '$timeout', '$http', function($scope, $interval, $timeout, $http) {
	
}])

.directive('walleSelectCode', ['$http', function($http) {
	return {
		restrict : 'A',
		scope : {},
		link : function(scope, element, attrs) {
			scope.attrs = attrs;
			scope.$root.selectCodes = scope.$root.selectCodes || {};
			if (scope.$root.selectCodes[attrs.walleSelectCode]) {
				scope.selectCode = scope.$root.selectCodes[attrs.walleSelectCode];
			} else {
				scope.selectCode = scope.$root.selectCodes[attrs.walleSelectCode] = {};
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
			'<option ng-if="! attrs.required" value="">---Please select---</option>' +
			'<option ng-if="selectCode.loading" value="">Loading...</option>' +
			'<option ng-if="selectCode.error" value="">Error loading data</option>' +
			'<option ng-repeat="dataItem in selectCode.data.dataList"' +
			'		value="{{dataItem[selectCode.data.keyFieldName]}}"' +
			'		ng-selected="dataItem[selectCode.data.keyFieldName] == attrs.value">' +
			'	{{dataItem[selectCode.data.labelFieldName]}}' +
			'</option>'
	};
}])

.directive('walleTypeaheadCode', ['$compile', '$http', function($compile, $http) {
	return {
		restrict : 'A',
		scope : {},
	    terminal: true,
		link : function(scope, element, attrs) {
			scope.attrs = attrs;
			scope.query = function(val) {
				return $http.get('//maps.googleapis.com/maps/api/geocode/json', {
					params: {
						address: val,
						sensor: false
					}
				}).then(function(response){
					return response.data.results.map(function(item){
						return item.formatted_address;
					});
				});
			};
			element.attr('uib-typeahead', 'address for address in query($viewValue)');
			element.attr('typeahead-loading', attrs.typeaheadLoading || 'loading');
			element.attr('typeahead-no-results', attrs.typeaheadNoResults || 'noResults');
			element.attr('typeahead-wait-ms', attrs.typeaheadWaitMs || '500');
			element.removeAttr('walle-typeahead-code');
			$compile(element)(scope);
			$compile('<i ng-show="loading" class="glyphicon glyphicon-refresh pull-left"></i>')(scope).insertAfter(element);
			$compile('<div ng-show="noResults"> <i class="glyphicon glyphicon-remove"></i> No Results Found </div>')(scope).insertAfter(element);
		}
	};
}]);
