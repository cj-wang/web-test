'use strict';

//walle-query-type
angular.module('ui.walle.query', ['ui.bootstrap'])
.directive('walleQueryType', ['$compile', '$parse', '$http', function($compile, $parse, $http) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : ['$scope', '$element', '$attrs', function($scope, $element, $attrs) {
			var model = $parse($attrs.ngModel);
			var query = function(pageNavigation) {
				query.loading = true;
				query.errormsg = null;
				model.assign($scope, []);
				if (! pageNavigation && $attrs.pageSize) {
					query.pagingInfo = {
							pageSize : Number($attrs.pageSize)
					};
				}
				var queryFields = [];
				if (query.queryFields) {
					angular.forEach(query.queryFields, function(value, field) {
						if (typeof value == 'string' || typeof value == 'number' || value.getMonth) {
							queryFields.push({
								fieldName : field,
								fieldStringValue : value
							});
						} else {
							angular.forEach(value, function(subvalue, operator) {
								queryFields.push({
									fieldName : field,
									fieldStringValue : subvalue,
									operator : operator
								});
							});
						}
					});
				}
				var codeTypes = $attrs.codeTypes ? angular.fromJson($attrs.codeTypes.replace(/'/g, '"')) : {};
				$http.post('/api/walle/commonQuery', {
					queryType : $attrs.walleQueryType,
					orderBy : $attrs.orderBy,
					pagingInfo : query.pagingInfo,
					fieldCodeTypes : codeTypes,
					queryFields : queryFields
				}).then(function(response) {
					model.assign($scope, response.data.dataList);
					query.loading = false;
					query.pagingInfo = response.data.pagingInfo;
					angular.forEach(response.data.dataList, function(item, index) {
						item.$index = index + 1 + (response.data.pagingInfo ? response.data.pagingInfo.currentRow : 0);
						angular.forEach(codeTypes, function(codeType, field) {
							item[field + '$label'] = response.data.selectCodeValues[codeType][item[field]];
						});
					});
				}, function(response) {
					query.loading = false;
					query.errormsg = 'Error loading data';
				});
			};
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
				element.find('> caption').prepend(
						'<uib-pagination class="pagination-sm pull-right" ng-model="'+ attrs.ngModel +'$query.pagingInfo.currentPage"' +
						'		items-per-page="'+ attrs.ngModel +'$query.pagingInfo.pageSize" total-items="'+ attrs.ngModel +'$query.pagingInfo.totalRows"' +
						'		max-size="5" boundary-link-numbers="true"' +
						'		ng-change="'+ attrs.ngModel +'$query(true)"' +
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
}]);
