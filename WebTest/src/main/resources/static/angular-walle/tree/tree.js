'use strict';

//wl-tree
//Thanks to wix/angular-tree-control
//https://github.com/wix/angular-tree-control
angular.module('angularWalle')
.directive('wlTree', function($compile, $parse) {
	return {
		restrict : 'A',
		terminal : true,
		priority : 1000,
		controller : function($scope, $element, $attrs) {
			var tree = {
					options : {
						allowDeselect : false,
						multiSelection : angular.isDefined($attrs.multiSelection),
						injectClasses : {
							liSelected : 'tree-node-selected'
						}
					},
					nodesMap : {},
					nodes : [],
					expandedNodes : [],
					orderByField : $attrs.orderByField
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
						node.parent = undefined;
					} else {
						var node = angular.copy(item);
						node.data = item;
						node.children = [];
						node.parent = undefined;
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
						node.parent = tree.nodesMap[node.data[$attrs.parentField]];
					} else {
						tree.nodes.push(node);
					}
				});
				//expand the 1st node
				if (tree.expandedNodes.length == 0 && tree.nodes.length > 0) {
					tree.expandedNodes.push(tree.nodes[0]);
				}
			}, true);
			//watch selected node to change selected data
			$scope.$watch($attrs.ngModel + 'Tree.selectedNode', function(selectedNode) {
				tree.selectedData = selectedNode ? selectedNode.data : undefined;
				//expand all parent nodes
				var node = selectedNode;
				while(node && node.parent) {
					if (tree.expandedNodes.indexOf(node.parent) == -1) {
						tree.expandedNodes.push(node.parent);
					}
					node = node.parent;
				}
			});
			//watch selected data to change selected key
			$scope.$watch($attrs.ngModel + 'Tree.selectedData', function(selectedData) {
				tree.selectedKey = selectedData ? selectedData[$attrs.keyField] : undefined;
			});
			//watch selected key to change selected node
			$scope.$watch($attrs.ngModel + 'Tree.selectedKey', function(selectedKey) {
				tree.selectedNode = selectedKey ? tree.nodesMap[selectedKey] : undefined;
			});
		},
		link : function(scope, element, attrs) {
			element.removeAttr('wl-tree');
			element.attr('treecontrol', '');
			element.attr('class', attrs.class || 'tree-classic');

			element.attr('options', attrs.options || attrs.ngModel + 'Tree.options');
			element.attr('tree-model', attrs.treeModel || attrs.ngModel + 'Tree.nodes');
			element.attr('selected-node', attrs.selectedNode || attrs.ngModel + 'Tree.selectedNode');
			element.attr('selected-nodes', attrs.selectedNodes || attrs.ngModel + 'Tree.selectedNodes');
			element.attr('expanded-nodes', attrs.expandedNodes || attrs.ngModel + 'Tree.expandedNodes');
			element.attr('order-by', attrs.orderBy || attrs.ngModel + 'Tree.orderByField');
			element.attr('reverse-order', attrs.reverseOrder || 'false');
			
			//compile
			$compile(element)(scope);
		}
	};
});
