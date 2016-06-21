/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simemisorreceptor;

import cz.zcu.fav.kiv.jsim.JSimException;
import cz.zcu.fav.kiv.jsim.JSimInvalidParametersException;
import cz.zcu.fav.kiv.jsim.JSimProcess;
import cz.zcu.fav.kiv.jsim.JSimSimulation;
import cz.zcu.fav.kiv.jsim.JSimSimulationAlreadyTerminatedException;
import cz.zcu.fav.kiv.jsim.JSimSystem;
import cz.zcu.fav.kiv.jsim.JSimTooManyProcessesException;
import cz.zcu.fav.kiv.jsim.ipc.JSimMessage;
import cz.zcu.fav.kiv.jsim.ipc.JSimMessageBox;

/**
 *
 * @author Jano
 */
public class Crime extends JSimProcess
{
    public static final double LAMBDA = 1.0;

    private JSimMessageBox box6;

    // ------------------------------------------------------------------------------------------------------------------------------------

    public Crime(String name, JSimSimulation parent, JSimMessageBox messageBox, JSimProcess Emisor) throws JSimSimulationAlreadyTerminatedException, JSimInvalidParametersException, JSimTooManyProcessesException
    {
            super(name, parent);
            box6 = messageBox;
    } // constructor

    protected void life()
    {
            JSimMessage mensaje;
            double sleepTime;

            try
            {
                int inicio = SimEmisorReceptor.getTiempo();
                myReview Crime = SimEmisorReceptor.objetoFecha(6, inicio);
                
                while (true)
                {
                    boolean validaTopico = false;
                    
                    message(SimEmisorReceptor.FormatoFecha(SimEmisorReceptor.getTiempo()) + " - " + getName() + "< leyendo bandeja mensajes de entrada <<");
                    mensaje = receiveMessageWithoutBlocking(box6);
                    
                    if(inicio != SimEmisorReceptor.getTiempo()){
                        
                        /****************************************
                           LLAMAR FUNCION DE RANKING Y ESCRIBIR
                        *****************************************/
                        message("Ranking anterior: "+SimEmisorReceptor.formulaRanking(Crime));
                        
                        Crime = SimEmisorReceptor.objetoFecha(6, SimEmisorReceptor.getTiempo());
                    }
                    if (mensaje == null){
                        message(SimEmisorReceptor.FormatoFecha(SimEmisorReceptor.getTiempo()) + " - " + getName() + "< bandeja vacia <<");
                    }
                    else{
                        message(SimEmisorReceptor.FormatoFecha(SimEmisorReceptor.getTiempo()) + " - " + getName() + "< Recibiendo mensaje: " + mensaje.getData().toString());
                        Crime.setScore(Double.parseDouble(SimEmisorReceptor.retornaValor(mensaje.getData().toString(), 0).toString()));
                        Crime.setC11(Double.parseDouble(SimEmisorReceptor.retornaValor(mensaje.getData().toString(), 1).toString()));
                        Crime.setC12(Double.parseDouble(SimEmisorReceptor.retornaValor(mensaje.getData().toString(), 2).toString()));
                        Crime.setC13(Double.parseDouble(SimEmisorReceptor.retornaValor(mensaje.getData().toString(), 3).toString()));
                        Crime.setC21(Double.parseDouble(SimEmisorReceptor.retornaValor(mensaje.getData().toString(), 4).toString()));
                        Crime.setC22(Double.parseDouble(SimEmisorReceptor.retornaValor(mensaje.getData().toString(), 5).toString()));
                        Crime.setC23(Double.parseDouble(SimEmisorReceptor.retornaValor(mensaje.getData().toString(), 6).toString()));
                        Crime.setParcial((Crime.getC11()*Crime.getScore()+Crime.getC21())/SimEmisorReceptor.alpha+SimEmisorReceptor.alpha*(Crime.getC12()*Crime.getScore()+Crime.getC22())+Crime.getC13()*Crime.getScore()+Crime.getC23());
                        Crime.setNumeroReviews(Crime.getNumeroReviews()+1);
                    }
                    sleepTime = JSimSystem.negExp(LAMBDA);
                    message(SimEmisorReceptor.FormatoFecha(SimEmisorReceptor.getTiempo()) + " - " + getName() + ": espero el siguiente mensaje");
                    hold(1);
                } // while
            } // try
            catch (JSimException e)
            {
                e.printStackTrace();
                e.printComment(System.err);
            } // catch
    } // life

} // class ReceivingProcess
