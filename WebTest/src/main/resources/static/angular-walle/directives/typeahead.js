'use strict';

//walle-typeahead-code
angular.module('angularWalle')
.directive('walleTypeaheadCode', function($compile, $parse, walleSelectCode) {
	var seq = 0;
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : function($scope, $element, $attrs) {
			$scope.selectCodes = $scope.selectCodes || {};
			$scope.selectCodes[$attrs.walleTypeaheadCode] = $scope.selectCodes[$attrs.walleTypeaheadCode] || {};
			$scope.selectCodes[$attrs.walleTypeaheadCode].mapping = $scope.selectCodes[$attrs.walleTypeaheadCode].mapping || {};
			//query selectCodes data
			$scope.walleSelectCodeQuery = function(codeType, q) {
				return walleSelectCode.query(codeType, q, $attrs.typeaheadLimit)
				.then(function(response) {
					return response.data.dataList.map(function(item) {
						$scope.selectCodes[codeType].mapping[item[response.data.keyFieldName] + ''] = item[response.data.labelFieldName];
						return {
							key : item[response.data.keyFieldName],
							label : item[response.data.labelFieldName]
						};
					});
				});
			};
			//custom formatter to display label instead of key
			$scope.formatLabel = function(codetype, key, ngModel, seq) {
				$scope['walleTypeaheadNoResults' + seq] = false;
				if (! key) {
					return null;
				}
				if ($scope.selectCodes[codetype].mapping[key + '']) {
					return $scope.selectCodes[codetype].mapping[key + ''];
				} else {
					$scope['walleTypeaheadLoading' + seq] = true; 
					walleSelectCode.query(codetype, key)
					.then(function(response) {
						$scope['walleTypeaheadLoading' + seq] = false;
						if (response.data.dataList && response.data.dataList.length) {
							response.data.dataList.map(function(item) {
								$scope.selectCodes[codetype].mapping[item[response.data.keyFieldName] + ''] = item[response.data.labelFieldName];
							});
							//force re-rendering
							setTimeout(function() {
								var model = $parse(ngModel);
								model.assign($scope, null);
								$scope.$apply();
								model.assign($scope, key);
								$scope.$apply();
							});
						} else {
							$scope['walleTypeaheadNoResults' + seq] = true;
						}
					})
					.catch(function(error) {
						$scope['walleTypeaheadLoading' + seq] = false;
						$scope['walleTypeaheadNoResults' + seq] = true;
					});
					return '...';
				}
			}
			//set default value by value attr
			var model = $parse($attrs.ngModel);
			if ($attrs.value && ! model($scope)) {
				model.assign($scope, $attrs.value);
			}
		},
		link : function(scope, element, attrs) {
			seq++;
			element.removeAttr('walle-typeahead-code');
			element.attr('uib-typeahead', 'item.key as item.label for item in walleSelectCodeQuery("' + attrs.walleTypeaheadCode + '", $viewValue)');
			element.attr('typeahead-wait-ms', attrs.typeaheadWaitMs || '500');
			element.attr('typeahead-editable', attrs.typeaheadEditable || 'false');
			element.attr('typeahead-select-on-blur', attrs.typeaheadSelectOnBlur || 'true');
			//display label instead of key
			element.attr('typeahead-input-formatter', 'formatLabel("' + attrs.walleTypeaheadCode + '", $model, "' + attrs.ngModel + '", ' + seq + ')');
			//append loading prompt
			if (! attrs.typeaheadLoading) {
				element.attr('typeahead-loading', 'walleTypeaheadLoading' + seq);
				$compile('<div ng-show="walleTypeaheadLoading' + seq + '" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			}
			//append error prompt
			if (! attrs.typeaheadNoResults) {
				element.attr('typeahead-no-results', 'walleTypeaheadNoResults' + seq);
				$compile('<div ng-show="walleTypeaheadNoResults' + seq + '" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-remove"></i> </div>')(scope).insertAfter(element);
			}
			//compile
			$compile(element)(scope);
		}
	};
});
