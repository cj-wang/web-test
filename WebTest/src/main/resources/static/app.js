'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.version',
  'myApp.view1',
  'myApp.view2',
  'myApp.demo'
]).
config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
	$routeProvider.otherwise({redirectTo: 'view1'});
	// use the HTML5 History API
    $locationProvider.html5Mode(true);
}]);
