'use strict';

angular.module('dnevno-stanje-racuna',['resource.dnevnoStanjeRacuna'])

.controller('dnevno-stanje-racunaCtrl', function(DnevnoStanjeRacuna,$scope, $rootScope, $routeParams, $log, $location, $q, $http){



	if($routeParams.dnevnoStanjeRacunaId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var dnevnoStanjeRacunaId = $routeParams.dnevnoStanjeRacunaId;

		if($rootScope.savedObject){

			$scope.dnevnoStanjeRacuna = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			DnevnoStanjeRacuna.get({'dnevnoStanjeRacunaId':dnevnoStanjeRacunaId}).$promise.then(function (data) {
				$scope.dnevnoStanjeRacuna = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.dnevnoStanjeRacuna = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.dnevnoStanjeRacuna = new DnevnoStanjeRacuna();
		}


	}


	$scope.save = function () {
		if($scope.dnevnoStanjeRacuna.dnevnoStanjeRacunaId){
			//zbog cega redirekcija ide na callback?
			$scope.dnevnoStanjeRacuna.$update({dnevnoStanjeRacunaId:$scope.dnevnoStanjeRacuna.dnevnoStanjeRacunaId},function () {
				$location.path('/dnevnoStanjeRacuna-list');
			});
		}
		else{
			$scope.dnevnoStanjeRacuna.$save(function () {

				$location.path('/dnevnoStanjeRacuna-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}


	//funkcija koja otvara datepicker
	$scope.openDatepicker = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope[opened] = true;
	};

});