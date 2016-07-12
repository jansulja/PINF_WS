'use strict';

angular.module('racuni-list',['resource.racuni'])

.controller('racuni-listCtrl', function ($scope,$location, Racuni){

	$scope.racunii = Racuni.query();


	$scope.new = function(){

		$location.path('racuni/new');

	}

	$scope.edit = function(racuni){

		$location.path('racuni/' + racuni.racuniId);

	}


	$scope.remove = function(racuni){

		racuni.$remove({racuniId:racuni.racuniId}, function(){

			var idx;
			var racunii = $scope.racunii;
			//Update scope
			for(var i = 0; i< racunii.length;i++){

				if(racunii[i].racuniId == racuni.racuniId){
					idx = i;
				}

			}
			$scope.racunii.splice(idx, 1);

		});


	}

	$scope.exportNalog = function(racuni){

		$location.path('nalog/' + racuni.racuniId);

	}



});