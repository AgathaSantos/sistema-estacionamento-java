package controller;

import model.Veiculo;
import service.EstacionamentoService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstacionamentoController {

    private List<Veiculo> veiculos = new ArrayList<>();
    private EstacionamentoService service = new EstacionamentoService();

    public void registrarEntrada(String placa) {
        if (placa.isEmpty()) {
            System.out.println("Placa inválida!");
            return;
        }

        Veiculo v = new Veiculo();
        v.setPlaca(placa);
        v.setEntrada(LocalDateTime.now());

        veiculos.add(v);

        System.out.println("Entrada registrada!");
    }

    public String registrarSaida(String placa) {
        Veiculo v = buscarVeiculo(placa);

        if (v == null) {
            return "Veículo não encontrado.";
        }

        v.setSaida(LocalDateTime.now());

        double valor = service.calcularValor(v.getEntrada(), v.getSaida());

        return "Valor a pagar: R$ " + valor;
    }

    private Veiculo buscarVeiculo(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa) && v.getSaida() == null) {
                return v;
            }
        }
        return null;
    }

    public String listarVeiculosTexto() {
        StringBuilder sb = new StringBuilder();

        for (Veiculo v : veiculos) {
            sb.append("Placa: ").append(v.getPlaca())
              .append(" | Entrada: ").append(v.getEntrada())
              .append(" | Saída: ")
              .append(v.getSaida() == null ? "No pátio" : v.getSaida())
              .append("\n");
        }

        return sb.toString();
    }
}