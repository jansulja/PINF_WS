'use strict';

angular.module('banka-list',['resource.banka'])

.controller('banka-listCtrl', function ($scope,$location, Banka){

	$scope.banke = Banka.query();


	$scope.new = function(){

		$location.path('banka/new');

	}

	$scope.edit = function(banka){

		$location.path('banka/' + banka.bankaId);

	}


	$scope.remove = function(banka){

		banka.$remove({bankaId:banka.bankaId}, function(){

			var idx;
			var banke = $scope.banke;
			//Update scope
			for(var i = 0; i< banke.length;i++){

				if(banke[i].bankaId == banka.bankaId){
					idx = i;
				}

			}
			$scope.banke.splice(idx, 1);

		});


	}

	console.log($scope.banke);



});