package uniandes.edu.co.proyecto;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.CategoriaRepository;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;
import uniandes.edu.co.proyecto.modelo.*;;


@SpringBootApplication
public class ProyectoApplication  implements CommandLineRunner{


	@Autowired
	private BodegaRepository ciudadRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}


	@Override
	public void run(String... args)  
	 {

		Collection<Bodega> ciudad = ciudadRepository.darBodegas();
		
		for (Bodega bodega : ciudad) {
			System.out.println(bodega.getNombre());
		}

	}
}