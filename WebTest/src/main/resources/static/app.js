'use strict';

angular.module('ngApp', ['ngRoute', 'ui.walle']).
config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
	$routeProvider.otherwise({redirectTo: 'view1'});
	// use the HTML5 History API
    $locationProvider.html5Mode(true);
}]);
