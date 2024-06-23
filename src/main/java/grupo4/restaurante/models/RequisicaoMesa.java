package grupo4.restaurante.models;

import java.util.Date;

public class RequisicaoMesa {
    private Date dataEntrada;
    private Date dataSaida;
    private Mesa mesa;
    private Cliente cliente;

    public RequisicaoMesa(Cliente cliente) {
        this.cliente = cliente;
        this.dataEntrada = new Date(); 
    }

    
    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
