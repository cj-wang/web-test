'use strict';

angular.module('angularWalle')
.directive('clickToPause', function($compile, Flash) {
    return {
        restrict: 'A',
		terminal : true,
		priority : 1000,
        link: function (scope, element, attrs) {
        	scope.pauseFlash = function($compile) {
        		for(var i = 0; i < scope.$root.flashes.length; i++) {
        			Flash.pause(i);
        		}
        	};
			element.removeAttr('click-to-pause');
        	element.attr('ng-click', 'pauseFlash()');
			$compile(element)(scope);
        }
    };
});