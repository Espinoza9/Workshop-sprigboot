package com.educandoweb.curso.configuracao;


import com.educandoweb.curso.enuns.StatusPedido;
import com.educandoweb.curso.models.Categoria;
import com.educandoweb.curso.models.Pedido;
import com.educandoweb.curso.models.Usuario;
import com.educandoweb.curso.repositories.CategoriaRepository;
import com.educandoweb.curso.repositories.PedidoRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido o1 = new  Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.ENTREGUE, u1);
        Pedido o2 = new  Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.PAGO, u2);
        Pedido o3 = new  Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.CANCELADO, u1);

        Categoria cat1 = new  Categoria(null, "Eletronicos");
        Categoria cat2 = new  Categoria(null, "Livros");
        Categoria cat3 = new  Categoria(null, "Computadores");

        usarioRepository.saveAll(Arrays.asList(u1,u2));
         pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
    }
}
