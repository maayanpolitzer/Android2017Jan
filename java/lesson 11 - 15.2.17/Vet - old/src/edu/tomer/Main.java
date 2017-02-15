package edu.tomer;

public class Main {

    public static void main(String[] args) {

        Vet v1 = new Vet();

        v1.addNewClient(new Client("maayan", "052-111111"));
        v1.addNewClient(new Client("Yossi", "052-222222"));
        v1.addNewClient(new Client("Moshe", "052-333333"));

        v1.getClientById(2).addNewPet(new Animal("Snake", "Shimon"));
        v1.getClientById(2).addNewPet(new Animal("Dog", "Bree"));

        v1.getClientById(2).removeAds();

        //v1.sendAd("5% off");

        v1.callForVaccin("Cat");

        System.out.println(v1.getClientById(2));


    }
}
