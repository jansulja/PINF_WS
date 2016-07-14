'use strict';

angular.module('analitika-izvoda-list',['resource.analitikaIzvoda','ui.bootstrap'])

.controller('analitika-izvoda-listCtrl', function ($scope,$location, AnalitikaIzvoda,$q,$http){

	$scope.analitikeIzvoda = AnalitikaIzvoda.query();





	$scope.new = function(){

		$location.path('analitikaIzvoda/new');

	}

	$scope.edit = function(analitikaIzvoda){

		$location.path('analitikaIzvoda/' + analitikaIzvoda.analitikaIzvodaId);

	}


	$scope.remove = function(analitikaIzvoda){

		analitikaIzvoda.$remove({analitikaIzvodaId:analitikaIzvoda.analitikaIzvodaId}, function(){

			var idx;
			var analitikeIzvoda = $scope.analitikeIzvoda;
			// Update scope
			for(var i = 0; i< analitikeIzvoda.length;i++){

				if(analitikeIzvoda[i].analitikaIzvodaId == analitikaIzvoda.analitikaIzvodaId){
					idx = i;
				}

			}
			$scope.analitikeIzvoda.splice(idx, 1);

		});


	}


	$scope.importNalog = function(){

		alert($scope.fileName.split("fakepath\\"));

		var file = $scope.fileName.split("fakepath\\")[1];

		var deferred = $q.defer();
		//user.password = md5.createHash(user.password);
		$http({
			url: "http://localhost:8089/PINF_WSProjekat/api/nalog/" + file,
			method: "GET"
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {

		});

		var promise = deferred.promise;
		promise.then(function (data) {

		});


	}

	console.log($scope.analitikeIzvoda);

});