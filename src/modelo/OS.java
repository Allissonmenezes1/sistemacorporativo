 
package modelo;
 
import java.util.Date;

public class OS {
    private Integer id;
    private Date momento = new Date();
    private String equipamento;
    private String descricao;
    private String DataSaida;
    private Cliente idCliente;
    private Tecnico idTecnico;
    private Equipamento idEquipamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataSaida() {
        return DataSaida;
    }

    public void setDataSaida(String DataSaida) {
        this.DataSaida = DataSaida;
    }

   

    public Integer getIdCliente() {
        return idCliente.getId();
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdTecnico() {
        return idTecnico.getId();
    }

    public void setIdTecnico(Tecnico idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Equipamento getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.idEquipamento = idEquipamento;
    }
}
