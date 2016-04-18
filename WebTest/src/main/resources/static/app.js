'use strict';

angular.module('ngApp', ['ngRoute', 'ui.walle']).
config(['$locationProvider', function($locationProvider) {
	// use the HTML5 History API
    $locationProvider.html5Mode(true);
}]);
