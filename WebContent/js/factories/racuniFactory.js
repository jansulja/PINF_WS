angular.module('resource.racuni', ['ngResource'])
	.factory('Racuni', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/racuni/:racuniId',null, {
        'update': { method:'PUT' }
    });
})