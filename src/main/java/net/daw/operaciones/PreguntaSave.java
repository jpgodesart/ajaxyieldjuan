/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.PreguntaBean;
import net.daw.dao.PreguntaDao;
import net.daw.helper.Conexion;
import net.daw.helper.EncodingUtil;

/**
 *
 * @author al037721
 */
public class PreguntaSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            PreguntaDao oPreguntaDAO = new PreguntaDao(Conexion.getConection());
            PreguntaBean oPregunta = new PreguntaBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oPregunta = gson.fromJson(jason, oPregunta.getClass());
            Map<String, String> data = new HashMap<>();
            if (oPregunta != null) {
                oPregunta = oPreguntaDAO.set(oPregunta);
                data.put("status", "200");
                data.put("message", Integer.toString(oPregunta.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("PreguntaSaveJson: View Error: " + e.getMessage());
        }
    }
}