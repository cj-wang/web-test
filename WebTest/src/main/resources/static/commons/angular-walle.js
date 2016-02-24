// -- Walle Framework --

angular.module('walleApp', ['ui.bootstrap'])

//walle-select-code
.directive('walleSelectCode', ['$compile', '$http', function($compile, $http) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			$scope.selectCodes = $scope.selectCodes || {};
			//query selectCodes data
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
						};
					});
				}, function(response) {
					$scope.selectCodes[$attrs.walleSelectCode].loading = false;
					$scope.selectCodes[$attrs.walleSelectCode].error = true;
				});
			}
			//set default value by value attr
			if ($attrs.value && ! $scope[$attrs.ngModel]) {
				$scope[$attrs.ngModel] = {
						key : $attrs.value
				};
			}
			//if required, select the 1st option by default
			if ($attrs.required && ! $scope[$attrs.ngModel]) {
				$scope.$watch('selectCodes.' + $attrs.walleSelectCode + '.data', function(newValue, oldValue) {
					if ($scope.selectCodes[$attrs.walleSelectCode].data) {
						$scope[$attrs.ngModel] = $scope.selectCodes[$attrs.walleSelectCode].data[0];
					}
				});
			}
		}],
		link : function(scope, element, attrs) {
			element.removeAttr('walle-select-code');
			element.attr('ng-options', 'item as item.label for item in selectCodes.' + attrs.walleSelectCode + '.data track by item.key');
			//if not required, add an empty option
			if (! attrs.required) {
				element.append('<option value=""> - - - </option>');
			}
			//append loading prompt
			$compile('<div ng-show="selectCodes.' + attrs.walleSelectCode + '.loading" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			//append error prompt
			$compile('<div ng-show="selectCodes.' + attrs.walleSelectCode + '.error" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-remove"></i> No Results Found </div>')(scope).insertAfter(element);
			//compile
			$compile(element)(scope);
		}
	};
}])

//walle-typeahead-code
.directive('walleTypeaheadCode', ['$compile', '$http', function($compile, $http) {
	var seq = 0;
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			var currentSeq = ++seq;
			//query selectCodes data
			$scope.walleSelectCodeQuery = function(codeType, q) {
				return $http.get('/selectCode/' + codeType + '?q=' + q + '&limit=' + ($attrs.typeaheadLoading || 10))
				.then(function(response) {
					return response.data.dataList.map(function(item) {
						return {
							key : item[response.data.keyFieldName],
							label : item[response.data.labelFieldName]
						};
					});
				});
			};
			//set default value by value attr
			if ($attrs.value && ! $scope[$attrs.ngModel]) {
				$scope[$attrs.ngModel] = {
						key : $attrs.value
				};
			}
			//load display text for the default value
			if ($scope[$attrs.ngModel]) {
				$scope[$attrs.ngModel].label = "...";
				$scope['walleTypeaheadLoading' + currentSeq] = true;
				$http.get('/selectCode/' + $attrs.walleTypeaheadCode + '?q=' + $scope[$attrs.ngModel].key)
				.then(function(response) {
					$scope['walleTypeaheadLoading' + currentSeq] = false;
					if (response.data.dataList && response.data.dataList.length) {
						$scope[$attrs.ngModel] = {
								key : $scope[$attrs.ngModel].key,
								label : response.data.dataList[0][response.data.labelFieldName]
						};
					} else {
						$scope['walleTypeaheadNoResults' + currentSeq] = true;
						$scope[$attrs.ngModel] = {
								key : $scope[$attrs.ngModel].key,
								label : $scope[$attrs.ngModel].key
						};
					}
				}, function(response) {
					$scope['walleTypeaheadLoading' + currentSeq] = false;
					$scope['walleTypeaheadNoResults' + currentSeq] = true;
					$scope[$attrs.ngModel] = {
							key : $scope[$attrs.ngModel].key,
							label : $scope[$attrs.ngModel].key
					};
				});
			}
		}],
		link : function(scope, element, attrs) {
			element.removeAttr('walle-typeahead-code');
			element.attr('uib-typeahead', 'item as item.label for item in walleSelectCodeQuery("' + attrs.walleTypeaheadCode + '", $viewValue)');
			element.attr('typeahead-wait-ms', attrs.typeaheadWaitMs || '500');
			//append loading prompt
			if (! attrs.typeaheadLoading) {
				element.attr('typeahead-loading', 'walleTypeaheadLoading' + seq);
				$compile('<div ng-show="walleTypeaheadLoading' + seq + '" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			}
			//append error prompt
			if (! attrs.typeaheadNoResults) {
				element.attr('typeahead-no-results', 'walleTypeaheadNoResults' + seq);
				$compile('<div ng-show="walleTypeaheadNoResults' + seq + '" style="position:fixed;padding-left:10px"> <i class="glyphicon glyphicon-remove"></i> No Results Found </div>')(scope).insertAfter(element);
			}
			//compile
			$compile(element)(scope);
		}
	};
}]);
