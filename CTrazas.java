import java.util.*;
    
class CTrazas implements Iterable<String>{
    HashSet<String> conjunto;

    CTrazas(){
	this.conjunto = new HashSet<String>();
    }

    CTrazas(Character a){
	HashSet<String> aux;

	aux = new HashSet<String>();
	aux.add(a.toString());
	this.conjunto = aux;
    }

    boolean equals(CTrazas conj){
	boolean igual;
	HashSet<String> aux1, aux2;

	igual = true;
	aux1 = this.conjunto;
	aux2 = conj.conjunto;
	for(String s:aux1){
	    if((igual)&(!aux2.contains(s))){
		igual = false;
	    }
	}
	if(igual){
	    for(String s:aux2){
		if((igual)&(!aux1.contains(s))){
		    igual = false;
		}
	    }
	}
	return igual;
    }

    public String toString(){
	String s;
	HashSet<String> aux;
	int tam, posicion;
	
	aux = this.conjunto();
	tam = aux.size();
	posicion = 0;
	s = "{";
	for (String r:aux) {
	    if (posicion<tam-1) {
		s = s + r + ",";
		posicion++;
	    }
	    else {
		s = s + r;
	    }
	}
	s = s + "}";
	return s;
    }

    public Iterator<String> iterator(){
	return conjunto.iterator();
    }

    void prefijo(Character a){
	HashSet<String> aux;
	
	aux = new HashSet<String>();
	for (String s:this.conjunto) {
	    aux.add(a+s);
	}
	aux.add(a.toString());
	this.conjunto = aux;
    }

    void add(Character a){
	CTrazas aux;

	aux = new CTrazas(a);
	this.add(aux);
    }

    void add(CTrazas c){
	HashSet<String> aux, aux2;
	
	aux = this.conjunto();
	aux2 = c.conjunto();
	for (String s:aux2) {
	    aux.add(s);
	}
	this.conjunto = aux;
    }

    HashSet<String> conjunto(){
	return this.conjunto;
    }
}