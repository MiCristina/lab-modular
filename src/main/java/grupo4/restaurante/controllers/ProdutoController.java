//package grupo4.restaurante.controllers;
//
//import grupo4.restaurante.models.Produto;
//import grupo4.restaurante.services.ProdutoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;

//@RestController
//@RequestMapping("/produtos")
//public class ProdutoController {
//
//    private final ProdutoService produtoService;
//
//    @Autowired
//    public ProdutoController(ProdutoService produtoService) {
//        this.produtoService = produtoService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
//        Produto novoProduto = produtoService.adicionarProduto(produto);
//        return ResponseEntity.ok(novoProduto);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Produto>> listarProdutos() {
//        List<Produto> produtos = produtoService.listarProdutos();
//        return ResponseEntity.ok(produtos);
//    }
//
//}
