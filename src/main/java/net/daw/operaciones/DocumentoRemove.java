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
import net.daw.bean.DocumentoBean;
import net.daw.dao.DocumentoDao;
import net.daw.helper.Conexion;



/**
 *
 * @author Alvaro
 */
public class DocumentoRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            DocumentoDao oDocumentoDAO = new DocumentoDao(Conexion.getConection());
            DocumentoBean oDocumento = new DocumentoBean();                                           
            oDocumento.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oDocumento != null) {
                oDocumentoDAO.remove(oDocumento);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oDocumento.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("DocumentoRemoveJson: View Error: " + e.getMessage());
        }
    }
}
