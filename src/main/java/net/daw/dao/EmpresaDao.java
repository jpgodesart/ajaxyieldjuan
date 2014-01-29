/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.dao;

import net.daw.bean.EmpresaBean;
import net.daw.helper.Conexion;

/**
 *
 * @author AntonioNP
 */
public class EmpresaDao extends GenericDaoImplementation<EmpresaBean>{
    
    public EmpresaDao(Conexion.Tipo_conexion tipo_conexion) throws Exception{
        super(tipo_conexion, "empresa");
    }
}