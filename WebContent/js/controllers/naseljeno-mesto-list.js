'use strict';

angular.module('naseljeno-mesto-list',['resource.naseljenoMesto'])

.controller('naseljeno-mesto-listCtrl', function ($scope,$location, NaseljenoMesto){

	$scope.naseljenaMesta = NaseljenoMesto.query();



	$scope.new = function(){

		$location.path('naseljenoMesto/new');

	}

	$scope.edit = function(naseljenoMesto){

		$location.path('naseljenoMesto/' + naseljenoMesto.naseljenoMestoId);

	}


	$scope.remove = function(naseljenoMesto){

		naseljenoMesto.$remove({naseljenoMestoId:naseljenoMesto.naseljenoMestoId}, function(){

			var idx;
			var naseljenaMesta = $scope.naseljenaMesta;
			// Update scope
			for(var i = 0; i< naseljenaMesta.length;i++){

				if(naseljenaMesta[i].naseljenoMestoId == naseljenoMesto.naseljenoMestoId){
					idx = i;
				}

			}
			$scope.naseljenaMesta.splice(idx, 1);

		});


	}

	$scope.fillDrzave = function(){

		var idx;

		for(var i = 0; i< $scope.naseljenaMesta.length;i++){

			$scope.naseljenaMesta[i].drzava = $scope.getDrzava($scope.naseljenaMesta[i].naseljenoMestoId);


		}

	}

	$scope.getDrzava = function(nmId){

		var deferred = $q.defer();
		// user.password = md5.createHash(user.password);
	$http({
		url: "http://localhost:8089/PINF_WSProjekat/api/naseljenomesto/drzava/" + nmId,
		method: "GET",
	}).then(function successCallback(data) {
		deferred.resolve(data.data);
	}, function errorCallback(response) {

		}
		);

	var promise = deferred.promise;


	promise.then(function (data) {
		return data;
	});

	}

	//$scope.fillDrzave();
	console.log($scope.naseljenaMesta);

});