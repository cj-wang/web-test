'use strict';

angular.module('ngApp')
.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
	
	$stateProvider
	.state('app', {
		url : '/',
		views: {
			header : {
				templateUrl : '/views/index/header.html'
			},
			content : {
				templateUrl : '/views/index/welcome.html'	
			},
			footer : {
				templateUrl : '/views/index/footer.html'
			}
		}
	});
	
	$urlRouterProvider.otherwise(function($injector, $location) {
		if ($location.url().indexOf('.') >= 0) {
			location.reload();
		} else {
			return '/';
		}
	});
	
	// use the HTML5 History API
    $locationProvider.html5Mode(true);
    
});
