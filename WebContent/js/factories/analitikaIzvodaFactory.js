angular.module('resource.analitikaIzvoda', ['ngResource'])
	.factory('AnalitikaIzvoda', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/analitikaizvoda/:analitikaIzvodaId',null, {
        'update': { method:'PUT' }
    });
})