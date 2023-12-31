package com.educandoweb.curso.configuracao;


import com.educandoweb.curso.enuns.StatusPedido;
import com.educandoweb.curso.models.Categoria;
import com.educandoweb.curso.models.Pedido;
import com.educandoweb.curso.models.Produto;
import com.educandoweb.curso.models.Usuario;
import com.educandoweb.curso.repositories.CategoriaRepository;
import com.educandoweb.curso.repositories.PedidoRepository;
import com.educandoweb.curso.repositories.ProdutoRepository;
import com.educandoweb.curso.repositories.UsarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class ConfiguracaoTeste implements CommandLineRunner {
    @Autowired
    private UsarioRepository usarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public void run(String... args) throws Exception {


        Categoria cat1 = new  Categoria(null, "Eletronicos");
        Categoria cat2 = new  Categoria(null, "Livros");
        Categoria cat3 = new  Categoria(null, "Computadores");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategoria().add(cat2);
        p2.getCategoria().add(cat1);
        p2.getCategoria().add(cat3);
        p3.getCategoria().add(cat3);
        p4.getCategoria().add(cat3);
        p5.getCategoria().add(cat2);

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido o1 = new  Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.ENTREGUE, u1);
        Pedido o2 = new  Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.PAGO, u2);
        Pedido o3 = new  Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.CANCELADO, u1);

        usarioRepository.saveAll(Arrays.asList(u1,u2));
         pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));


    }
}
