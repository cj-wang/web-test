'use strict';

//wl-table
angular.module('angularWalle')
.directive('wlTable', function($compile, $parse, wlCommonQuery) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : function($scope, $element, $attrs) {
			var query = {
					queryInfo : {
						queryType : $attrs.queryType,
						orderBy : $attrs.orderBy,
						pagingInfo : $attrs.pageSize ? {pageSize : Number($attrs.pageSize)} : undefined,
						fieldCodeTypes : $attrs.codeTypes ? angular.fromJson($attrs.codeTypes) : undefined
					},
					load : function() {
						query.loading = true;
						query.errormsg = null;
						wlCommonQuery.query(query.queryInfo)
						.then(function(response) {
							$parse($attrs.ngModel).assign($scope, response.data.dataList);
							query.loading = false;
							query.queryInfo.pagingInfo = response.data.pagingInfo;
							angular.forEach(response.data.dataList, function(item, index) {
								item.$index = index + 1 + (response.data.pagingInfo ? response.data.pagingInfo.currentRow : 0);
								if (query.queryInfo.fieldCodeTypes) {
									angular.forEach(query.queryInfo.fieldCodeTypes, function(codeType, field) {
										item[field + '$label'] = response.data.selectCodeValues[codeType][item[field]];
									});
								}
							});
						})
						.catch(function(error) {
							query.loading = false;
							query.errormsg = 'Error loading data';
						});
					},
					query : function() {
						query.queryInfo.pagingInfo = $attrs.pageSize ? {pageSize : Number($attrs.pageSize)} : undefined;
						query.load();
					}
			};
			$parse($attrs.ngModel + 'Query').assign($scope, query);
			query.query();
		},
		link : function(scope, element, attrs) {
			element.removeAttr('wl-table');
			//paging
			if (attrs.pageSize) {
				if (! element.find('> caption').length) {
					element.prepend('<caption></caption>');
				}
				scope.Math || (scope.Math = Math);
				element.find('> caption').prepend(
						'<uib-pagination class="pagination-sm pull-right" ng-model="'+ attrs.ngModel +'Query.queryInfo.pagingInfo.currentPage"' +
						'		items-per-page="'+ attrs.ngModel +'Query.queryInfo.pagingInfo.pageSize" total-items="'+ attrs.ngModel +'Query.queryInfo.pagingInfo.totalRows"' +
						'		max-size="5" boundary-link-numbers="true"' +
						'		ng-change="'+ attrs.ngModel +'Query.load()"' +
						'		style="margin:0">' +
						'</uib-pagination>' +
						'<div class="pull-right" style="margin-top:5px;margin-right:10px">' +
						'	{{Math.min('+ attrs.ngModel +'Query.queryInfo.pagingInfo.pageSize * (('+ attrs.ngModel +'Query.queryInfo.pagingInfo.currentPage || 1) - 1) + 1, '+ attrs.ngModel +'Query.queryInfo.pagingInfo.totalRows || 0)}}' +
						'	 - ' +
						'	{{Math.min('+ attrs.ngModel +'Query.queryInfo.pagingInfo.pageSize * (('+ attrs.ngModel +'Query.queryInfo.pagingInfo.currentPage || 1) - 1) + ('+ attrs.ngModel +'Query.loading ? '+ attrs.ngModel +'Query.queryInfo.pagingInfo.pageSize : '+ attrs.ngModel +'.length), '+ attrs.ngModel +'Query.queryInfo.pagingInfo.totalRows || 0)}}' +
						'	 / ' +
						'	{{'+ attrs.ngModel +'Query.queryInfo.pagingInfo.totalRows || 0}}' +
						'</div>' +
						'<div class="pull-right" style="margin-top:5px;margin-right:10px">' +
						'	<span ng-show="'+ attrs.ngModel +'Query.loading" class="glyphicon glyphicon-refresh" aria-hidden="true"></span>' +
						'	<span class="text-danger">{{'+ attrs.ngModel +'Query.errormsg}}</span>' +
						'</div>');
			}
			//compile
			$compile(element)(scope);
		}
	};
});
