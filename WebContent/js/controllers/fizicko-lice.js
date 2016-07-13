'use strict';

angular.module('fizicko-lice',['resource.fizickoLice'])

.controller('fizicko-liceCtrl', function(FizickoLice,$scope, $rootScope, $routeParams, $log, $location, $q, $http){



	if($routeParams.fizickoLiceId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var fizickoLiceId = $routeParams.fizickoLiceId;

		if($rootScope.savedObject){

			$scope.fizickoLice = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			FizickoLice.get({'fizickoLiceId':fizickoLiceId}).$promise.then(function (data) {
				$scope.fizickoLice = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.fizickoLice = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.fizickoLice = new FizickoLice();
		}


	}


	$scope.save = function () {
		if($scope.fizickoLice.klijentId){
			//zbog cega redirekcija ide na callback?
			$scope.fizickoLice.$update({fizickoLiceId:$scope.fizickoLice.klijentId},function () {
				$location.path('/fizickoLice-list');
			});
		}
		else{
			$scope.fizickoLice.$save(function () {

				$location.path('/fizickoLice-list');
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