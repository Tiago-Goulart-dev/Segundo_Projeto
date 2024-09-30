package br.com.tgoulart.services;

import br.com.tgoulart.dao.IClienteDAO;
import br.com.tgoulart.domain.Cliente;
import br.com.tgoulart.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}
	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}
}
