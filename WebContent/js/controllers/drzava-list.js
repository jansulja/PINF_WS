'use strict';

angular.module('drzava-list',['resource.drzava'])

.controller('drzava-listCtrl', function ($scope,$location, Drzava){

	$scope.drzave = Drzava.query();


	$scope.new = function(){

		$location.path('drzava-new/new');

	}

	$scope.edit = function(drzava){

		$location.path('drzava-new/' + drzava.sifraDrzave);

	}


	$scope.remove = function(drzava){

		drzava.$remove({drzavaId:drzava.sifraDrzave}, function(){

			var idx;
			var drzave = $scope.drzave;
			//Update scope
			for(var i = 0; i< drzave.length;i++){

				if(drzave[i].sifraDrzave == drzava.sifraDrzave){
					idx = i;
				}

			}
			$scope.drzave.splice(idx, 1);

		});


	}





});