'use strict';

angular.module('angularWalle')
.factory('walleCommonQuery', function($http) {
	return {
		query : function(queryInfo) {
			return $http.post('/api/walle/commonQuery', queryInfo);
		}
	};
});
