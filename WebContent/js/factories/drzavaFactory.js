angular.module('resource.drzava', ['ngResource'])
	.factory('Drzava', function ($resource,$log) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/drzava/:drzavaId',null, {
        'update': { method:'PUT' }
    });
})