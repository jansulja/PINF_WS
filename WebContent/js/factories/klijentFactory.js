angular.module('resource.klijent', ['ngResource'])
	.factory('Klijent', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/klijent/:klijentId',null, {
        'update': { method:'PUT' }
    });
})