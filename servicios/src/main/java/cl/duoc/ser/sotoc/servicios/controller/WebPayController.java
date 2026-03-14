package cl.duoc.ser.sotoc.servicios.controller;

import cl.duoc.ser.sotoc.servicios.model.Servicio;
import cl.duoc.ser.sotoc.servicios.model.Webpay;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class WebPayController {


    @PostMapping("/webpay-confirmacion/{id}")
    public String confirmarPago(@PathVariable int id, @RequestBody Webpay pago) {

        // Buscamos el servicio en la lista
        Servicio servicioEncontrado = null;
        for (Servicio s : ServicioController.listaServicio) {
            if (s.getId() == id) {
                servicioEncontrado = s;
                break;
            }
        }

        if (servicioEncontrado == null) {
            return "Error: El servicio con ID " + id + " no existe en el sistema.";
        }

        // Validacion
        if (pago.getMonto() != servicioEncontrado.getValor()) {
            return "Pago Rechazado: El monto enviado ($" + pago.getMonto() +
                    ") no coincide con el valor real de " + servicioEncontrado.getNombre() +
                    " ($" + servicioEncontrado.getValor() + ").";
        }

        if ("Autorizado".equalsIgnoreCase(pago.getEstado())) {
            return  "ID Pago: " + pago.getId() + "\n"+
                    "¡Pago Exitoso! Has comprado: " + servicioEncontrado.getNombre() +
                    ". Orden: " + pago.getOrdenCompra() +
                    ". Fecha: " + pago.getFechaCompra();
        }

        return "Pago rechazado por la pasarela.";
    }
}

