'use strict';

angular.module('ngApp', ['ui.router', 'ngAnimate', 'ui.walle', 'angularBootstrapNavTree'])
.controller('indexCtrl', function($scope, $location) {
	$scope.params = $location.search();
});
