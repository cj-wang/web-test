// -- Walle Framework --

angular.module('walleApp', ['ui.bootstrap'])

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
		terminal : true,
		priority : 1000,
		link : function(scope, element, attrs) {
			if (scope.$walleSeq == undefined) {
				scope.$walleSeq = 0;
			}
			var seq = scope.$walleSeq++;
			if (! scope.$walleSelectCodeQuery) {
				scope.$walleSelectCodeQuery = function(codeType, q) {
					return $http.get('/selectCode/' + codeType + '?q=' + q + '&limit=' + (attrs.typeaheadLoading || 10))
					.then(function(response){
						return response.data.dataList.map(function(item){
							return {
								key: item[response.data.keyFieldName],
								label: item[response.data.labelFieldName]
							}
						});
					});
				};
			}
			element.removeAttr('walle-typeahead-code');
			element.attr('uib-typeahead', 'item as item.label for item in $walleSelectCodeQuery("' + attrs.walleTypeaheadCode + '", $viewValue)');
			element.attr('typeahead-wait-ms', attrs.typeaheadWaitMs || '500');
			if (! attrs.typeaheadLoading) {
				element.attr('typeahead-loading', '$walleTypeaheadLoading' + seq);
				$compile('<i ng-show="$walleTypeaheadLoading' + seq + '" class="glyphicon glyphicon-refresh pull-left"></i>')(scope).insertAfter(element);
			}
			if (! attrs.typeaheadNoResults) {
				element.attr('typeahead-no-results', '$walleTypeaheadNoResults' + seq);
				$compile('<div ng-show="$walleTypeaheadNoResults' + seq + '"> <i class="glyphicon glyphicon-remove"></i> No Results Found </div>')(scope).insertAfter(element);
			}
			$compile(element)(scope);
		}
	};
}]);
