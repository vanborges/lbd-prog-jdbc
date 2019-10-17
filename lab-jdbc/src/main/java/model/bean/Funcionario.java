package model.bean;

public class Funcionario {
    private String pnome;
    private String minicial;
    private String unome;
    private String cpf;
    private String endereco;
    private String sexo;
    private Float salario;
    private String cpf_supervisor;
    private Departamento dnr;

    public Funcionario() {
    }


    public Funcionario(String pnome, String minicial, String unome, String cpf, String endereco, String sexo, Float salario, String cpf_supervisor, Departamento dnr) {
        this.pnome = pnome;
        this.minicial = minicial;
        this.unome = unome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sexo = sexo;
        this.salario = salario;
        this.cpf_supervisor = cpf_supervisor;
        this.dnr = dnr;
    }

    public String getPnome() {
        return pnome;
    }

    public void setPnome(String pnome) {
        this.pnome = pnome;
    }

    public String getMinicial() {
        return minicial;
    }

    public void setMinicial(String minicial) {
        this.minicial = minicial;
    }

    public String getUnome() {
        return unome;
    }

    public void setUnome(String unome) {
        this.unome = unome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getCpf_supervisor() {
        return cpf_supervisor;
    }

    public void setCpf_supervisor(String cpf_supervisor) {
        this.cpf_supervisor = cpf_supervisor;
    }

    public Departamento getDnr() {
        return dnr;
    }

    public void setDnr(Departamento dnr) {
        this.dnr = dnr;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "pnome=" + pnome + ", minicial=" + minicial + ", unome=" + unome + ", cpf=" + cpf + ", endereco=" + endereco + ", sexo=" + sexo + ", salario=" + salario + ", cpf_supervisor=" + cpf_supervisor + ", dnr=" + dnr + '}';
    }
}