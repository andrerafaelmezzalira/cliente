package br.com.cliente.repository;

import br.com.cliente.arq.AbstractRepository;
import br.com.cliente.domain.Cliente;

public class ClienteRepository extends AbstractRepository<Cliente> {

	public ClienteRepository() {
		super(Cliente.class);
	}

}