/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.PreguntaBean;
import net.daw.helper.Conexion;

/**
 *
 * @author al037721
 */
public class PreguntaDao extends GenericDaoImplementation<PreguntaBean> {
  
    public PreguntaDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion,"pregunta");
    }
    
}
