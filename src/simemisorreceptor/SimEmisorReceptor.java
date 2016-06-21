/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simemisorreceptor;

import cz.zcu.fav.kiv.jsim.JSimException;
import cz.zcu.fav.kiv.jsim.JSimSimulation;
import cz.zcu.fav.kiv.jsim.ipc.JSimMessageBox;
import java.util.Arrays;
import java.util.List;
import luceneprueba.utils.Review;


/**
 *
 * @author Jano
 */
public class SimEmisorReceptor {
    /**
     * @param args the command line arguments
     */
    public static int tiempo = 19990418;
    public static int alpha = 2;

    public static int getAlpha() {
        return alpha;
    }

    public static void setAlpha(int alpha) {
        SimEmisorReceptor.alpha = alpha;
    }

    public static myReview objetoFecha(int genero, int tiempo){
    
        if(genero == 1){
            myReview Action;
            Action = new myReview(tiempo);
            return Action;
        }
        if(genero == 2){
            myReview Adventure;
            Adventure = new myReview(tiempo);
            return Adventure;
        }
        if(genero == 3){
            myReview Animation;
            Animation = new myReview(tiempo);
            return Animation;
        }         
        if(genero == 4){
            myReview Biography;
            Biography = new myReview(tiempo);
            return Biography;
        }        
        if(genero == 5){
            myReview Comedy;
            Comedy = new myReview(tiempo);
            return Comedy;
        }
        if(genero == 6){
            myReview Crime;
            Crime = new myReview(tiempo);
            return Crime;
        }        
        if(genero == 7){
            myReview Documentary;
            Documentary = new myReview(tiempo);
            return Documentary;
        }         
        if(genero == 8){
            myReview Drama;
            Drama = new myReview(tiempo);
            return Drama;
        }
        if(genero == 9){
            myReview Family;
            Family = new myReview(tiempo);
            return Family;
        }             
        if(genero == 10){
            myReview Fantasy;
            Fantasy = new myReview(tiempo);
            return Fantasy;
        }
        if(genero == 11){
            myReview FilmNoir;
            FilmNoir = new myReview(tiempo);
            return FilmNoir;
        }
        if(genero == 12){
            myReview History;
            History = new myReview(tiempo);
            return History;
        }
        if(genero == 13){
            myReview Horror;
            Horror = new myReview(tiempo);
            return Horror;
        }        
        if(genero == 14){
            myReview Music;
            Music = new myReview(tiempo);
            return Music;
        } 
        if(genero == 15){
            myReview Musical;
            Musical = new myReview(tiempo);
            return Musical;
        }
        if(genero == 16){
            myReview Mystery;
            Mystery = new myReview(tiempo);
            return Mystery;
        }
        if(genero == 17){
            myReview Romance;
            Romance = new myReview(tiempo);
            return Romance;
        }  
        if(genero == 18){
            myReview SciFi;
            SciFi = new myReview(tiempo);
            return SciFi;
        }             
        if(genero == 19){
            myReview Sport;
            Sport = new myReview(tiempo);
            return Sport;
        }         
        if(genero == 20){
            myReview Thriller;
            Thriller = new myReview(tiempo);
            return Thriller;
        }
        if(genero == 21){
            myReview War;
            War = new myReview(tiempo);
            return War;
        }
        else{
            myReview Western;
            Western = new myReview(tiempo);
            return Western;
        }  
    }
    
    
    
    public static int getTiempo() {
        return tiempo;
    }

    public static void setTiempo(int tiempo) {
        //SimEmisorReceptor.tiempo = tiempo+1;
        SimEmisorReceptor.tiempo = tiempo;
    }
    
    public static Double retornaValor(String mensaje, int posicion) {
        String[] items = mensaje.split(" ");
        List<String> itemList = Arrays.asList(items);
        return Double.parseDouble(itemList.get(posicion));
    }
    
    public static String FormatoFecha(int intFecha) {
        
        String fecha = String.valueOf(intFecha).substring(6,8)+"/"+String.valueOf(intFecha).substring(4,6)+"/"+String.valueOf(intFecha).substring(0,4);
        
        return fecha;
    }
      
    public static double formulaRanking(myReview s) {
        double valorRanking;       
       //((s.getC11()*s.getScore()+s.getC21())/alpha+alpha*(s.getC12()*s.getScore()+s.getC22())+s.getC13()*s.getScore()+s.getC23())/(alpha*C)
        valorRanking = s.getParcial()/(alpha*s.getNumeroReviews());
        
        return valorRanking;
    }
    
    public static void main(List<Review> reviews) {
        
        
        
        JSimSimulation simulation = null;
        JSimMessageBox box = null;
        Emisor sender;

        Action receiverT1;
        Adventure receiverT2;
        Animation receiverT3;
        Biography receiverT4;
        Comedy receiverT5;
        Crime receiverT6;
        Documentary receiverT7;
        Drama receiverT8;
        Family receiverT9;
        Fantasy receiverT10;
        FilmNoir receiverT11;
        History receiverT12;
        Horror receiverT13;
        Music receiverT14;
        Musical receiverT15;
        Mystery receiverT16;
        Romance receiverT17;
        SciFi receiverT18;
        Sport receiverT19;
        Thriller receiverT20;
        War receiverT21;
        Western receiverT22;

        //int tiempo = 19990419;

        try
        {
                System.out.println("Inicializando parametros de simulación...");
                //System.out.println("Total de reviews: " + reviews.size());
                
                setTiempo(reviews.get(0).getFecha());
                
                
                //System.exit(1);
                simulation = new JSimSimulation("Asynchronous Indirect Communication Simulation");
                box = new JSimMessageBox("Shared Message Box");
                sender = new Emisor("Emisor", simulation, box, reviews);
                receiverT1 = new Action("ReceptorT1", simulation, box,sender);
                sender.setReceiverT1(receiverT1);
                receiverT2 = new Adventure("ReceptorT2", simulation, box,sender);
                sender.setReceiverT2(receiverT2);
                receiverT3 = new Animation("ReceptorT3", simulation, box,sender);
                sender.setReceiverT3(receiverT3);
                receiverT4 = new Biography("ReceptorT4", simulation, box,sender);
                sender.setReceiverT4(receiverT4);
                receiverT5 = new Comedy("ReceptorT5", simulation, box,sender);
                sender.setReceiverT5(receiverT5);
                receiverT6 = new Crime("ReceptorT6", simulation, box,sender);
                sender.setReceiverT6(receiverT6);
                receiverT7 = new Documentary("ReceptorT7", simulation, box,sender);
                sender.setReceiverT7(receiverT7);
                receiverT8 = new Drama("ReceptorT8", simulation, box,sender);
                sender.setReceiverT8(receiverT8);
                receiverT9 = new Family("ReceptorT9", simulation, box,sender);
                sender.setReceiverT9(receiverT9);
                receiverT10 = new Fantasy("ReceptorT10", simulation, box,sender);
                sender.setReceiverT10(receiverT10);
                receiverT11 = new FilmNoir("ReceptorT11", simulation, box,sender);
                sender.setReceiverT11(receiverT11);
                receiverT12 = new History("ReceptorT12", simulation, box,sender);
                sender.setReceiverT12(receiverT12);
                receiverT13 = new Horror("ReceptorT13", simulation, box,sender);
                sender.setReceiverT13(receiverT13);
                receiverT14 = new Music("ReceptorT14", simulation, box,sender);
                sender.setReceiverT14(receiverT14);
                receiverT15 = new Musical("ReceptorT15", simulation, box,sender);
                sender.setReceiverT15(receiverT15);
                receiverT16 = new Mystery("ReceptorT16", simulation, box,sender);
                sender.setReceiverT16(receiverT16);
                receiverT17 = new Romance("ReceptorT17", simulation, box,sender);
                sender.setReceiverT17(receiverT17);
                receiverT18 = new SciFi("ReceptorT18", simulation, box,sender);
                sender.setReceiverT18(receiverT18);
                receiverT19 = new Sport("ReceptorT19", simulation, box,sender);
                sender.setReceiverT19(receiverT19);
                receiverT20 = new Thriller("ReceptorT20", simulation, box,sender);
                sender.setReceiverT20(receiverT20);
                receiverT21 = new War("ReceptorT21", simulation, box,sender);
                sender.setReceiverT21(receiverT21);
                receiverT22 = new Western("ReceptorT22", simulation, box,sender);
                sender.setReceiverT22(receiverT22);


                simulation.message("Activando los procesos...");
                sender.activate(0.0);
                receiverT1.activate(0.0);
                receiverT2.activate(0.0);
                receiverT3.activate(0.0);
                receiverT4.activate(0.0);
                receiverT5.activate(0.0);
                receiverT6.activate(0.0);
                receiverT7.activate(0.0);
                receiverT8.activate(0.0);
                receiverT9.activate(0.0);
                receiverT10.activate(0.0);
                receiverT11.activate(0.0);
                receiverT12.activate(0.0);
                receiverT13.activate(0.0);
                receiverT14.activate(0.0);
                receiverT15.activate(0.0);
                receiverT16.activate(0.0);
                receiverT17.activate(0.0);
                receiverT18.activate(0.0);
                receiverT19.activate(0.0);
                receiverT20.activate(0.0);
                receiverT21.activate(0.0);
                receiverT22.activate(0.0);

                simulation.message("Comienza la simulación >>> ");

                while ((simulation.getCurrentTime() < 100) && (simulation.step() == true))
                        ;
        } // try
        catch (JSimException e)
        {
                //e.printStackTrace();
                e.printComment(System.err);
        } // catch
        finally
        {
                simulation.shutdown();
        } // finally
    }
}
