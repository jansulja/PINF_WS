angular.module('resource.ukidanje', ['ngResource'])
	.factory('Ukidanje', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/ukidanje/:ukidanjeId',null, {
        'update': { method:'PUT' }
    });
})