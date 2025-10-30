package Service;
import Model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    public List<Produto> produtos = new ArrayList<>(List.of(
            new Produto(1L, "Notebook", 10000.00),
            new Produto(2L, "Impressora", 200.00),
            new Produto(3L, "Mouse", 50.00)
    ));


    public List<Produto> listarProdutos() {
        return produtos;
    }


    public Produto AdicionarProduto(Produto produto) {
        produto.setId(produtos.size() + 1L);
        produtos.add(produto);
        return produto;
    }
        public Produto AtualizarProduto(Long id, Produto produtoAtualizado){
            Produto produtoExistente = produtos.stream().filter(p -> p.getId().equals(id))
                    .findFirst().orElseThrow(()-> new RuntimeException("Produto não encontrado"));
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            return produtoExistente;
        }

        public Produto ApagarProduto(Long id){
            Produto produto = produtos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
            produtos.remove(produto);
            return produto;
        }
        public List<Produto> buscarProdutos(String description, Double minPrice, Double maxPrice) {
            return produtos.stream()
                    .filter(p -> description == null || p.getNome().toLowerCase().contains(description.toLowerCase()))
                    .filter(p -> minPrice == null || p.getPreco() >= minPrice)
                    .filter(p -> maxPrice == null || p.getPreco() <= maxPrice)
                    .collect(Collectors.toList());
        }

    }
