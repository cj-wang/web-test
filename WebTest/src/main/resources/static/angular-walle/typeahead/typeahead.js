'use strict';

//wl-typeahead-code
angular.module('angularWalle')
.directive('wlTypeaheadCode', function($compile, $parse, wlSelectCode) {
	var seq = 0;
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		link : function(scope, element, attrs) {
			scope.wlSelectCodes = scope.wlSelectCodes || {};
			scope.wlSelectCodes[attrs.wlTypeaheadCode] = scope.wlSelectCodes[attrs.wlTypeaheadCode] || {};
			scope.wlSelectCodes[attrs.wlTypeaheadCode].mapping = scope.wlSelectCodes[attrs.wlTypeaheadCode].mapping || {};
			
			//query wlSelectCodes data
			scope.wlSelectCodeQuery = function(codeType, q) {
				return wlSelectCode.query(codeType, q, attrs.typeaheadLimit)
				.then(function(response) {
					return response.data.dataList.map(function(item) {
						scope.wlSelectCodes[codeType].mapping[item[response.data.keyFieldName] + ''] = item[response.data.labelFieldName];
						return {
							key : item[response.data.keyFieldName],
							label : item[response.data.labelFieldName]
						};
					});
				});
			};
			
			//custom formatter to display label instead of key
			scope.wlTypeaheadFormatLabel = function(codetype, key, ngModel, seq) {
				scope['wlTypeaheadNoResults' + seq] = false;
				if (! key) {
					return null;
				}
				if (scope.wlSelectCodes[codetype].mapping[key + '']) {
					return scope.wlSelectCodes[codetype].mapping[key + ''];
				} else {
					scope['wlTypeaheadLoading' + seq] = true; 
					wlSelectCode.get(codetype, key)
					.then(function(response) {
						scope['wlTypeaheadLoading' + seq] = false;
						if (response.data.dataList && response.data.dataList.length) {
							response.data.dataList.map(function(item) {
								scope.wlSelectCodes[codetype].mapping[item[response.data.keyFieldName] + ''] = item[response.data.labelFieldName] || (key + '');
							});
						} else {
							scope.wlSelectCodes[codetype].mapping[key + ''] = key + '';
						}
						//force re-rendering
						setTimeout(function() {
							var model = $parse(ngModel);
							model.assign(scope, null);
							scope.$apply();
							model.assign(scope, key);
							scope.$apply();
						});
					})
					.catch(function(error) {
						scope['wlTypeaheadLoading' + seq] = false;
						scope['wlTypeaheadNoResults' + seq] = true;
					});
					return '...';
				}
			}
			
			//set default value by value attr
			var model = $parse(attrs.ngModel);
			if (attrs.value && ! model(scope)) {
				model.assign(scope, attrs.value);
			}
			
			//handle element
			seq++;
			element.removeAttr('wl-typeahead-code');
			element.removeAttr('data-wl-typeahead-code');
			element.attr('uib-typeahead', 'item.key as item.label for item in wlSelectCodeQuery("' + attrs.wlTypeaheadCode + '", $viewValue)');
			element.attr('typeahead-wait-ms', attrs.typeaheadWaitMs || '500');
			element.attr('typeahead-editable', attrs.typeaheadEditable || 'false');
			element.attr('typeahead-select-on-blur', attrs.typeaheadSelectOnBlur || 'true');
			//display label instead of key
			element.attr('typeahead-input-formatter', 'wlTypeaheadFormatLabel("' + attrs.wlTypeaheadCode + '", $model, "' + attrs.ngModel + '", ' + seq + ')');
			
			//append loading prompt
			if (! attrs.typeaheadLoading) {
				element.attr('typeahead-loading', 'wlTypeaheadLoading' + seq);
				$compile('<div ng-show="wlTypeaheadLoading' + seq + '" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-refresh"></i> </div>')(scope).insertAfter(element);
			}
			//append error prompt
			if (! attrs.typeaheadNoResults) {
				element.attr('typeahead-no-results', 'wlTypeaheadNoResults' + seq);
				$compile('<div ng-show="wlTypeaheadNoResults' + seq + '" style="float:right; position:relative; top:-25px; right:-20px"> <i class="glyphicon glyphicon-remove"></i> </div>')(scope).insertAfter(element);
			}
			
			//compile
			$compile(element)(scope);
		}
	};
});
