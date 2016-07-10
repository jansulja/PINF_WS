'use strict';

angular.module('drzava-new',['resource.drzava'])

.controller('drzava-newCtrl', function(Drzava,$scope, $rootScope, $routeParams, $log, $location, $q, $http){

	if($routeParams.drzavaId!='new'){

		$scope.title = "Izmena"
		$scope.buttonText = "Izmeni"
		//preuzimanje parametra iz URL
		var drzavaId = $routeParams.drzavaId;

		Drzava.get({'drzavaId':drzavaId}).$promise.then(function (data) {
			$scope.drzava = data;
		});
	}
	//ako kreiramo novu fakutru
	else{
		$scope.title = "Dodavanje"
		$scope.buttonText = "Dodaj"
		$scope.drzava = new Drzava();

	}


	$scope.save = function () {
		if($scope.drzava.drzavaId){
			//zbog cega redirekcija ide na callback?
			$scope.drzava.$update({drzavaId:$scope.drzava.drzavaId},function () {
				$location.path('/drzava-list');
			});
		}
		else{
			console.log($scope.drzava.toJSON());

			$scope.drzava.$save(function () {
				$location.path('/drzava-list');
			});
		}

	}

	console.log($scope.drzava);

});