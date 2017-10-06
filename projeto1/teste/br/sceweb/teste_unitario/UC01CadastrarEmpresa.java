package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	/*
	 * ID - CT01UC01FBCadastra_com_sucesso
	 * Objetivo  - verificar o comportamento do sistema na inclusao da empresa com sucesso
	 * pr�-condi��o - o cnpj setado nao estar cadastrado
	 * */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	/*
	 * ID - CT02UC02FBCadastra_cnpj_invalido
	 * Objetivo  - verificar o comportamento do sistema na invalidez do cnpj
	 * pr�-condi��o - 
	 * */
	@Test
	public void CT02UC02FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ invalido",empresa.setCnpj("89424"));
	}
	@Test
	public void CT03UC03FBCadastra_com_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}



