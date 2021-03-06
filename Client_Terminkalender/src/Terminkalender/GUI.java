/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender;

import Terminkalender.GUIPart.Fenster;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author niroshan
 */
public class GUI {

    /**
     *  GUI
     */
    
    private final LauncherInterface stub;
        
    GUI(LauncherInterface stub){
        this.stub = stub;
    }

    public GUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Methode die GUI startet
     * 
     */
    public void startGUI(){
        try{
                anmeldenGUI();
	}
        
	catch (RemoteException e){
            System.err.println(e.getMessage());
	}
        
        catch (BenutzerException e) {
            System.err.println(e.getMessage());
        }
        
        catch (TerminException e) {
            System.err.println(e.getMessage());
        } 
        
        catch (Datum.DatumException e) {
            System.err.println(e.getMessage());
        } 
        
        catch (Zeit.ZeitException e) {
            System.err.println(e.getMessage());
        }
        catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * GUI zum Startbildschirm
     * 
     * @throws RemoteException
     * @throws BenutzerException
     * @throws TerminException
     * @throws Terminkalender.Datum.DatumException
     * @throws Terminkalender.Zeit.ZeitException 
     */
    private void anmeldenGUI() throws RemoteException, BenutzerException, TerminException, Datum.DatumException, Zeit.ZeitException, SQLException{ 
        Fenster start = new Fenster(stub);
        start.setVisible(true);
        
    }
    
}
