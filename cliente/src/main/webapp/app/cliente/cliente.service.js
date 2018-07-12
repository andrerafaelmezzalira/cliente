(function() {

	function ClienteService($http) {

		var url = 'resources/cliente';

		return ({
			listar : listar,
			salvar : salvar,
			excluir : excluir
		});

		function listar() {
			return $http.get(url);
		}

		function salvar(cliente) {
			return $http[!cliente.id ? 'post' : 'put'](url, cliente);
		}

		function excluir(id) {
			return $http['delete'](url, {
				params : {
					id : id
				}
			});
		}
	}

	ClienteService.$inject = [ '$http' ];

	angular.module('app.services').service('ClienteService', ClienteService);
})();
