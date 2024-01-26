import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.domain.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {
    private IClienteDAO iClienteDAO;

    @Test
    public void cadastrarTest() throws Exception {
        iClienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Pessoa 1");
        Integer countCad = iClienteDAO.cadastrar(cliente);
        assertEquals(1, (int) countCad);

        Cliente clienteBD = iClienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = iClienteDAO.excluir(clienteBD);
        assertEquals(1, (int) countDel);
    }

    @Test
    public void buscarTest() throws Exception {
        iClienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Pessoa 1");
        Integer countCad = iClienteDAO.cadastrar(cliente);
        assertEquals(1, (int) countCad);

        Cliente clienteBD = iClienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = iClienteDAO.excluir(clienteBD);
        assertEquals(1, (int) countDel);
    }

    @Test
    public void excluirTest() throws Exception {
        iClienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Pessoa 1");
        Integer countCad = iClienteDAO.cadastrar(cliente);
        assertEquals(1, (int) countCad);

        Cliente clienteBD = iClienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = iClienteDAO.excluir(clienteBD);
        assertEquals(1, (int) countDel);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        iClienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Pessoa 1");
        Integer countCad = iClienteDAO.cadastrar(cliente);
        assertEquals(1, (int) countCad);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("20");
        cliente2.setNome("Pessoa 2");
        Integer countCad2 = iClienteDAO.cadastrar(cliente2);
        assertEquals(1, (int) countCad2);

        List<Cliente> list = iClienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Cliente cli : list) {
            iClienteDAO.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = iClienteDAO.buscarTodos();
        assertEquals(0, list.size());
    }

    @Test
    public void atualizarTest() throws Exception {
        iClienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Pessoa 1");
        Integer countCad = iClienteDAO.cadastrar(cliente);
        assertEquals(1, (int) countCad);

        Cliente clienteBD = iClienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("Outro nome");
        Integer countUpdate = iClienteDAO.atualizar(clienteBD);
        assertEquals(1, (int) countUpdate);

        Cliente clienteBD1 = iClienteDAO.buscar("10");
        assertNull(clienteBD1);

        Cliente clienteBD2 = iClienteDAO.buscar("20");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = iClienteDAO.buscarTodos();
        for (Cliente cli : list) {
            iClienteDAO.excluir(cli);
        }
    }
}
