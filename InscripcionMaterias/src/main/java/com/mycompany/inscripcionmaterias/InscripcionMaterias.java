/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inscripcionmaterias;

import clases.Menu;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Chicho
 */
public class InscripcionMaterias{

    public static void main(String[] args) throws JsonProcessingException, SQLException, IOException{
        Menu menu = new Menu();
        
        menu.Menu();
    } 
}
