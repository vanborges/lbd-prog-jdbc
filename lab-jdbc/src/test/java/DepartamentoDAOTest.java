import model.bean.Departamento;
import model.dao.DepartamentoDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepartamentoDAOTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Departamento d = new Departamento("Computação", 2);
        DepartamentoDAO dao = new DepartamentoDAO();
        if(dao.insert(d)){
            System.out.println("Salvo com sucesso "+d.toString());
        } else {
            Assertions.fail("Erro ao salvar");
        }
    }
    @Test
    void selectbyid() {
        System.out.println("selecionar");

        DepartamentoDAO dao = new DepartamentoDAO();
        List<Departamento> ld =  dao.selectbyid(2);
        if (ld.isEmpty()) {
            Assertions.fail("Erro ao salvar");
        } else {
            System.out.println(ld.toString());
        }

    }
}