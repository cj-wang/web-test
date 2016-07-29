'use strict';

//wl-select-code
angular.module('angularWalle')
.directive('wlSelectCode', function($compile, $parse, wlSelectCode) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		link : function(scope, element, attrs) {
			scope.wlSelectCodes = scope.wlSelectCodes || {};
			
			//query wlSelectCodes data
			if (! scope.wlSelectCodes[attrs.wlSelectCode]) {
				scope.wlSelectCodes[attrs.wlSelectCode] = {};
				scope.wlSelectCodes[attrs.wlSelectCode].loading = true;
				wlSelectCode.getAll(attrs.wlSelectCode)
				.then(function(response) {
					scope.wlSelectCodes[attrs.wlSelectCode].loading = false;
					scope.wlSelectCodes[attrs.wlSelectCode].data = response.data.dataList.map(function(item) {
						return {
							key : item[response.data.keyFieldName],
							label : item[response.data.labelFieldName]
						};
					});
				})
				.catch(function(error) {
					scope.wlSelectCodes[attrs.wlSelectCode].loading = false;
					scope.wlSelectCodes[attrs.wlSelectCode].error = true;
				});
			}
			
			//set default value by value attr
			var model = $parse(attrs.ngModel);
			if (attrs.value && ! model(scope)) {
				model.assign(scope, attrs.value);
			}
			
			//if required, select the 1st option by default
			if (attrs.required && ! model(scope)) {
				scope.$watch('wlSelectCodes.' + attrs.wlSelectCode + '.data', function(newValue, oldValue) {
					if (scope.wlSelectCodes[attrs.wlSelectCode].data && scope.wlSelectCodes[attrs.wlSelectCode].data.length) {
						model.assign(scope, scope.wlSelectCodes[attrs.wlSelectCode].data[0].key);
					}
				});
			}
			
			//handle element
			element.removeAttr('wl-select-code');
			element.removeAttr('data-wl-select-code');
			element.attr('ng-options', 'item.key as item.label for item in wlSelectCodes.' + attrs.wlSelectCode + '.data');
			//if not required, add an empty option
			if (! attrs.required) {
				element.append('<option value=""> - - - </option>');
			}
			
			//append loading prompt
			$compile('<div ng-show="wlSelectCodes.' + attrs.wlSelectCode + '.loading" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			//append error prompt
			$compile('<div ng-show="wlSelectCodes.' + attrs.wlSelectCode + '.error" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-remove"></i> </div>')(scope).insertAfter(element);
			
			//compile
			$compile(element)(scope);
		}
	};
});
