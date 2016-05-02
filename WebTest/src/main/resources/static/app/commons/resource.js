'use strict';

angular.module('ngApp')
.factory('WlOrganize', function($resource) {
	return $resource('/resource/WlOrganize/:organizeId');
});