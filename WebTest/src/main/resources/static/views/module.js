'use strict';

angular.module('ngApp', ['ui.router', 'ngAnimate', 'ui.walle', 'angularBootstrapNavTree'])
.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
	
	$stateProvider
	.state('app', {
		url : '/?contentOnly',
		views: {
			header : {
				templateUrl : function(params) {
					if (! params.contentOnly) {
						return '/views/index/header.html';
					}
				}
			},
			content : {
				templateUrl : '/views/index/welcome.html'	
			},
			footer : {
				templateUrl : function(params) {
					if (! params.contentOnly) {
						return '/views/index/footer.html';
					}
				}
			}
		}
	});
	
	$urlRouterProvider.otherwise(function($injector, $location) {
		return '/';
	});
	
	// use the HTML5 History API
    $locationProvider.html5Mode(true);
    
});
