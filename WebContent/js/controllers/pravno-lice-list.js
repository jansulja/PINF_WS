'use strict';

angular.module('pravno-lice-list',['resource.pravnoLice'])

.controller('pravno-lice-listCtrl', function ($scope,$location, PravnoLice){

	$scope.pravnaLica = PravnoLice.query();




	$scope.new = function(){

		$location.path('pravnoLice/new');

	}

	$scope.edit = function(pravnoLice){

		$location.path('pravnoLice/' + pravnoLice.klijentId);

	}


	$scope.remove = function(pravnoLice){

		pravnoLice.$remove({pravnoLiceId:pravnoLice.klijentId}, function(){

			var idx;
			var pravnaLica = $scope.pravnaLica;
			// Update scope
			for(var i = 0; i< pravnaLica.length;i++){

				if(pravnaLica[i].klijentId == pravnoLice.klijentId){
					idx = i;
				}

			}
			$scope.pravnaLica.splice(idx, 1);

		});


	}



	console.log($scope.pravnaLica);

});