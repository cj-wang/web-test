angular.module('commons', [])
//truncate table cells with ellipsis
//ref: http://stackoverflow.com/questions/5239758/css-truncate-table-cells-but-fit-as-much-as-possible
.directive('ngCommonsEllipsable', function() {
	return {
		restrict : 'C',
		transclude: true,
		template :
			'<div style="position:relative">' +
			'	<div ng-transclude style="position:absolute; max-width:100%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;"></div>' +
			'	<div ng-transclude style="display:inline-block; height:0; overflow:hidden;"></div>' +
			'</div>'
	};
});
