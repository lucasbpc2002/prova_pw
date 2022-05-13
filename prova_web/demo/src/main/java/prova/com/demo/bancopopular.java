package prova.com.demo;

import prova.com.demo.entidades.serie;
import prova.com.demo.respositorio.serierepositorio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class bancopopular {

    @GetMapping("/config")
    public void doRemoverCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        serie serie1 = new serie("Breaking Bad", "Eric", "netflix", 5, 30, 1);
        serie serie2 = new serie("vikings", "acao/medieval", "netflix", 6, 120, 2);
        serie serie3 = new serie("loki", "acao", "disney plus", 1, 8, 3);
        serie serie4 = new serie("moon knight", "acao ", "disney plus", 1, 6, 4);
        serie serie5 = new serie("30 monedas", "terror", "Hbo max", 1, 10, 5);

        try {
            serieRepositorio.criarTabela();
        }catch (Exception e){
            System.out.println(e);
        }


        try {

            serieRepositorio.inserir(serie1);
            serieRepositorio.inserir(serie2);
            serieRepositorio.inserir(serie3);
            serieRepositorio.inserir(serie4);
            serieRepositorio.inserir(serie5);
            var writer = response.getWriter();
            writer.println("sucesso na criação e população de banco de dados");
        } catch (Exception e){

            var writer = response.getWriter();
            writer.println("fracaçou!");
        }

    }
}