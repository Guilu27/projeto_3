import main.dao.IProdutoDAO;
import main.dao.ProdutoDAO;
import main.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {
    private IProdutoDAO iProdutoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        iProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto 1");
        Integer countCad = iProdutoDAO.cadastrar(produto);
        assertEquals(1, (int) countCad);

        Produto produtoBD = iProdutoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = iProdutoDAO.excluir(produtoBD);
        assertEquals(1, (int) countDel);
    }

    @Test
    public void buscarTest() throws Exception {
        iProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto 1");
        Integer countCad = iProdutoDAO.cadastrar(produto);
        assertEquals(1, (int) countCad);

        Produto produtoBD = iProdutoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = iProdutoDAO.excluir(produtoBD);
        assertEquals(1, (int) countDel);
    }

    @Test
    public void excluirTest() throws Exception {
        iProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto 1");
        Integer countCad = iProdutoDAO.cadastrar(produto);
        assertEquals(1, (int) countCad);

        Produto produtoBD = iProdutoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = iProdutoDAO.excluir(produtoBD);
        assertEquals(1, (int) countDel);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        iProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto 1");
        Integer countCad = iProdutoDAO.cadastrar(produto);
        assertEquals(1, (int) countCad);

        Produto produto2 = new Produto();
        produto2.setCodigo("20");
        produto2.setNome("Produto 2");
        Integer countCad2 = iProdutoDAO.cadastrar(produto2);
        assertEquals(1, (int) countCad2);

        List<Produto> list = iProdutoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        Integer countDel = 0;
        for (Produto prod : list) {
            iProdutoDAO.excluir(prod);
            countDel++;
        }
        assertEquals(list.size(), (int) countDel);

        list = iProdutoDAO.buscarTodos();
        assertEquals(0, list.size());
    }

    @Test
    public void atualizarTest() throws Exception {
        iProdutoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto 1");
        Integer countCad = iProdutoDAO.cadastrar(produto);
        assertEquals(1, (int) countCad);

        Produto produtoBD = iProdutoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        produtoBD.setCodigo("20");
        produtoBD.setNome("Outro produto");
        Integer countUpdate = iProdutoDAO.atualizar(produtoBD);
        assertEquals(1, (int) countUpdate);

        Produto produtoBD1 = iProdutoDAO.buscar("10");
        assertNull(produtoBD1);

        Produto produtoBD2 = iProdutoDAO.buscar("20");
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());

        List<Produto> list = iProdutoDAO.buscarTodos();
        for (Produto prod : list) {
            iProdutoDAO.excluir(prod);
        }
    }
}
