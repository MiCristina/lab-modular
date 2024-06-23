package grupo4.restaurante.models;


public enum MetodoPagamento {
    DINHEIRO(0.0, 0.0),
    PIX(0.0145, 10.0),
    DEBITO(0.014, 0.0),
    CREDITO(0.031, 0.0);

    private final double desconto;
    private final double limiteDesconto;

    MetodoPagamento(double desconto, double limiteDesconto) {
        this.desconto = desconto;
        this.limiteDesconto = limiteDesconto;
    }

    public double calcularDesconto(double valor) {
        if (this == PIX) {
            return Math.min(valor * desconto, limiteDesconto);
        } else {
            return valor * desconto;
        }
    }
}
