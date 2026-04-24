package service;

import java.time.Duration;
import java.time.LocalDateTime;

public class EstacionamentoService {

    public double calcularValor(LocalDateTime entrada, LocalDateTime saida) {
        long minutos = Duration.between(entrada, saida).toMinutes();

        if (minutos <= 15) return 0;

        return Math.ceil(minutos / 60.0) * 10;
    }
}