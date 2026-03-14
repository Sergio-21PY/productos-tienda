package cl.duoc.ser.sotoc.servicios.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Webpay {
    private String id;
    private String estado;
    private int monto;
    private String ordenCompra;
    private LocalDate fechaCompra;
}
