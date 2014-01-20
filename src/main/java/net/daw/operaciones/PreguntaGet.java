 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

/**
 *
 * @author al037721
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.daw.bean.PreguntaBean;
import net.daw.dao.PreguntaDao;
import net.daw.helper.Conexion;


public class PreguntaGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                PreguntaDao oPreguntaDAO = new PreguntaDao(Conexion.getConection());
                PreguntaBean oPregunta = new PreguntaBean();
                oPregunta.setId(Integer.parseInt(request.getParameter("id")));
                oPreguntaDAO.get(oPregunta);
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oPregunta);
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("PreguntaGetJson: View Error: " + e.getMessage());
        }
    }
}
