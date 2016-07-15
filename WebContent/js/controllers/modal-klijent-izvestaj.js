'use strict';

angular.module('modal-klijent-izvestaj',[])

.controller('modal-klijent-izvestajCtrl', function ($scope, $modalInstance ,$q,$http,$rootScope,klijentId) {

	console.log(klijentId);

	$scope.datum = { 'klijentId' : klijentId };

	$scope.cancel = function () {
		$modalInstance.close();
	};

	$scope.ok = function () {

		var deferred = $q.defer();
		//user.password = md5.createHash(user.password);
			$http({
				url: "http://localhost:8089/PINF_WSProjekat/api/klijent/izvestaj",
				method: "POST",
				data: $scope.datum
			}).success(function (data) {
				deferred.resolve(data);
			});

			var promise = deferred.promise;


			promise.then(function (data) {

				alert('Uspesno generisan izvestaj');

			});

			$modalInstance.close();

	};



});
