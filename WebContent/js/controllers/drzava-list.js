'use strict';

angular.module('drzava-list',['resource.drzava'])

.controller('drzava-listCtrl', function ($scope, Drzava){

	$scope.drzave = Drzava.query();

});