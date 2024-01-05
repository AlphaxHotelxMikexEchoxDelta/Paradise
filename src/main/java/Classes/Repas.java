package Classes;

public enum Repas {FormuleContinentale(1,"Formule continentale","_Pain frais, croissants, confitures, beurre\n_Jus d'orange fraîchement pressé\n_Café ou thé",10),
    PetitDejeunerAméricain(1,"Petit Déjeuner Américain","_Œufs brouillés ou au plat\n_Bacon ou saucisses\n_Pommes de terre rissolées\n_Pain grillé\n_Jus de fruits\n_Café ou thé",15),
    PetitDejeunerSanté(1,"Petit Déjeuner Santé","_Yaourt nature avec des fruits frais\n_Muesli ou granola\n_Smoothie aux fruits\n_Pain complet ou bagel\n_Café ou thé",12),
    MenuduChef(2,"Menu du Chef","_Entrée : Salade de chèvre chaud\n_Plat principal : Filet de saumon grillé avec riz pilaf et légumes\n_Dessert : Tarte au citron",25),
    DejeunerRapide(2,"Déjeuner Rapide","_Sandwich au poulet grillé avec frites\n_Boisson gazeuse",12),
    OptionVegetarienne(2,"Option Végétarienne","_Quinoa aux légumes grillés\n_Salade de lentilles\n_Dessert : Panna cotta à la mangue",18 ),
    MenuGourmet(3,"Menu Gourmet","_Amuse-bouche : Velouté de champignons\n_Entrée : Risotto aux fruits de mer\n_Plat principal : Filet mignon de bœuf avec purée de pommes de terre et asperges\n_Dessert : Fondant au chocolat",40),
    DinerThematique(3,"Dîner Thématique","Cuisine italienne :\n_Antipasti\n_Pizza margherita\n_Tiramisu",30),
    DinerLeger(3,"Dîner Léger","_Salade de quinoa aux légumes grillés\n_Poisson poché avec sauce au citron\n_Sorbet aux fruits",28)
    ;
    private int type;//1:Petit Déjeuner;  2:Déjeuner;  3:dîner
    private String nomMenue;
    private String menu;
    private int prix;

    Repas(int type,String nomMenue,String menu,int prix) {
        this.type = type;
        this.nomMenue=nomMenue;
        this.menu=menu;
        this.prix=prix;
    }

    public int getType() {
        return type;
    }

    public String getnomMenue() {
        return nomMenue;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrix() {
        return prix;
    }

    @Override
     public String toString() {
        return nomMenue+"\n"+menu+"\n_Prix: "+prix+" € par personne";
    }
}

