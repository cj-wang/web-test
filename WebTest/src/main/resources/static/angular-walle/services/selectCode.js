'use strict';

angular.module('angularWalle')
.factory('walleSelectCode', function($http) {
	return {
		get : function(codeType) {
			return $http.get('/api/walle/selectCode/' + codeType);
		},
		
		query : function(codeType, q, limit) {
			return $http.get('/api/walle/selectCode/' + codeType + '?q=' + q + '&limit=' + (limit || 10));
		}
	};
});
