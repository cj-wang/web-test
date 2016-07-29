'use strict';

//wl-select-code
angular.module('angularWalle')
.directive('wlSelectCode', function($compile, $parse, wlSelectCode) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		link : function(scope, element, attrs) {
			scope.selectCodes = scope.selectCodes || {};
			
			//query selectCodes data
			if (! scope.selectCodes[attrs.wlSelectCode]) {
				scope.selectCodes[attrs.wlSelectCode] = {};
				scope.selectCodes[attrs.wlSelectCode].loading = true;
				wlSelectCode.getAll(attrs.wlSelectCode)
				.then(function(response) {
					scope.selectCodes[attrs.wlSelectCode].loading = false;
					scope.selectCodes[attrs.wlSelectCode].data = response.data.dataList.map(function(item) {
						return {
							key : item[response.data.keyFieldName],
							label : item[response.data.labelFieldName]
						};
					});
				})
				.catch(function(error) {
					scope.selectCodes[attrs.wlSelectCode].loading = false;
					scope.selectCodes[attrs.wlSelectCode].error = true;
				});
			}
			
			//set default value by value attr
			var model = $parse(attrs.ngModel);
			if (attrs.value && ! model(scope)) {
				model.assign(scope, attrs.value);
			}
			
			//if required, select the 1st option by default
			if (attrs.required && ! model(scope)) {
				scope.$watch('selectCodes.' + attrs.wlSelectCode + '.data', function(newValue, oldValue) {
					if (scope.selectCodes[attrs.wlSelectCode].data && scope.selectCodes[attrs.wlSelectCode].data.length) {
						model.assign(scope, scope.selectCodes[attrs.wlSelectCode].data[0].key);
					}
				});
			}
			
			//handle element
			element.removeAttr('wl-select-code');
			element.removeAttr('data-wl-select-code');
			element.attr('ng-options', 'item.key as item.label for item in selectCodes.' + attrs.wlSelectCode + '.data');
			//if not required, add an empty option
			if (! attrs.required) {
				element.append('<option value=""> - - - </option>');
			}
			
			//append loading prompt
			$compile('<div ng-show="selectCodes.' + attrs.wlSelectCode + '.loading" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			//append error prompt
			$compile('<div ng-show="selectCodes.' + attrs.wlSelectCode + '.error" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-remove"></i> </div>')(scope).insertAfter(element);
			
			//compile
			$compile(element)(scope);
		}
	};
});
