package br.com.cliente.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.cliente.domain.Cliente;
import br.com.cliente.exception.CamposObrigatoriosException;
import br.com.cliente.repository.ClienteRepository;

@Stateless
public class ClienteService {

	@Inject
	private ClienteRepository repository;

	public List<Cliente> listar() {
		return repository.listAll();
	}

	public void salvar(Cliente cliente) throws CamposObrigatoriosException {

		boolean nomeValido = cliente.getNome() != null && !"".equals(cliente.getNome());
		boolean emailValido = cliente.getEmail() != null && !"".equals(cliente.getEmail());

		if (!nomeValido || !emailValido) {
			throw new CamposObrigatoriosException("Existem campos obrigatórios");
		}

		if (cliente.getId() != null) {
			repository.update(cliente);
		} else {
			cliente.setAtivo(true);
			cliente.setDataCadastro(new Date());
			repository.insert(cliente);
		}
	}

	public Cliente excluir(Integer id) {
		Cliente cliente = repository.findById(id);
		return repository.delete(cliente);
	}

}