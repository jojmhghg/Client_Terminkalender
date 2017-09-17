/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terminkalender;


import java.rmi.RemoteException;
import java.util.LinkedList;
import java.io.InputStream;

/**
 *
 * @author med el ouadia
 **/

public class GUI implements LauncherInterface {
    
    public GUI() throws RemoteException{
        
    }
    
    public int einloggen(String username, String passwort) throws RemoteException, BenutzerException{
        
        return 0;
    }

    @Override
    public void createUser(String username, String passwort, String email) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ausloggen(int sitzungsID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addKontakt(String username, int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeKontakt(String username, int sitzungsID) throws BenutzerException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> getKontakte(int sitzungsID) throws BenutzerException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changePasswort(String altesPW, String neuesPW, int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeVorname(String neuerVorname, int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeNachname(String neuerNachname, int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeEmail(String neueEmail, int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUsername(int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getVorname(int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNachname(int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail(int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Termin getTermin(int TerminID, int sitzungsID) throws RemoteException, BenutzerException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTermin(Termin termin, int sitzungsID) throws RemoteException, BenutzerException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTermin(Datum datum, Zeit beginn, Zeit ende, String titel, int sitzungsID) throws RemoteException, BenutzerException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTermin(int id, int sitzungsID) throws RemoteException, BenutzerException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeEditierrechte(boolean editierbar, int id, int sitzungsID) throws TerminException, BenutzerException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeTerminort(int id, String neuerOrt, int sitzungsID) throws BenutzerException, RemoteException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeTermintitel(int id, String neuerTitel, int sitzungsID) throws BenutzerException, RemoteException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeTerminnotiz(int id, String neueNotiz, int sitzungsID) throws BenutzerException, RemoteException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeTerminende(int id, Zeit neuesEnde, int sitzungsID) throws BenutzerException, TerminException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeTerminbeginn(int id, Zeit neuerBeginn, int sitzungsID) throws BenutzerException, TerminException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeTermindatum(int id, Datum neuesDatum, int sitzungsID) throws BenutzerException, RemoteException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTerminteilnehmer(int id, String username, int sitzungsID) throws RemoteException, BenutzerException, TerminException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Termin> getTermineInKalenderwoche(int kalenderwoche, int jahr, int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Termin> getTermineInMonat(int monat, int jahr, int sitzungsID) throws RemoteException, TerminException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Termin> getTermineAmTag(Datum datum, int sitzungsID) throws RemoteException, TerminException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void terminAnnehmen(int id, int sitzungsID) throws RemoteException, TerminException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void terminAblehnen(int id, int sitzungsID) throws RemoteException, TerminException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Meldungen> getMeldungen(int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMeldung(int index, int sitzungsID) throws RemoteException, BenutzerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMeldungenGelesen(int index, int sitzungsID) throws BenutzerException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}