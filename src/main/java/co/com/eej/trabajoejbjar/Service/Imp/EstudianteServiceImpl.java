package co.com.eej.trabajoejbjar.Service.Imp;

import co.com.eej.trabajoejbjar.Entity.Estudiante;
import co.com.eej.trabajoejbjar.Exception.BadRequestEx;
import co.com.eej.trabajoejbjar.Exception.ConflictEx;
import co.com.eej.trabajoejbjar.Exception.NotFoundEx;
import co.com.eej.trabajoejbjar.Repository.IEstudianteRepo;
import co.com.eej.trabajoejbjar.Service.IEstudianteService;
import javax.ejb.Stateless;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Stateless
public class EstudianteServiceImpl implements IEstudianteService {

    @EJB
    private IEstudianteRepo repo;

    @Override
    public List<Estudiante> listar() {
        return repo.listarTodos();
    }

    @Override
    public Estudiante listarPorId(Integer id) throws NotFoundEx {
        Estudiante estudiante = repo.listarPorId(id);
        if (estudiante == null) {
            throw new NotFoundEx("Estudiante no encontrado");
        }
        return estudiante;
    }

    @Override
    public void guardar(Estudiante obj) throws ConflictEx, BadRequestEx {
        
        if (validarCorreo(obj.getCorreo()) == false) {
            throw new BadRequestEx("El correo no cuenta con el formato adecuado");
        }
        if (tieneLetras(obj.getCedula()) == true) {
            throw new BadRequestEx("La cedula no puede contener letras");
        } else {
            List<Estudiante> listaEstudiantes = this.listar();
            if (listaEstudiantes.isEmpty() == true) {
                this.repo.guardar(obj);
            } else {
                for (int i = 0; i < listaEstudiantes.size(); i++) {
                    if (obj.getCedula().equals(listaEstudiantes.get(i).getCedula())) {
                        throw new ConflictEx("La cedula ya esta registrada en la base de datos");
                    }
                    if (obj.getCorreo().equals(listaEstudiantes.get(i).getCorreo())) {
                        throw new ConflictEx("El correo ya esta registrado en la base de datos");
                    }
                }
                
                this.repo.guardar(obj);
            }
        }
    }

    @Override
    public void editar(Estudiante obj) throws NotFoundEx, ConflictEx, BadRequestEx {
        if (obj.getId() != null) {
            Estudiante estudiante = this.listarPorId(obj.getId());
            //0riginal del estudiante a modificar
            System.out.println("cc: " + estudiante.getCedula());
            List<Estudiante> listaEstudiantes = this.listar();
            if (listaEstudiantes.isEmpty() == true) {
            } else {                
                for (int i = 0; i < listaEstudiantes.size(); i++) {
                    if (obj.getCedula().equals(listaEstudiantes.get(i).getCedula())){   
                        if (obj.getId() != listaEstudiantes.get(i).getId()) {
                            throw new ConflictEx("La cedula ya esta registrada en la base de datos");
                        }
                    }
                }
                this.repo.editar(obj);
            }
        } else {
            throw new BadRequestEx("Id es obligatorio");
        }
    }

    @Override
    public void eliminar(Integer id) throws NotFoundEx {
        Estudiante estudiante = this.listarPorId(id);
        this.repo.eliminar(estudiante);
    }

    @Override
    public void eliminar2(Integer id) throws NotFoundEx {
        byte valor = this.repo.contarId(id);
        if (valor == 1) {
            this.repo.eliminar2(id);
        } else {
            throw new NotFoundEx("Estudiante no existe");
        }
    }

    public Boolean tieneLetras(String texto) {

        String letras = "abcdefghyjklmnñopqrstuvwxyz";
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            if (letras.indexOf(texto.charAt(i), 0) != -1) {
                return true;
            }
        }
        return false;
    }

    public Boolean validarCorreo(String correo) {
        boolean result = true;

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() != true) {
            result = false;
        }
        return result;
    }

}
