package com.packages.linked_list;


public class LSLTaller {

    public NodeTaller head;

    public LSLTaller(){
        head = null;
    }

    public NodeTaller getHead(){
        return head;
    }

    public void setHead(NodeTaller head){
        this.head = head;
    }

    //Funciona para buscar si un exponente ya está dentro del polinomio.
    //Si encuentro el exponente, guardo ese nodo en q.
    //Si nunca lo encuentro, q se queda en null.
    public NodeTaller findExponentLSL(int exponente){
        NodeTaller p = head;
        NodeTaller q = null;
        boolean sw = false; //Todavia no se ha encontrado

        while (p != null && !sw) {
            if (p.exponente == exponente) {
                sw = true;
                q = p;
            } else {
                p = p.link; //Esto es para que vaya al otro nodo
            }
        }
        return q; //Si encuentra el valor devuelve q, sino, devuelve null (q es la direccion del nodo)
    }

    public void createBeginLSL(int coeficiente, int exponente){

        //Pendiente preguntar al profe estas validaciones extra
        if (exponente < 0) {
            System.out.println("El exponente no puede ser negativo");
            return;
        }

        if (coeficiente == 0) {
            System.out.println("El coeficiente no puede ser cero");
            return;
        }

        NodeTaller r = findExponentLSL(exponente); //r es una variable auxiliar que guardará
                                                   //la información del metodo. (Dirección)

        if (r == null) {
            NodeTaller p = new NodeTaller(); //Se crea un nuevo nodo, como un nodo auxiliar

            p.coeficiente = coeficiente;
            p.exponente = exponente;
            p.link = head; //El nodo nuevo queda apuntando al que era la cabeza
            head = p; //La cabeza ahora apunta al nuevo nodo creado que es p

            System.out.println("Término agregado correctamente");
        } else {
            System.out.println("El exponente " + exponente + " ya existe en el polinomio");
        }
    }

    public void showLSLTaller() {
        NodeTaller p = head;
        
        if (p == null){
            System.out.println("Aún no hay polinomios creados.");
        } else {
            while (p != null) {

                int coeficiente = p.coeficiente;

                if (p != head){
                    if (coeficiente > 0) {
                        System.out.print(" + ");
                    } else {
                        System.out.print(" - ");
                        coeficiente = coeficiente *-1; //
                    }
                }
                if (p.exponente == 0) {
                    System.out.print(coeficiente);
                }else if (p.exponente == 1) {
                    System.out.print(coeficiente + "x");
                }else{
                    System.out.print(coeficiente + "x^" + p.exponente);
                }
                p =p.link;

            }
            System.out.println();     
        }
    }

    //Organiza el polinomio de mayor a menor exponente.
    public void organizeLSLTaller(){
        NodeTaller p; // Variable auxiliar para recorrer la lista
        boolean sw = true; //variable de control para el ordenamiento, inicialmente se asume que no está ordenada

        if (head != null) { //Si la lista no está vacía, se procede a ordenar
            while (sw) {
                sw = false; // Se asume que la lista está ordenada, si se realiza un intercambio, se marcará como no ordenada
                p = head;

                while (p != null && p.link != null) {
                    if (p.exponente < p.link.exponente) {
                        int auxCoeficiente = p.coeficiente;
                        int auxExponente = p.exponente;

                        p.coeficiente = p.link.coeficiente;
                        p.exponente = p.link.exponente;

                        p.link.coeficiente = auxCoeficiente;
                        p.link.exponente = auxExponente;

                        sw = true; // Si se realizó un intercambio, se marca que la lista aún no está ordenada
                    }

                    p = p.link;
                }
            }
        }
    }

    //Modifica el coeficiente de un término dado su exponente. 
    //Si el exponente no existe, muestra un mensaje indicando que no se encontró el término.
    public void modifyPolinomio(int nuevoCoeficiente, int exponente){
        NodeTaller r = findExponentLSL(exponente);

        if (r != null) {
            r.coeficiente = nuevoCoeficiente;
            System.out.println("Término modificado correctamente");
        } else {
            System.out.println("El exponente " + exponente + " no existe en el polinomio");
        }
    }

    //Elimina un término del polinomio dado su exponente.
    public void deletePolinomio(int exponente){
        NodeTaller p = head;
        NodeTaller q = null;
        boolean sw = false;

        while (p != null && !sw) {
            if (p.exponente == exponente) {
                sw = true;
            } else {
                q = p;
                p = p.link;
            }
        }

        if (sw) {
            if (q == null) { // El nodo a eliminar es la cabeza
                head = p.link;
            } else { // El nodo a eliminar no es la cabeza
                q.link = p.link;
            }
            System.out.println("Término eliminado correctamente");
        } else {
            System.out.println("El exponente " + exponente + " no existe en el polinomio");
        }
    }


    public void addTermOrdered(int coeficiente, int exponente) {
        NodeTaller r = findExponentLSL(exponente);

        if (r != null) {
            System.out.println("El exponente" + exponente + " ya existe en el polinomio");
            return;
        }

        NodeTaller p = new NodeTaller();
        p.coeficiente = coeficiente;
        p.exponente = exponente;
        p.link = null;

        if (head == null || exponente > head.exponente) {
            p.link = head;
            head = p;
        } else {
            NodeTaller q = head;

            while (q.link != null && q.link.exponente > exponente) {
                q = q.link;
            }
            p.link = q.link;
            q.link = p;
        }
    }
                
    public LSLTaller addPolinomios(LSLTaller g){
        LSLTaller result = new LSLTaller();

        NodeTaller p = head;

        while (p != null) {
            result.addTermOrdered(p.coeficiente, p.exponente);
            p = p.link;
        }

        p = g.getHead();

        while (p != null) {
            NodeTaller r = result.findExponentLSL(p.exponente);

            if (r != null) {
                r.coeficiente = r.coeficiente + p.coeficiente;

                if (r.coeficiente == 0) {
                    result.deletePolinomio(r.exponente);
            }
            } else {
                result.addTermOrdered(p.coeficiente, p.exponente);
            }

            p = p.link;
        }

        return result;
    }
    
    public LSLTaller subtractPolinomios(LSLTaller g){
        LSLTaller result = new LSLTaller();

        NodeTaller p = head;

        while (p != null) {
            result.addTermOrdered(p.coeficiente, p.exponente);
            p = p.link;
        }

        p = g.getHead();

        while (p != null) {
            NodeTaller r = result.findExponentLSL(p.exponente);

            if (r != null) {
                r.coeficiente = r.coeficiente - p.coeficiente;

                if(r.coeficiente == 0){
                    result.deletePolinomio(r.exponente);
                }
            } else {
                result.addTermOrdered(-p.coeficiente, p.exponente);
            }

            p = p.link;
        }

        return result;
    }

    public double evaluatePolinomio(int a) {
        double result = 0;
        NodeTaller p = head;

        while (p != null) {
            result = result + p.coeficiente * Math.pow(a, p.exponente);
            p = p.link;
        }

        return result;
    }
}
