'use strict';

//walle-validate
//Thanks to Ivan Tanev 
//https://ivantanev.com/blog/2014/12/10/angularjs-dos-and-donts/
angular.module('angularWalle')
.directive('walleValidate', function($compile, ngMessagesInclude) {
    return {
        restrict: 'A',
		terminal : true,
		priority : 1000,
        link: function (scope, element, attrs) {
			element.removeAttr('walle-validate');
        	element.attr('novalidate', '');
        	element.find('.form-group').each(function(index, formGroup) {
        		formGroup = jQuery(formGroup);
        		if (formGroup.find('input[name]').size() > 0) {
        			formGroup.attr('show-errors', '')
        			.append('<div ng-messages="' + attrs.name + '.' + formGroup.find('input[name]').attr('name') + '.$error">' +
        					'	<div ng-messages-include="' + ngMessagesInclude + '"></div>' +
        					'</div>');
        		}
        	});
			$compile(element)(scope);
        }
    };
})

.directive('showErrors', ['$timeout', function($timeout) {
    return {
        restrict: 'A',
        require:  '^form',
        link: function ($scope, $element, attrs, ngFormCtrl) {
            // this timeout is necessary to handle the case when we have
            // ng generated code inside of the show-errors element.

            // usually this can be done by setting the directive to "terminal: true",
            // but we want to allow interpolation of child elements, so we just
            // offset the attachment of the watchers until the browser renders
            // the next frame, by using a $timeout(func, 0, false); The false means
            // "don't trigger a digest cycle", because we don't change any variables
            $timeout(function() {
                // we search for a .form-control whose name attriubte is set
                var childInputName = $element[0].querySelector('.form-control[name]');
                    childInputName = childInputName && childInputName.getAttribute('name');

                if (!childInputName || angular.isUndefined(ngFormCtrl[childInputName])) {
                    // if we cannot find the expected element, throw an error and
                    // halt compilation
                    throw 'showError directive requires that you have a child `.form-control` element with a `name` attribute.';
                }

                // https://docs.angularjs.org/api/ng/type/$rootScope.Scope#$watch
                $scope.$watch(function() {
                    // on scope changes, check if the input's validation status has changed.
                    // additionally, if an input has not been touched or the form has not been
                    // yet submitted, consider the element valid
                    return ngFormCtrl[childInputName].$invalid
                        && (ngFormCtrl[childInputName].$touched || ngFormCtrl[childInputName].$dirty || ngFormCtrl.$submitted);
                }, function(is_invalid) {
                    $element.toggleClass('has-error', is_invalid);
                });
            }, 0, false);
        },
    };
}]);
