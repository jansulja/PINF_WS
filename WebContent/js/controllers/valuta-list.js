'use strict';

angular.module('valuta-list',['resource.valuta'])

.controller('valuta-listCtrl', function ($scope,$location, Valuta){

	$scope.valute = Valuta.query();


	$scope.new = function(){

		$location.path('valuta/new');

	}
//
//	$scope.edit = function(drzava){
//
//		$location.path('drzava-new/' + drzava.sifraDrzave);
//
//	}
//
//
//	$scope.remove = function(drzava){
//
//		drzava.$remove({drzavaId:drzava.sifraDrzave}, function(){
//
//			var idx;
//			var drzave = $scope.drzave;
//			//Update scope
//			for(var i = 0; i< drzave.length;i++){
//
//				if(drzave[i].sifraDrzave == drzava.sifraDrzave){
//					idx = i;
//				}
//
//			}
//			$scope.drzave.splice(idx, 1);
//
//		});
//
//
//	}





});