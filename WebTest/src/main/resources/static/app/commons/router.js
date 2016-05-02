'use strict';

angular.module('ngApp')
.config(function($stateProvider, $urlRouterProvider, $urlMatcherFactoryProvider, $locationProvider) {
	
	$stateProvider
	.state('app', {
		url : '/?contentOnly',
		views: {
			header : {
				templateUrl : function(params) {
					if (! params.contentOnly) {
						return 'app/index/header.html';
					}
				}
			},
			content : {
				templateUrl : 'app/index/welcome.html'	
			},
			footer : {
				templateUrl : function(params) {
					if (! params.contentOnly) {
						return 'app/index/footer.html';
					}
				}
			}
		}
	});
	
	$urlRouterProvider.otherwise(function($injector, $location) {
		return '/';
	});
	
	$urlMatcherFactoryProvider.strictMode(false);
	
	// use the HTML5 History API
    $locationProvider.html5Mode(true);
    
});
