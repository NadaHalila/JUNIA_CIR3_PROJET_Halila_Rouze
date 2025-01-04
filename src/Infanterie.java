import java.util.List;

class Infanterie extends Unite  {
    protected String TypeInfanterie;

    public Infanterie(List<Unite> unites, String nom, int cout, String nom1, int cout1, TypeInfanterie type) {
        super(unites, nom, cout, nom1, cout1);
        this.TypeInfanterie = String.valueOf(type);
    }

    @Override
    public String toString() {
        return "Infanterie : " +
                 TypeInfanterie + '-' +
                 nom + '(' +
                 cout +
                ')';
    }
}
enum TypeInfanterie {
    SOLDAT,
    LOURD,
    SPECIAL,
    CHEF
}