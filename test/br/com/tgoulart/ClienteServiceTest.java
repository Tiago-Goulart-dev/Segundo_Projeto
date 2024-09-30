package br.com.tgoulart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.tgoulart.dao.ClienteDaoMock;
import br.com.tgoulart.dao.IClienteDAO;
import br.com.tgoulart.domain.Cliente;
import br.com.tgoulart.exceptions.TipoChaveNaoEncontradaException;
import br.com.tgoulart.services.ClienteService;
import br.com.tgoulart.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Tiago");
		cliente.setCidade("Goiânia");
		cliente.setEnd("End");
		cliente.setEstado("GO");
		cliente.setNumero(10);
		cliente.setTel(6299999999L);
		
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Tiago Goulart");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Tiago Goulart", cliente.getNome());
	}
}
