package edu.ibero.controller;

import edu.ibero.model.Conectar;
import edu.ibero.model.Usuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioController() {
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());

    }

    @RequestMapping("index.htm")
    public ModelAndView showHome() {
        ModelAndView model = new ModelAndView();
        String sql = "select * from usuarios ORDER BY id asc"; //order by id desc --> ordena de mayor a menor
        List datos = jdbcTemplate.queryForList(sql);
        model.addObject("datos", datos);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.GET)
    public ModelAndView showAdd() {
        ModelAndView model = new ModelAndView();
        model.setViewName("add");
        model.addObject("usuarios", new Usuarios());
        return model;
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public ModelAndView showAdd(
            @ModelAttribute("usuarios") Usuarios user,
            BindingResult result,
            SessionStatus status) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView();
            model.setViewName("add");
            model.addObject("usuarios", new Usuarios());
            return model;
        } else {
            this.jdbcTemplate.update(
                    "insert into usuarios(nombre,correo,telefono) value(?,?,?)",
                    user.getNombre(), user.getCorreo(), user.getTelefono());
            return new ModelAndView("redirect:/index.htm");
        }
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.GET)
    public ModelAndView showEdit(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Usuarios users = this.selectUsuarios(id);
        model.setViewName("edit");
        model.addObject("usuarios", new Usuarios(id, users.getNombre(), users.getCorreo(), users.getTelefono()));
        return model;
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.POST)
    public ModelAndView showEdit(@ModelAttribute("usuarios") Usuarios user,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("id"));
            Usuarios users = this.selectUsuarios(id);
            model.setViewName("edit");
            model.addObject("usuarios", new Usuarios(id, users.getNombre(), users.getCorreo(), users.getTelefono()));
            return model;
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            jdbcTemplate.update("update usuarios set nombre=?,correo=?,telefono=? where id=?",
                    user.getNombre(), user.getCorreo(), user.getTelefono(), id);
            return new ModelAndView("redirect:/index.htm");
        }
    }

    @RequestMapping("del.htm")
    public ModelAndView showDelete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update("delete from usuarios where id=?", id);
        return new ModelAndView("redirect:/index.htm");
    }

    public Usuarios selectUsuarios(int id) {
        final Usuarios users = new Usuarios();
        String sql = "select * from usuarios where id='" + id + "'";
        return (Usuarios) jdbcTemplate.query(sql, new ResultSetExtractor<Usuarios>() {
            @Override
            public Usuarios extractData(ResultSet rs) throws SQLException, DataAccessException {

                if (rs.next()) {
                    users.setNombre(rs.getString("nombre"));
                    users.setCorreo(rs.getString("correo"));
                    users.setTelefono(rs.getString("telefono"));
                }
                return users;
            }

        });
    }
}
