package cl.duoc.ser.sotoc.servicios.controller;

import cl.duoc.ser.sotoc.servicios.model.Servicio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/servicio")
@RestController
public class ServicioController {
    public static List<Servicio> listaServicio = new ArrayList<>();

    //Creacion de servicios
    @PostMapping("/crear")
    public Servicio crearServicio(@RequestBody Servicio nuevoServicio) {
        ServicioController.listaServicio.add(nuevoServicio);
        return nuevoServicio;
    }

    //{
    //    "id": 1,
    //    "categoria": "Mantenimiento",
    //    "nombre": "Limpieza y Optimización",
    //    "valor": 35000,
    //    "descripcion": "Limpieza física profunda, cambio de pasta térmica y optimización de sistema operativo."
    //}

    //Obtencion de lista de servicios
    @GetMapping
    public List<Servicio> obtenerServicio(){
        return listaServicio;
    }

    //Eliminar servicio mediante ID
    @DeleteMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable int id){
        boolean eliminado = listaServicio.removeIf(servicio -> servicio.getId() == id);
        if (eliminado){
            return "El servicio ha sido eliminado correctamente";
        }
        return "El servicio no existe";
    }

    @PostMapping("/comprar/{id}")
    public String comprarServicio(@PathVariable int id) {
        //Busca el servicio por ID
        for (Servicio s : listaServicio) {
            if (s.getId() == id) {
                // Registro de compra
                return "Intención de compra registrada: " + s.getNombre() +
                        ". El valor a pagar es $" + s.getValor() +
                        ". Procede a confirmar con Webpay.";
            }
        }
        // Si no se encuentra el servicio, devuelve un mensaje de error
        return "Error: El servicio con ID " + id + " no existe en el catálogo.";
    }




}
