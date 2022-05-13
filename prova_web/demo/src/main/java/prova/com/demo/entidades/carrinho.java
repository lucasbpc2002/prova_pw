package prova.com.demo.entidades;

public class carrinho {
    private Integer idUser;
    private Integer idProduto;
    private String nomeProduto;

    public void Carrinho() {

    }
    public void Carrinho( String nomeProduto,Integer idUser, Integer idProduto) {
        this.idUser = idUser;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

}