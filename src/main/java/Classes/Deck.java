package Classes;

import java.util.LinkedList;
public class Deck {
    private LinkedList<Chambre> cardLinkedList = new LinkedList<Chambre>();
    public Deck(){

        // Creation de chambre, et seulement de Chambre
        for(int i=0;i<=19;i++){
            cardLinkedList.add(new ChambreClassiqueLitSimple(i,1,true,60));
        }
        for(int i=20;i<=40;i++){
            cardLinkedList.add(new ChambreClassiqueLitDouble(i,2,true,70));
        }
        for (int i=100;i<=109;i++){
            cardLinkedList.add(new ChambreDeLuxeLitSimple(i,3,true,100));
        }
        for(int i=110;i<=120;i++){
            cardLinkedList.add(new ChambreDeLuxeLitDouble(i,4,true,110));
        }
    }


    @Override
    public String toString() {
        return cardLinkedList.toString();
    }
}
