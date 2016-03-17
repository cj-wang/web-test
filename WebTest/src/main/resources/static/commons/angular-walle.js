// -- Walle Framework --

angular.module('ui.walle', ['ui.bootstrap'])

//walle-query-type
.directive('walleQueryType', ['$compile', '$parse', '$http', function($compile, $parse, $http) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			var model = $parse($attrs.ngModel);
			var query = function() {
				query.loading = true;
				query.errormsg = null;
				model.assign($scope, []);
				$http.post('/commonQuery', {
					queryType : $attrs.walleQueryType,
					orderBy : $attrs.orderBy,
					pagingInfo : query.pagingInfo,
					fieldCodeTypes : query.codeTypes
				}).then(function(response) {
					model.assign($scope, response.data.dataList);
					query.loading = false;
					query.pagingInfo = response.data.pagingInfo;
					angular.forEach(response.data.dataList, function(item, index) {
						item.$index = index + 1 + (response.data.pagingInfo ? response.data.pagingInfo.currentRow : 0);
						angular.forEach(query.codeTypes, function(codeType, field) {
							item[field + '$label'] = response.data.selectCodeValues[codeType][item[field]];
						});
					});
				}, function(response) {
					query.loading = false;
					query.errormsg = 'Error loading data';
				});
			};
			query.codeTypes = $attrs.codeTypes ? angular.fromJson($attrs.codeTypes.replace(/'/g, '"')) : {};
			if ($attrs.pageSize) {
				query.pagingInfo = {
						pageSize : Number($attrs.pageSize)
				};
			}
			$parse($attrs.ngModel + '$query').assign($scope, query);
			query();
		}],
		link : function(scope, element, attrs) {
			element.removeAttr('walle-query-type');
			//paging
			if (attrs.pageSize) {
				if (! element.find('> caption').length) {
					element.prepend('<caption></caption>');
				}
				scope.Math || (scope.Math = Math);
				element.find('> caption').append(
						'<uib-pagination class="pagination-sm pull-right" ng-model="'+ attrs.ngModel +'$query.pagingInfo.currentPage"' +
						'		items-per-page="'+ attrs.ngModel +'$query.pagingInfo.pageSize" total-items="'+ attrs.ngModel +'$query.pagingInfo.totalRows"' +
						'		max-size="5" boundary-link-numbers="true"' +
						'		ng-change="'+ attrs.ngModel +'$query()"' +
						'		style="margin:0">' +
						'</uib-pagination>' +
						'<div class="pull-right" style="margin-top:5px;margin-right:10px">' +
						'	{{Math.min('+ attrs.ngModel +'$query.pagingInfo.pageSize * (('+ attrs.ngModel +'$query.pagingInfo.currentPage || 1) - 1) + 1, '+ attrs.ngModel +'$query.pagingInfo.totalRows || 0)}}' +
						'	 - ' +
						'	{{Math.min('+ attrs.ngModel +'$query.pagingInfo.pageSize * (('+ attrs.ngModel +'$query.pagingInfo.currentPage || 1) - 1) + ('+ attrs.ngModel +'$query.loading ? '+ attrs.ngModel +'$query.pagingInfo.pageSize : '+ attrs.ngModel +'.length), '+ attrs.ngModel +'$query.pagingInfo.totalRows || 0)}}' +
						'	 / ' +
						'	{{'+ attrs.ngModel +'$query.pagingInfo.totalRows || 0}}' +
						'</div>');
			}
			//append loading prompt
			$compile('<div>&nbsp;<span ng-show="'+ attrs.ngModel +'$query.loading" class="glyphicon glyphicon-refresh" aria-hidden="true"></span><span class="text-danger">{{'+ attrs.ngModel +'$query.errormsg}}</span>')(scope).insertAfter(element);
			//compile
			$compile(element)(scope);
		}
	};
}])

//walle-select-code
.directive('walleSelectCode', ['$compile', '$parse', '$http', function($compile, $parse, $http) {
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
			var model = $parse($attrs.ngModel);
			if ($attrs.value && ! model($scope)) {
				model.assign($scope, $attrs.value);
			}
			//if required, select the 1st option by default
			if ($attrs.required && ! model($scope)) {
				$scope.$watch('selectCodes.' + $attrs.walleSelectCode + '.data', function(newValue, oldValue) {
					if ($scope.selectCodes[$attrs.walleSelectCode].data && $scope.selectCodes[$attrs.walleSelectCode].data.length) {
						model.assign($scope, $scope.selectCodes[$attrs.walleSelectCode].data[0].key);
					}
				});
			}
		}],
		link : function(scope, element, attrs) {
			element.removeAttr('walle-select-code');
			element.attr('ng-options', 'item.key as item.label for item in selectCodes.' + attrs.walleSelectCode + '.data');
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
.directive('walleTypeaheadCode', ['$compile', '$parse', '$http', function($compile, $parse, $http) {
	var seq = 0;
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			$scope.selectCodes = $scope.selectCodes || {};
			$scope.selectCodes[$attrs.walleTypeaheadCode] = $scope.selectCodes[$attrs.walleTypeaheadCode] || {};
			$scope.selectCodes[$attrs.walleTypeaheadCode].mapping = $scope.selectCodes[$attrs.walleTypeaheadCode].mapping || {};
			//query selectCodes data
			$scope.walleSelectCodeQuery = function(codeType, q) {
				return $http.get('/selectCode/' + codeType + '?q=' + q + '&limit=' + ($attrs.typeaheadLoading || 10))
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
					$http.get('/selectCode/' + codetype + '?q=' + key)
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
					}, function() {
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
		}],
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
