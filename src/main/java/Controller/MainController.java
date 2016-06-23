/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainView;

/**
 *
 * @author Peter
 */
public class MainController {
    public static void main(String[] args) {
        hoofdMenu();
    }
    
    public static void hoofdMenu(){
        MainView view = new MainView();
        view.readMain();
        switch (view.getSelect()) {
            case 1:
                KlantController.startKeuze();
                break;
            case 2:
                new BestellingController().startKeuze();
                break;
            case 3:
                ArtikelController.startKeuze();
                break;            
            case 4:
                new AdresController().startKeuze();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Maak een keuze: 1, 2, 3, 4 of 0");
                break;
        }
        hoofdMenu(); //Infinite recursion klopt: dat is de bedoeling
    }
}
