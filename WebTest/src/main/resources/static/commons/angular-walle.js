// -- Walle Framework --

angular.module('walleApp', ['ui.bootstrap'])

.directive('walleSelectCode', ['$compile', '$http', function($compile, $http) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			$scope.selectCodes = $scope.selectCodes || {};
			if (! $scope.selectCodes[$attrs.walleSelectCode]) {
				$scope.selectCodes[$attrs.walleSelectCode] = {};
				$scope.selectCodes[$attrs.walleSelectCode].loading = true;
				$http.get('/selectCode/' + $attrs.walleSelectCode)
				.then(function(response) {
					$scope.selectCodes[$attrs.walleSelectCode].loading = false;
					$scope.selectCodes[$attrs.walleSelectCode].data = response.data.dataList.map(function(item) {
						return {
							key : item[response.data.keyFieldName],
							label : item[response.data.labelFieldName]
						}
					});
				}, function(response) {
					$scope.selectCodes[$attrs.walleSelectCode].loading = false;
					$scope.selectCodes[$attrs.walleSelectCode].error = true;
				});
			}
			if ($attrs.value) {
				$scope[$attrs.ngModel] = {
						key : $attrs.value
				};
			}
		}],
		link : function(scope, element, attrs) {
			element.removeAttr('walle-select-code');
			element.attr('ng-options', 'item as item.label for item in selectCodes.' + attrs.walleSelectCode + '.data track by item.key');
			$compile('<div ng-show="selectCodes.' + attrs.walleSelectCode + '.loading" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			$compile('<div ng-show="selectCodes.' + attrs.walleSelectCode + '.error" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-remove"></i> No Results Found </div>')(scope).insertAfter(element);
			$compile(element)(scope);
		}
	};
}])

.directive('walleTypeaheadCode', ['$compile', '$http', function($compile, $http) {
	var seq = 0;
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			$scope.walleSelectCodeQuery = function(codeType, q) {
				return $http.get('/selectCode/' + codeType + '?q=' + q + '&limit=' + ($attrs.typeaheadLoading || 10))
				.then(function(response) {
					return response.data.dataList.map(function(item) {
						return {
							key : item[response.data.keyFieldName],
							label : item[response.data.labelFieldName]
						}
					});
				});
			};
		}],
		link : function(scope, element, attrs) {
			seq++;
			element.removeAttr('walle-typeahead-code');
			element.attr('uib-typeahead', 'item as item.label for item in walleSelectCodeQuery("' + attrs.walleTypeaheadCode + '", $viewValue)');
			element.attr('typeahead-wait-ms', attrs.typeaheadWaitMs || '500');
			if (! attrs.typeaheadLoading) {
				element.attr('typeahead-loading', 'walleTypeaheadLoading' + seq);
				$compile('<div ng-show="walleTypeaheadLoading' + seq + '" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			}
			if (! attrs.typeaheadNoResults) {
				element.attr('typeahead-no-results', 'walleTypeaheadNoResults' + seq);
				$compile('<div ng-show="walleTypeaheadNoResults' + seq + '" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-remove"></i> No Results Found </div>')(scope).insertAfter(element);
			}
			$compile(element)(scope);
		}
	};
}]);
