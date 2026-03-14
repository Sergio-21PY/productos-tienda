package cl.duoc.ser.sotoc.servicios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {

    private int id;
    private String categoria;
    private String nombre;
    private int valor;
    private String descripcion;

}
