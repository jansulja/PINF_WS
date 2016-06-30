angular.module('resource.drzava', ['ngResource'])
	.factory('Drzava', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/drzava/:drzavaId',null, {
        'update': { method:'PUT' }
    });
})