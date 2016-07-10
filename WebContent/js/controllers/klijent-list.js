'use strict';

angular.module('klijent-list',['resource.klijent'])

.controller('klijent-listCtrl', function ($scope,$location, Klijent){

	$scope.klijenti = Klijent.query();




	$scope.new = function(){

		$location.path('klijent/new');

	}

	$scope.edit = function(klijent){

		$location.path('klijent/' + klijent.klijentId);

	}


	$scope.remove = function(klijent){

		klijent.$remove({klijentId:klijent.klijentId}, function(){

			var idx;
			var klijenti = $scope.klijenti;
			// Update scope
			for(var i = 0; i< klijenti.length;i++){

				if(klijenti[i].klijentId == klijent.klijentId){
					idx = i;
				}

			}
			$scope.klijenti.splice(idx, 1);
		});


	}



	console.log($scope.klijenti);

});