import java.util.*;

class CAcciones{

    HashSet<Character> acciones;

    CAcciones(){
	this.acciones = new HashSet<Character>();
    }

    CAcciones(String s){
	HashSet<Character> aux;
	int tam;
	Character a;
	Character m, ca, cc;

	m = new Character('+');
	ca = new Character('(');
	cc = new Character(')');
	aux = new HashSet<Character>();
	tam = s.length();
	for(int i=0;i<tam;i++){
	    a = new Character(s.charAt(i));
	    if((!a.equals(m))&(!a.equals(ca))&(!a.equals(cc))){
		if(!aux.contains(a)){
		    aux.add(a);
		}
	    }
	}
	this.acciones = aux;
    }

    CAcciones(Arbol arb){
	String s;
	CAcciones aux;
	HashSet<Character> aux2;
	ArrayList<Nodo> lista;

	lista = arb.inicio();
	if(lista.isEmpty()){
	    aux = new CAcciones();
	}
	else{
	    s = arb.salida();
	    aux = new CAcciones(s);
	}
	aux2 = aux.cAcciones();
	this.acciones = aux2;
    }

    public String toString(){
	String s;
	HashSet<Character> aux;
	int tam, cont;

	s = "El conjunto de acciones es: ";
	aux = this.cAcciones();
	tam = aux.size();
	cont = 0;
	if(aux.isEmpty()){
	    s = s + "vacio";
	}
	else{
	    s = s + "{";
	    for(Character a:aux){
		if(cont<tam-1){
		    s = s + a.toString() + ", ";
		    cont++;
		}
		else{
		    s = s + a.toString();
		}
	    }
	    s = s + "}";
	}
	return s;
    }

    boolean equals(CAcciones aux){
	boolean igual;
	boolean cont1, cont2;

	cont1 = this.contenidoEn(aux);
	cont2 = aux.contenidoEn(this);
	igual = cont1 & cont2;
	return igual;
    }

    boolean contenidoEn(CAcciones conjunto){
	boolean cont;
	HashSet<Character> aux, aux2;

	cont = true;
	aux = this.cAcciones();
	aux2 = conjunto.cAcciones();
	if(!aux.isEmpty()){
	    for(Character a:aux){
		if(cont){
		    if(!aux2.contains(a)){
			cont = false;
		    }
		}
	    }
	}
	return cont;
    }

    HashSet<Character> cAcciones(){
	return this.acciones;
    }
}