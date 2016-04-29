'use strict';

angular.module('ngApp')
.factory('WlOrganize', function($resource) {
	return $resource('/api/walle/table/WlOrganize/:organizeId', {organizeId: '@organizeId'});
});