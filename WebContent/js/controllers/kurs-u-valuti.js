'use strict';

angular.module('kurs-u-valuti',['resource.kursUValuti'])

.controller('kurs-u-valutiCtrl', function(KursUValuti,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.kursUValutiId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var kursUValutiId = $routeParams.kursUValutiId;

		if($rootScope.savedObject){

			$scope.kursUValuti = $rootScope.savedObject
			$rootScope.savedObject = undefined;
		}else{
			KursUValuti.get({'kursUValutiId':kursUValutiId}).$promise.then(function (data) {
				$scope.kursUValuti = data;
			});
		}


	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"

		if($rootScope.savedObject){

			$scope.kursUValuti = $rootScope.savedObject;
			$rootScope.savedObject = undefined;
		}else{
			$scope.kursUValuti = new KursUValuti();
		}


	}


	$scope.save = function () {
		if($scope.kursUValuti.kursUValutiId){
			//zbog cega redirekcija ide na callback?
			$scope.kursUValuti.$update({kursUValutiId:$scope.kursUValuti.kursUValutiId},function () {
				$location.path('/kursUValuti-list');
			});
		}
		else{
			$scope.kursUValuti.$save(function () {

				$location.path('/kursUValuti-list');
			},function (error){
				console.log(error);
				$scope.errorMessage = error.data.message;
			});
		}

	}

	console.log($scope.kursUValuti);


});