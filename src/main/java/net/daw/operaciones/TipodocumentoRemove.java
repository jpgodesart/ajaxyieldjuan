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
import net.daw.bean.TipodocumentoBean;
import net.daw.dao.TipodocumentoDao;
import net.daw.helper.Conexion;

/**
 *
 * @author Jacobo
 */
public class TipodocumentoRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            TipodocumentoDao oTipodocumentoDAO = new TipodocumentoDao(Conexion.getConection());
            TipodocumentoBean oTipodocumento = new TipodocumentoBean();                                           
            oTipodocumento.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oTipodocumento != null) {
                oTipodocumentoDAO.remove(oTipodocumento);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oTipodocumento.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("TipodocumentoRemoveJson: View Error: " + e.getMessage());
        }
    }
}
