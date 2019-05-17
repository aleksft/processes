import java.util.*;

class ListaArboles{

    ArrayList<Arbol> lista;

    ListaArboles(){
	this.lista = new ArrayList<Arbol>();
    }

    public String toString(){
	String s;
	int j = 0;

	if(lista.isEmpty()){
	    s = "No hay arboles";
	}
	else{
	    s = "Los arboles creados son:";
	    for(Arbol arb:this.lista){
		s = s + "\n" + j + ": "  + arb.salida();
		j++;
	    }
	}
	return s;
    }

    void add(Arbol arb){
	lista.add(arb);
    }

    Arbol get(int n){
	Arbol arb;

	arb = this.lista.get(n);
	return arb;
    }
}