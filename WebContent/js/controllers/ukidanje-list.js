'use strict';

angular.module('ukidanje-list',['resource.ukidanje'])

.controller('ukidanje-listCtrl', function ($scope,$location, Ukidanje){

	$scope.ukidanja = Ukidanje.query();


	$scope.new = function(){

		$location.path('ukidanje/new');

	}

	$scope.edit = function(ukidanje){

		$location.path('ukidanje/' + ukidanje.ukidanjeId);

	}


	$scope.remove = function(ukidanje){

		ukidanje.$remove({ukidanjeId:ukidanje.ukidanjeId}, function(){

			var idx;
			var ukidanja = $scope.ukidanja;
			//Update scope
			for(var i = 0; i< ukidanja.length;i++){

				if(ukidanja[i].ukidanjeId == ukidanje.ukidanjeId){
					idx = i;
				}

			}
			$scope.ukidanja.splice(idx, 1);

		});


	}





});