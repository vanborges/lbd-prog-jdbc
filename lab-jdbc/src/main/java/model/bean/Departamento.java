package model.bean;

public class Departamento {
    private String dnome;
    private int dnumero;

    public Departamento() {
    }

    public Departamento(String dnome, int dnumero) {
        this.dnome = dnome;
        this.dnumero = dnumero;
    }

    public String getDnome() {
        return dnome;
    }

    public void setDnome(String dnome) {
        this.dnome = dnome;
    }

    public int getDnumero() {
        return dnumero;
    }

    public void setDnumero(int dnumero) {
        this.dnumero = dnumero;
    }

    @Override
    public String toString() {
        return "Departamento{" + "dnome=" + dnome + ", dnumero=" + dnumero + '}';
    }
}

