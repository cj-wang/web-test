'use strict';

//walle-tree
angular.module('angularWalle')
.directive('walleTree', function($compile, $parse) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : function($scope, $element, $attrs) {
			var tree = {
					options : {
						allowDeselect : false,
						multiSelection : angular.isDefined($attrs.multiSelection)
					},
					nodesMap : {},
					nodes : [],
					expandedNodes : [],
					orderBy : $attrs.orderBy
			}
			$parse($attrs.ngModel + 'Tree').assign($scope, tree);
			//watch model data changes
			$scope.$watch($attrs.ngModel, function(data) {
				angular.forEach(data, function(item) {
					if (tree.nodesMap[item[$attrs.keyField]]) {
						var node = tree.nodesMap[item[$attrs.keyField]];
						angular.copy(item, node);
						node.data = item;
						node.children = [];
					} else {
						var node = angular.copy(item);
						node.data = item;
						node.children = [];
						tree.nodesMap[item[$attrs.keyField]] = node;
					};
				});
				angular.forEach(tree.nodesMap, function(node, key) {
					if (data.indexOf(node.data) == -1) {
						delete tree.nodesMap[key];
						if (key == tree.selectedKey) {
							tree.selectedKey = node.data[$attrs.parentField];
						}
					}
				});
				tree.nodes.length = 0;
				angular.forEach(tree.nodesMap, function(node) {
					if (tree.nodesMap[node.data[$attrs.parentField]]) {
						tree.nodesMap[node.data[$attrs.parentField]].children.push(node);
					} else {
						tree.nodes.push(node);
					}
				});
				//expand the 1st node
				if (tree.expandedNodes.length == 0 && tree.nodes.length > 0) {
					tree.expandedNodes.push(tree.nodes[0]);
				}
			}, true);
			//watch selected node
			$scope.$watch($attrs.ngModel + 'Tree.selectedNode', function(selectedNode) {
				if (selectedNode) {
					tree.selectedData = selectedNode.data;
					tree.selectedKey = selectedNode.data[$attrs.keyField];
				} else {
					tree.selectedData = undefined;
					tree.selectedKey = undefined;
				}
			});
			//watch selected data
			$scope.$watch($attrs.ngModel + 'Tree.selectedData', function(selectedData) {
				if (selectedData) {
					tree.selectedNode = tree.nodesMap[selectedData[$attrs.keyField]];
				} else {
					tree.selectedNode = undefined;
				}
			});
			//watch selected key
			$scope.$watch($attrs.ngModel + 'Tree.selectedKey', function(selectedKey) {
				if (selectedKey) {
					tree.selectedNode = tree.nodesMap[selectedKey];
				} else {
					tree.selectedNode = undefined;
				}
			});
		},
		link : function(scope, element, attrs) {
			element.removeAttr('walle-tree');
			element.attr('treecontrol', '');
			element.attr('class', attrs.class || 'tree-classic');

			element.attr('options', attrs.treeModel || attrs.ngModel + 'Tree.options');
			element.attr('tree-model', attrs.treeModel || attrs.ngModel + 'Tree.nodes');
			element.attr('selected-node', attrs.selectedNode || attrs.ngModel + 'Tree.selectedNode');
			element.attr('selected-nodes', attrs.selectedNodes || attrs.ngModel + 'Tree.selectedNodes');
			element.attr('expanded-nodes', attrs.expandedNodes || attrs.ngModel + 'Tree.expandedNodes');
			element.attr('order-by', attrs.ngModel + 'Tree.orderBy');
			element.attr('reverse-order', attrs.reverseOrder || 'false');
			
			//compile
			$compile(element)(scope);
		}
	};
});
