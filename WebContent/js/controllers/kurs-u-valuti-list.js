'use strict';

angular.module('kurs-u-valuti-list',['resource.kursUValuti'])

.controller('kurs-u-valuti-listCtrl', function ($scope,$location, KursUValuti){

	$scope.kurseviUValuti = KursUValuti.query();



	$scope.new = function(){

		$location.path('kursUValuti/new');

	}

	$scope.edit = function(kursUValuti){

		$location.path('kursUValuti/' + kursUValuti.kursUValutiId);

	}


	$scope.remove = function(kursUValuti){

		kursUValuti.$remove({kursUValutiId:kursUValuti.kursUValutiId}, function(){

			var idx;
			var kurseviUValuti = $scope.kurseviUValuti;
			// Update scope
			for(var i = 0; i< kurseviUValuti.length;i++){

				if(kurseviUValuti[i].kursUValutiId == kursUValuti.kursUValutiId){
					idx = i;
				}

			}
			$scope.kurseviUValuti.splice(idx, 1);

		});


	}


	console.log($scope.kurseviUValuti);

});