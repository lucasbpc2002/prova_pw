package prova.com.demo.entidades;

public class serie {
    private Integer id;
    private String nome;
    private Integer n_temporadas;
    private Integer n_episodios;
    private String genero;
    private String plataforma; //plataforma de stream que transmite a serie//

    public serie(){

    }
    serie(String nome,String genero,String plataforma,Integer n_temporadas,Integer n_episodios ,Integer id){
        this.nome =  nome;
        this.genero =  genero;
        this.plataforma =  plataforma;
        this.n_temporadas = n_temporadas;
        this.n_episodios = n_episodios;
        this.id = id;
    }
    @Override
    public String toString() {
        return "Livro{" +
                "idserie=" + id +
                ", nome='" + nome + '\'' +
                ", genero='" + genero+ '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", num de temporadas='" + n_temporadas + '\'' +
                ", num de episodios='" + n_episodios + '\'' +
                '}';
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getPlataforma(){
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;

    }
    public Integer getN_temporadas(){
        return n_temporadas;
    }
    public void setN_temporadas(Integer n_temporadas) {
        this.n_temporadas = n_temporadas;
    }
    public Integer getN_episodios(){
        return n_episodios;
    }
    public void setN_episodios(Integer n_episodios) {
        this.n_episodios = n_episodios;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
