angular.module('resource.valuta', ['ngResource'])
	.factory('Valuta', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/valuta/:valutaId',null, {
        'update': { method:'PUT' }
    });
})