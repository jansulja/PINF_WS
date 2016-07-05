angular.module('resource.vrstePlacanja', ['ngResource'])
	.factory('VrstePlacanja', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/vrsteplacanja/:vrstaPlacanjaId',null, {
        'update': { method:'PUT' }
    });
})