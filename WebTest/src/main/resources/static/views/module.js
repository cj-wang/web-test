'use strict';

angular.module('ngApp')
.config(function($routeProvider, $locationProvider) {
	$routeProvider.otherwise({redirectTo: function(parameters, path, search) {
		if (path.indexOf('.') >= 0) {
			location.reload();
		}
	}});
	// use the HTML5 History API
    $locationProvider.html5Mode(true);
});
