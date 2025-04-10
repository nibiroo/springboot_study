package io.github.nibiroo.study.Controller;

import io.github.nibiroo.study.Model.Entity.Product;
import io.github.nibiroo.study.Repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductRepository produtoRepository;

    public ProductController(ProductRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Product salvar(@RequestBody Product produto){
        System.out.println("Produto recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Product obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Product produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Product> buscar(@RequestParam("name") String name){
        return produtoRepository.findByName(name);
    }
}