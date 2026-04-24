package model;

import java.time.LocalDateTime;

public class Veiculo {

    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public LocalDateTime getEntrada() { return entrada; }
    public void setEntrada(LocalDateTime entrada) { this.entrada = entrada; }

    public LocalDateTime getSaida() { return saida; }
    public void setSaida(LocalDateTime saida) { this.saida = saida; }
}
