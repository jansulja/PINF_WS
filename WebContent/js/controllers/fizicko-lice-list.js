'use strict';

angular.module('fizicko-lice-list',['resource.fizickoLice'])

.controller('fizicko-lice-listCtrl', function ($scope,$location, FizickoLice,$q,$http,$timeout,$modal){

	$scope.fizickaLica = FizickoLice.query();

	$scope.fbTimeout = 3000;



	$scope.new = function(){

		$location.path('fizickoLice/new');

	}

	$scope.edit = function(fizickoLice){

		$location.path('fizickoLice/' + fizickoLice.klijentId);

	}


	$scope.exportIzvod = function(fizickoLice){

		var deferred = $q.defer();
		//user.password = md5.createHash(user.password);
		$http({
			url: "http://localhost:8089/PINF_WSProjekat/api/izvod/" + fizickoLice.klijentId,
			method: "GET"
		}).then(function successCallback(data) {
			deferred.resolve(data.data);
		}, function errorCallback(response) {

			$scope.showError(response.data.errorMessage);



		});

		var promise = deferred.promise;
		promise.then(function (data) {

			$scope.showSuccess('Uspesno exportovanje izvoda.');

		});
	}

	$scope.generateReport = function(fizickoLice,size){


		 var modalInstance = $modal.open({
		      templateUrl: 'views/modal-klijent-izvestaj.html',
		      controller: 'modal-klijent-izvestajCtrl',
		      size: size,
		      resolve: {
			         klijentId : function () {
			           return fizickoLice.klijentId;
			         }
			       }
		    });


	}


	$scope.remove = function(fizickoLice){

		fizickoLice.$remove({fizickoLiceId:fizickoLice.klijentId}, function(){

			var idx;
			var fizickaLica = $scope.fizickaLica;
			// Update scope
			for(var i = 0; i< fizickaLica.length;i++){

				if(fizickaLica[i].klijentId == fizickoLice.klijentId){
					idx = i;
				}

			}
			$scope.fizickaLica.splice(idx, 1);

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


	console.log($scope.fizickaLica);

});