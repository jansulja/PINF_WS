'use strict';

angular.module('nalog',['resource.racuni'])

.controller('nalogCtrl', function(Racuni,$scope, $rootScope, $routeParams, $log, $location, $q, $http,$timeout,$modal){

	$scope.fbTimeout = 3000;

	var racuniId = $routeParams.racuniId;
	Racuni.get({'racuniId':racuniId}).$promise.then(function (data) {

		var duznik;
		if(data.klijent.naziv){
			duznik = data.klijent.naziv;
		}else{
			duznik = data.klijent.punoIme;
		}

		$scope.nalog = { "duznik" : duznik , "oznakaValute" : data.valuta.zvanicnaSifra , "racunDuznika":data.brojRacuna, "mestoPrijema": "Novi Sad"

		};



	});


	$scope.uplata = function(){

		console.log($scope.nalog);
		var deferred = $q.defer();
		//user.password = md5.createHash(user.password);
		$http({
			url: "http://localhost:8089/PINF_WSProjekat/api/nalog",
			method: "POST",
			data: $scope.nalog
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {
			$scope.showError('Greska!');
		});

		var promise = deferred.promise;
		promise.then(function (data) {
			$scope.showSuccess('Transakcija uspesna.');
		});

	}

	$scope.importNalog = function(){

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
			$scope.nalog = data;
		});


	}

	$scope.showError = function(errorMessage){

		$scope.errorMessage = errorMessage;
		$timeout($scope.hideError, $scope.fbTimeout);

	}


	$scope.hideError = function(){
		$scope.errorMessage = null;
	}


	$scope.showSuccess = function(successMessage){

		$scope.successMessage = successMessage;
		$timeout($scope.hideSuccess,  $scope.fbTimeout);

	}


	$scope.hideSuccess = function(){
		$scope.successMessage = null;
	}

}).directive("fileread", [function () {
    return {
        scope: {
            fileread: "="
        },
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.fileread = changeEvent.currentTarget.value;
                    });
                }
                reader.readAsDataURL(changeEvent.target.files[0]);
            });
        }
    }
}]);