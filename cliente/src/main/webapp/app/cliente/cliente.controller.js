(function() {

	function ClienteController(ClienteService) {

		var vm = this;

		init();

		function init() {
			vm.salvar = salvar;
			vm.editar = editar;
			vm.excluir = excluir;

			listar();

		}

		function listar() {
			ClienteService.listar().then(function(response) {
				vm.manter = response.data;
			});
		}

		function salvar() {
			ClienteService.salvar(vm.manter.cliente).then(function(response) {
				M.toast({
					html : response.data.nome + ' salvo com sucesso!'
				})
				listar();
			});
		}

		function editar(cliente) {
			vm.manter.cliente = angular.copy(cliente);
		}

		function excluir(id) {
			ClienteService.excluir(id).then(function(response) {
				M.toast({
					html : response.data.nome + ' excluido com sucesso!'
				})
				listar();
			});
		}
	}

	ClienteController.$inject = [ 'ClienteService' ];

	angular.module('app.controllers').controller('ClienteController',
			ClienteController);

})();
