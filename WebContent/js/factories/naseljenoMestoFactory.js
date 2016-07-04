angular.module('resource.naseljenoMesto', ['ngResource'])
	.factory('NaseljenoMesto', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/naseljenomesto/:naseljenoMestoId',null, {
        'update': { method:'PUT' }
    });
})