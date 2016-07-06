angular.module('resource.pravnoLice', ['ngResource'])
	.factory('PravnoLice', function ($resource) {

	return $resource('http://localhost:8089/PINF_WSProjekat/api/pravnolice/:pravnoLiceId',null, {
        'update': { method:'PUT' }
    });
})