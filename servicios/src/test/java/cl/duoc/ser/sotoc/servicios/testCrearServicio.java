package cl.duoc.ser.sotoc.servicios;

import cl.duoc.ser.sotoc.servicios.controller.ServicioController;
import cl.duoc.ser.sotoc.servicios.model.Servicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;


import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class testCrearServicio {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        // Limpiamos la lista estática antes de cada test para tener un entorno limpio
        ServicioController.listaServicio.clear();
    }

    @Test
    void testCrearServicio() throws Exception {
        Servicio mockServicio = new Servicio(2, "Mantenimiento", "Limpieza", 35000, "Descripción de prueba");
    }

    @Test
    void testObtenerServicios() throws Exception {
        // Agregamos manualmente uno para probar el GET
        ServicioController.listaServicio.add(new Servicio(1, "Cat", "Soporte", 10000, "Desc"));
    }
}
