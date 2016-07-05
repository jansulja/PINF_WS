angular.module('resource.banka', ['ngResource'])
	.factory('Banka', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/banka/:bankaId',null, {
        'update': { method:'PUT' }
    });
})