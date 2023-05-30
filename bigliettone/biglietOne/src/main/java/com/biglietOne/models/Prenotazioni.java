package com.biglietOne.models;

public class Prenotazioni extends Entity {
    private int idPrenotazione;
    private int idUtente ;
    private int idEventiDetails;
    private int idPrezzi;
/* 
 * Metodi Setter
 */
    public void setIdPrenotazione(int input){
        this.idPrenotazione = input;
    }
    public void setIdUtente(int input) {
        this.idUtente = input;
    }
    public void setIdEventoDetails(int input) {
        this.idEventiDetails = input;
    }
    public void setIdPrezzi(int input) {
        this.idPrezzi = input;
    }
/* 
* Metodi get
*/
    public int getIdPrenotazione() {
        return idPrenotazione;
    }
    public int getIdUtente() {
        return idUtente;
    }
    public int getIdEventiDetails() {
        return idEventiDetails;
    }
    public int getIdPrezzi() {
        return idPrezzi;
    }

}
