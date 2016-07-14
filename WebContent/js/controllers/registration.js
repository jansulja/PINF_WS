'use strict';

angular.module('registration',[])

.controller ('RegistrationController',function($scope, $rootScope, $routeParams, $log, $location, $q, $http){

	$scope.zaposleni = { 'email' : '' , 'password':''};
	$rootScope.current = {};
	//Login funkcija
	$scope.login = function(){

		var deferred = $q.defer();

		$http({
			//Ovo mozda treba da se menja u zavisnosti od path-a
			url: "http://localhost:8089/PINF_WSProjekat/api/zaposleni/login",
			method: "POST",
			data: $scope.zaposleni
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {
			$scope.pogresan = true;
			}
			);

		var promise = deferred.promise;


		promise.then(function (data) {
			console.log(data);
			$rootScope.current.ime = data.ime;
			$rootScope.current.prezime = data.prezime;
			$rootScope.current.email = data.email;
			$rootScope.current.banka = data.banka.naziv;
			$location.path('/racuni-list');

		});

	};





	$scope.register = function(){
		var deferred = $q.defer();

		$http({
			//Ovo mozda treba da se menja u zavisnosti od path-a
			url: "https://localhost:8089/PINF_WSProjekat/api/klijent/register/fizicko",
			method: "POST",
			data: $scope.user
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {
			$scope.pogresan = true;
			}
			);

		var promise = deferred.promise;


		promise.then(function (data) {


		});
	};


	$scope.openDatepicker1 = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope[opened] = true;
	};

	$scope.registerpravno = function(){
				var deferred = $q.defer();

		$http({
			//Ovo mozda treba da se menja u zavisnosti od path-a
			url: "https://localhost:8089/PINF_WSProjekat/api/klijent/register/pravno",
			method: "POST",
			data: $scope.user
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {
			$scope.pogresan = true;
			}
			);

		var promise = deferred.promise;


		promise.then(function (data) {


		});
	};
});