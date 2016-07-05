'use strict';

angular.module('vrste-placanja',['resource.vrstePlacanja'])

.controller('vrste-placanjaCtrl', function(VrstePlacanja,$scope, $rootScope, $routeParams, $log, $location, $q, $http){



	if($routeParams.vrstaPlacanjaId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var vrstaPlacanjaId = $routeParams.vrstaPlacanjaId;

		if($rootScope.savedObject){

			$scope.vrstePlacanja = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			VrstePlacanja.get({'vrstaPlacanjaId':vrstaPlacanjaId}).$promise.then(function (data) {
				$scope.vrstePlacanja = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.vrstePlacanja = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.vrstePlacanja = new VrstePlacanja();
		}


	}


	$scope.save = function () {
		if($scope.vrstePlacanja.vrstaPlacanjaId){
			//zbog cega redirekcija ide na callback?
			$scope.vrstePlacanja.$update({vrstaPlacanjaId:$scope.vrstePlacanja.vrstaPlacanjaId},function () {
				$location.path('/vrstePlacanja-list');
			});
		}
		else{
			$scope.vrstePlacanja.$save(function () {

				$location.path('/vrstePlacanja-list');
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