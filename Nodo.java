class Nodo{
    Character accion;
    Arbol hijo;

    Nodo(){
	this.accion = null;
	this.hijo = new Arbol();
    }

    Nodo(Character a){
	this.accion = a;
	this.hijo = null;
    }

    Nodo(Character a, Arbol b){
	this.accion = a;
	this.hijo = b;
    }

    public String toString(){
	String s;
	Character a;
	a = this.accion();
	s = a.toString();
	return s;
    }

    boolean equals(Nodo n){
	boolean igual;
	Arbol hijo1, hijo2;
	Character a, b;

	if((this==null)&(n==null)){
	    igual = true;
	}
	else{
	    if((this==null)|(n==null)){
		igual = false;
	    }
	    else{
		a = this.accion();
		b = this.accion();
		if(a.equals(b)){
		    if((this.hijo()==null)&(n.hijo()==null)){
			igual = true;
		    }
		    else{
			if((this.hijo()==null)|(n.hijo()==null)){
			    igual = false;
			}
			else{
			    hijo1 = this.hijo();
			    hijo2 = n.hijo();
			    igual = (a.equals(b))&(hijo1.equals(hijo2));
			}
		    }
		}
		else{
		    igual = false;
		}
	    }
	}
	return igual;
    }

    Character accion(){
	return this.accion;
    }

    Arbol hijo(){
	return this.hijo;
    }
}