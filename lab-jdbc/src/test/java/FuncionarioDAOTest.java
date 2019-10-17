package test;

import model.bean.Departamento;
import model.bean.Funcionario;
import model.dao.FuncionarioDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class FuncionarioDAOTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        System.out.println("incluir");
        Departamento d = new Departamento("Pesquisa", 1);
        Funcionario f = new Funcionario("Vanessa", "A", "Borges", "519800109", "endereco","F" , Float.valueOf(2000), "12345566", d);
        FuncionarioDAO dao = new FuncionarioDAO();
        if(dao.insert(f)){
            System.out.println("Salvo com sucesso");
        } else {
            Assertions.fail("Erro ao salvar");
        }
    }

    @Test
    void delete() {
    }

    @Test
    void selectbyid() {
        System.out.println("selecionar");
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lf =  dao.selectbyid(519800109);
        if(lf.isEmpty()){
            Assertions.fail("Erro ao salvar");
        } else {
            for (Funcionario lf1 : lf) {
                System.out.println(lf1.toString());
            }
        }
    }
}