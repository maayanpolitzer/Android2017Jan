package com.company;

/**
 * Created by hackeru on 29/01/2017.
 */
public class Hall {

    private String movieName;
    private boolean[] seats;

    public Hall(String movie, int seatsAmount){
        movieName = movie;
        seats = new boolean[seatsAmount];   // {false, false, false, false}
        /*
        empty chair = false;
        occupied chair = true;
         */
    }

    public int ticketsBought(){

    }

    public int buyTicket(){

    }

    public boolean buyTicket(int seatNumber){

    }

    public boolean cancelTicket(int seatNumber){

    }

}
