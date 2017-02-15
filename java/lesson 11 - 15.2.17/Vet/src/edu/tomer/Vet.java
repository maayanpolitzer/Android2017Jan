package edu.tomer;


import java.util.ArrayList;

public class Vet {

    private ArrayList<Client> clients;

    public Vet(){
        clients = new ArrayList<>();
    }

    public void addNewClient(Client newClient){
        clients.add(newClient);
    }

    public Client getClientById(int clientID){
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).getId() == clientID){
                return clients.get(i);
            }
            /*
            Client c = clients.get(i);
            if (c.getId() == clientID){
                return c;
            }
            */
        }
        return null;
    }

    public void sendAd(String message){
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).isAds()){
                System.out.println("Message \"" + message + "\" was sent to " + clients.get(i).getName());
            }
        }
    }

    public void callForVaccin(){
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).hasType()){
                System.out.println(clients.get(i).getName() + " come FAST!!!");
            }
        }
    }

    /*
    public ArrayList<Client> getClients(){
        return new ArrayList<>(clients);
    }
    */

}
