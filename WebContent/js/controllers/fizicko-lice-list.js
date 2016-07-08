'use strict';

angular.module('fizicko-lice-list',['resource.fizickoLice'])

.controller('fizicko-lice-listCtrl', function ($scope,$location, FizickoLice){

	$scope.fizickaLica = FizickoLice.query();




	$scope.new = function(){

		$location.path('fizickoLice/new');

	}

	$scope.edit = function(fizickoLice){

		$location.path('fizickoLice/' + fizickoLice.klijentId);

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



	console.log($scope.fizickaLica);

});