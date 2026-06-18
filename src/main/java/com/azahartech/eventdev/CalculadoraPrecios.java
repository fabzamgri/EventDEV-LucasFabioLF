package com.azahartech.eventdev;

public class CalculadoraPrecios {
    public static final double IVA = 0.21;
    public static final double DESCUENTO_ESTUDIANTE_ALTO = 0.10;
    public static final double DESCUENTO_ESTUDIANTE_BAJO = 0.05;
    public static final int RECARGO_VIP = 50;
    public static final int TIPO_ESTUDIANTE = 1;
    public static final int TIPO_VIP = 2;
    // Método para calcular precio total
    // p: precio base, n: número entradas, t: tipo
    //(1=estudiante,2=vip)

    public double calc(double precioBase, int numEntradas, int tipoUsuario) {
        double precioFinal = precioBase * numEntradas;

        precioFinal = aplicarDescuentosORecargos(tipoUsuario, precioFinal);

        // Impuesto
        precioFinal = precioFinal + (precioFinal * IVA);

        return precioFinal;
    }

    private static double aplicarDescuentosORecargos(int tipoUsuario, double precioFinal) {
        if (tipoUsuario == TIPO_ESTUDIANTE) {
            // Descuento estudiante
            if (precioFinal > 100) {
                precioFinal = precioFinal - (precioFinal * DESCUENTO_ESTUDIANTE_ALTO);
            } else {
                precioFinal = precioFinal - (precioFinal * DESCUENTO_ESTUDIANTE_BAJO);
            }
        } else if (tipoUsuario == TIPO_VIP) {
            // Recargo VIP por servicios extra
            precioFinal = precioFinal + RECARGO_VIP;
        }
        return precioFinal;
    }
}