package com.company;


public class Hall {

    private String name;
    private boolean[] seats;
    private int counter;

    public Hall(String movieName, int numOfSeats){
        name = movieName;
        seats = new boolean[numOfSeats];
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < seats.length; i++){
            System.out.print(seats[i]);
            if (i < seats.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int buyTicket(){
        for (int i = 0; i < seats.length; i++){
            if(!seats[i]) {     //if (seats[i] == false)
                seats[i] = true;
                counter++;
                return i;
            }
        }
        return -1;
    }

    public boolean buyTicket(int desiredSeat){
        if (desiredSeat < 0 || desiredSeat >= seats.length){
            return false;
        }
        if (!seats[desiredSeat]){
            seats[desiredSeat] = true;
            counter++;
            return true;
        }
        return false;
    }

    public boolean cancelTicket(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= seats.length) {
            return false;
        }
        if (seats[seatNumber]) {     // same as: if(seats[seatNumber] == true){
            seats[seatNumber] = false;
            counter--;
            return true;
        }
        return false;
    }

    public int getTicketsBought(){
        return counter;
    }

    public int buyGroup(int groupAmount){
        for (int i = 0; i <= seats.length - groupAmount; i++){
            if (!seats[i]){
                int freeSeats = getAvailableInRow(i,groupAmount);
                if (freeSeats == groupAmount){
                    buyTickets(i, groupAmount);
                    return i;
                }else{
                    i += freeSeats;
                }
            }
        }
        return -1;
    }

    private void buyTickets(int index, int amount){
        for (int i = index; i < index + amount; i++){
            seats[i] = true;
            counter++;
        }
    }

    private int getAvailableInRow(int index, int ticketsAmount){
        int counter = 0;
        for (int i = index; i < index + ticketsAmount; i++){
            if (!seats[i]){
                counter++;
            }else{
                return counter;
            }
        }
        return ticketsAmount;
    }

}
