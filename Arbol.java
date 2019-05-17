import java.util.*;

class Arbol{
    ArrayList<Nodo> inicio;

    Arbol(){
	this.inicio = new ArrayList<Nodo>();
    }

    Arbol(Nodo n){
	ArrayList<Nodo> aux;

	aux = new ArrayList<Nodo>();
	aux.add(n);
	this.inicio = aux;
    }
    
    Arbol(ArrayList<Nodo> cadena){
	this.inicio = cadena;
    }

    Arbol(String r){
	ArrayList<Nodo> aux;
	char[] cadena;
	ArrayList<Character> auxiliar;
	Character a, b, s, ca, cc;
	int tam, lon, rec, rec2, i;
	Nodo n;
	String t;
	Arbol arb, arbaux;

	lon = r.length();
	cadena = r.toCharArray();
	b = new Character(' ');
	s = new Character('+');
	ca = new Character('(');
	cc = new Character(')');
	auxiliar = new ArrayList<Character>();
	for(i=0;i<lon;i++){
	    a = new Character(cadena[i]);
	    if(!a.equals(b)){
		auxiliar.add(a);
	    }
	}
	tam = auxiliar.size();
	aux = new ArrayList<Nodo>();
	if(tam==0){
	}
	else{
	    a = auxiliar.get(0);
	    if(tam==1){
		n = new Nodo(a);
		aux.add(n);
	    }
	    else{
		rec = 1;
		while((rec<tam)&&(!s.equals(auxiliar.get(rec)))){
		    if(ca.equals(auxiliar.get(rec))){
			rec2 = rec;
			while((rec2<tam)&&(!cc.equals(auxiliar.get(rec2)))){rec2++;}
			rec = rec2;
		    }
		    else{
			rec++;
		    }
		}
		if((rec==tam)|(rec==tam-1)){
		    t = " ";
		    for(i=1;i<tam;i++){
			if((i==1)&(ca.equals(auxiliar.get(i)))){
			    if(cc.equals(auxiliar.get(tam-1))){
				tam = tam - 1;
			    }
			}
			else{
			    t = t + auxiliar.get(i).toString();
			}
		    }
		    arbaux = new Arbol(t);
		    n = new Nodo(a,arbaux);
		    aux.add(n);
		}
		else{
		    if(rec==1){
			t = " ";
			for(i=2;i<tam;i++){
			    if((i==1)&(ca.equals(auxiliar.get(i)))){
				if(cc.equals(auxiliar.get(tam-1))){
				    tam = tam - 1;
				}
			    }
			    else{
				t = t + auxiliar.get(i).toString();
			    }
			}
			arb = new Arbol(t);
			aux = arb.inicio();
			n = new Nodo(a);
			aux.add(n);
		    }
		    else{
			t = " ";
			for(i=rec+1;i<tam;i++){
			    t = t + auxiliar.get(i).toString();
			}
			arb = new Arbol(t);
			t = " ";
			for(i=1;i<rec;i++){
			    if((i==1)&(ca.equals(auxiliar.get(i)))){
				if(cc.equals(auxiliar.get(rec-1))){
				    rec = rec - 1;
				}
			    }
			    else{
				t = t + auxiliar.get(i).toString();
			    }
			}
			arbaux = new Arbol(t);
			n = new Nodo(a,arbaux);
			aux = arb.inicio();
			aux.add(n);
		    }
		}
	    }
	}
	this.inicio = aux;
    }

    public String toString(){
	String s;
	s = "El arbol es: " + this.salida();
	return s;
    }

    boolean equals(Arbol arb){
	boolean igual;
	ArrayList<Nodo> aux1, aux2;
	Arbol hijo1, hijo2;
	Character valor1, valor2;
	boolean esta1, esta2;

	if((this.arbolVacio())&(arb.arbolVacio())){
	    igual = true;
	}
	else{
	    if((this.arbolVacio())|(arb.arbolVacio())){
		igual = false;
	    }
	    else{
		aux1 = this.inicio();
		aux2 = arb.inicio();
		esta1 = true;
		for(Nodo n:aux1){
		    if(esta1){
			esta2 = false;
			valor1 = n.accion();
			hijo1 = n.hijo();
			for(Nodo t:aux2){
			    if(!esta2){
				valor2 = t.accion();
				if(valor1.equals(valor2)){
				    hijo2 = t.hijo();
				    if((hijo1==null)&(hijo2==null)){
					esta2 = true;
				    }
				    else{
					if((hijo1==null)|(hijo2==null)){
					}
					else{
					    if(hijo1.equals(hijo2)){
						esta2 = true;
					    }
					}
				    }
				}
			    }
			}
			if(!esta2){
			    esta1 = false;
			}
		    }
		}
		if(esta1){
		    for(Nodo t:aux2){
			if(esta1){
			    esta2 = false;
			    valor2 = t.accion();
			    hijo2 = t.hijo();
			    for(Nodo n:aux1){
				if(!esta2){
				    valor1 = n.accion();
				    if(valor1.equals(valor2)){
					hijo1 = n.hijo();
					if((hijo1==null)&(hijo2==null)){
					    esta2 = true;
					}
					else{
					    if((hijo1==null)|(hijo2==null)){
					    }
					    else{
						if(hijo1.equals(hijo2)){
						    esta2 = true;
						}
					    }
					}
				    }
				}
			    }
			    if(!esta2){
				esta1 = false;
			    }
			}
		    }
		}
		igual = esta1;
	    }
	}
	return igual;
    }

    String salida(){
	String s;
	int tam;
	ArrayList<Nodo> aux, aux2;
	Arbol hijo;

	s = "";
	aux = this.inicio();
	tam = aux.size();
	if(tam==0){
	    s = s + "vacio";
	}
	else{
	    if (tam==1) {
		hijo = aux.get(0).hijo();
		if(hijo!=null){
		    aux2 = hijo.inicio();
		    if(aux2.size()>1){
			s = s + aux.get(0).toString()+"("+hijo.salida()+")";
		    }
		    else{
			s = s + aux.get(0).toString()+hijo.salida();
		    }
		}
		else{
		    s = s + aux.get(0).toString();
		}
	    }
	    else {
		for (int i=0;i<tam-1;i++) {
		    hijo = aux.get(i).hijo();
		    if(hijo!=null){
			aux2 = hijo.inicio();
			if(aux2.size()>1){
			    s = s + aux.get(i).toString()+"("+hijo.salida()+")"+"+";
			}
			else{
			    s = s + aux.get(i).toString()+hijo.salida()+"+";
			}
		    }
		    else{
			s = s + aux.get(i).toString()+"+";
		    }
		}
		hijo = aux.get(tam-1).hijo();
		if(hijo!=null){
		    aux2 = hijo.inicio();
		    if(aux2.size()>1){
			s = s + aux.get(tam-1).toString()+"("+hijo.salida()+")";
		    }
		    else{
			s = s + aux.get(tam-1).toString()+hijo.salida();
		    }
		}
		else{
		    s = s + aux.get(tam-1).toString();
		}
	    }
	}
	return s;
    }

    void prefijo(Character a){
	Nodo aux;
	ArrayList<Nodo> principio;
	Arbol auxiliar;

	principio = this.inicio();
	auxiliar = new Arbol(principio);
	aux = new Nodo(a,auxiliar);;
	principio = new ArrayList<Nodo>();
	principio.add(aux);
	this.inicio = principio;
    }

    void add(Character a){
	Arbol aux;
	Nodo principio;

	principio = new Nodo(a);
	aux = new Arbol(principio);
	this.concatenar(aux);
    }

    void concatenar(Arbol t){
	ArrayList<Nodo> aux, auxiliar;

	aux = this.inicio();
	auxiliar = t.inicio();
	for(Nodo n:auxiliar){
	    aux.add(n);
	}
	this.inicio = aux;
    }

    CTrazas trazas(){
	CTrazas conjunto;
	ArrayList<Nodo> aux;
	Arbol hijo;
	Character valor;
	CTrazas auxiliar;

	aux = this.inicio();
	conjunto = new CTrazas();
	if(aux.isEmpty()){
	    conjunto.add('0');
	}
	else{
	    for(Nodo n:aux){
		auxiliar = new CTrazas();
		hijo = n.hijo();
		valor = n.accion();
		if(hijo==null){
		    auxiliar.add(valor);
		}
		else{
		    auxiliar = hijo.trazas();
		    auxiliar.prefijo(valor);
		}
		conjunto.add(auxiliar);
	    }
	}
	return conjunto;
    }

    boolean equivalenteTrazas(Arbol arb){
	boolean igual;
	CTrazas aux1, aux2;

	aux1 = this.trazas();
	aux2 = arb.trazas();
	igual = aux1.equals(aux2);
	return igual;
    }

    boolean bisimilares(Arbol arb){
	boolean igual;
	boolean aux1, aux2;
	ArrayList<Nodo> lista1, lista2;

	lista1 = this.inicio();
	lista2 = arb.inicio();
	if((lista1.isEmpty())&(lista2.isEmpty())){
	    igual = true;
	}
	else{
	    if((lista1.isEmpty())|(lista2.isEmpty())){
		igual = false;
	    }
	    else{
		aux1 = this.procEquivalentes(arb);
		aux2 = arb.procEquivalentes(this);
		igual = aux1 & aux2;
	    }
	}
	return igual;
    }

    boolean procEquivalentes(Arbol arb){
	boolean cierto;
	ArrayList<Nodo> aux1, aux2;
	boolean esta;

	cierto = true;
	aux1 = this.inicio();
	aux2 = arb.inicio();
	for(Nodo n:aux1){
	    if(cierto){
		esta = false;
		for(Nodo t:aux2){
		    if(n.equals(t)){
			esta = true;
		    }
		}
		if(!esta){
		    cierto = false;
		}
	    }
	}
	return cierto;
    }

    boolean arbolVacio(){
	boolean vacio;
	ArrayList<Nodo> aux;
	if(this==null){
	    vacio = true;
	}
	else{
	    if(this.inicio()==null){
		vacio = true;
	    }
	    else{
		aux = this.inicio();
		vacio = aux.isEmpty();
	    }
	}
	return vacio;
    }

    CAcciones conjuntoDeAcciones(){
	CAcciones aux;

	aux = new CAcciones(this);
	return aux;
    }

    boolean enConjuntoDeAcciones(String s){
	boolean cont;
	CAcciones aux1, aux2;

	aux1 = this.conjuntoDeAcciones();
	aux2 = new CAcciones(s);
	cont = aux1.contenidoEn(aux2);
	return cont;
    }

    boolean enConjuntoDeAcciones(Arbol arb){
	boolean cont;
	String s;

	s = arb.salida();
	cont = this.enConjuntoDeAcciones(s);
	return cont;
    }

    boolean mismoConjuntoDeAcciones(Arbol arb){
	boolean igual;
	CAcciones aux1, aux2;

	aux1 = this.conjuntoDeAcciones();
	aux2 = arb.conjuntoDeAcciones();
	igual = aux1.equals(aux2);
	return igual;
    }

    ArrayList<Nodo> inicio(){
	return this.inicio;
    }
}