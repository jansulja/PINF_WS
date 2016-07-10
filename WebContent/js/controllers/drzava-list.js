'use strict';

angular.module('drzava-list',['resource.drzava'])

.controller('drzava-listCtrl', function ($scope,$location, Drzava, $rootScope){

	$scope.drzave = Drzava.query();
	//$scope.drzave = [{'nazivDrzave':'drzava 1'},{'nazivDrzave':'drzava 2'},{'nazivDrzave':'drzava 3'},{'nazivDrzave':'drzava 4'}];
	console.log($scope.drzave);
	$scope.new = function(){

		$location.path('drzava-new/new');

	}

	$scope.edit = function(drzava){

		$location.path('drzava-new/' + drzava.drzavaId);

	}


	$scope.remove = function(drzava){

		drzava.$remove({drzavaId:drzava.drzavaId}, function(){

			var idx;
			var drzave = $scope.drzave;
			//Update scope
			for(var i = 0; i< drzave.length;i++){

				if(drzave[i].drzavaId == drzava.drzavaId){
					idx = i;
				}

			}
			$scope.drzave.splice(idx, 1);

		});


	}

//	$scope.zoom = function(){
//
//		var zoom = false;
//
//		if($rootScope.zoom){
//			zoom = true;
//		}
//
//		return zoom;
//
//	}



//	$scope.drzavaPickUp = function(drzava){
//
//		$rootScope.valutaSaved.drzava = drzava;
//		$location.path('/valuta/new');
//
//	}




});