package pt.multicert.client.rest.bean;

public class Client {
    private String nome; 
    private String nif;
    private String morada;
    private String telefone;
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }
    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }
    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }
    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }
    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Client [nome=" + nome + ", nif=" + nif + ", morada=" + morada
                + ", telefone=" + telefone + "]";
    }
}
