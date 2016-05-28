'use strict';

angular.module('angularWalle')
.controller('flashCtrl', function($scope, $rootScope, Flash) {

	$scope.pauseFlash = function() {
		for(var i = 0; i < $rootScope.flashes.length; i++) {
			Flash.pause(i);
		}
	};
	
});