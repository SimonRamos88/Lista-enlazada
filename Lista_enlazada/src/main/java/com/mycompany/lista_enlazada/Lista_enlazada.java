
package com.mycompany.lista_enlazada;


public class Lista_enlazada {
    private Node head;
    private Node tail;
    private int size;
    
    public Lista_enlazada(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public Lista_enlazada clean(){
        this.head = null;
        this.tail = null;
        this.size = 0;
        return this;
    }
    
    
    public void setTail(Node tail){
        this.tail = tail;
    }
    
    public Node getTail(){
        return this.tail;
    }
    
    public void setHead(Node head){
        this.head = head;
    }
    
    public Node getHead(){
        return this.head;
    }
    
    public int size(){
        return this.size;
    }
    
    public Lista_enlazada unir(Lista_enlazada list2){       
        this.size = this.size + list2.size();
        //Si esta lista esta vacia, la union es la lista 2
        if(empty()){
            this.head = list2.getHead();
            this.tail = list2.getTail();
        }else{
            // obtenemos la cola de lista 1 y que esta apunte a la cabeza de lista 2
            this.tail.setNext(list2.getHead());
            // Verificamos que la lista que vamos a unir no esté vacía
            if(list2.getHead()!=null){
                // la cola de lista 1 ahora va a hacer la de lista 2
                this.tail = list2.getTail();
            }            
            
        }
        
        return this;
        
    }
    
    
    public boolean empty(){
        return this.head == null;
    }
    
    
    public void pushFront(int el){
        Node n = new Node(el);  
        n.setNext(this.head); 
        this.head = n;
        if(this.tail == null){
            this.tail = head;
        }
        this.size += 1;
        
    }
    
    public void pushBack( int el){
        /*
        SIN TAIL (lineal)
        Node n = new Node(el);
        if(empty()){
            this.head= n;
        }else{
            Node aux = this.head;           
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(n);
        
        }*/ 
        // CON TAIL (Constante) 
        Node n = new Node(el);
        if(empty()){
            this.head = n;
            this.tail = this.head;
        }else{
            this.tail.setNext(n);
            this.tail = n;
        }
        this.size += 1;
    }
    
    public int popBack(){       
        /*
        SIN TAIL (lineal)
        int cad = 0;
        if(!empty()){
            Node aux = this.head;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            cad = (int) aux.getData();
        }
        return cad;*/
        // CON TAIL (lineal)
        int cad = 0;
        if(!empty()){
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                Node aux = this.head;
                while(aux.getNext() != this.tail){
                    aux = aux.getNext();
                }
                cad = (int) aux.getNext().getData();
                aux.setNext(null);
                this.tail = aux;
            }
            this.size -= 1;
        }
        return cad;
    }
    
    public int popFront(){
        int cad = 0;
        if(!empty()){
            cad = (int) this.head.getData();
            this.head = this.head.getNext();
            if(this.head == null){
                this.tail = null;
            }
        this.size -= 1;
        }
        
        return cad;
    }    
    
    // Hacer pop en una posicion específica
    public int getAt(int index){
        int res = 0;
        if(!empty() && index < this.size){
            int i = 0;
            Node aux = this.head;
            while(i < index){
                aux = aux.getNext();
                i+=1;
            }
            res = aux.getData();
        }
        return res;
    }
    
    //Nos devuelve la "posicion" en la que el elemento buscado esta
    // Si el elemento no está, entonces i = size();
    public int buscar(int element){
        int i= 0;
        Node n = this.head;
        while(n!=null && n.getData() != element){
            i ++;
            n = n.getNext();
        }
        
        return i;
    }
    
    public void StringTo(){
        String cad = "[";
        if(empty()){
            cad += " ]";
        }else{
            Node n = this.head;
            while(n.getNext() != null){
                cad += n.getData() + " ";
                n = n.getNext();
            }
            cad += n.getData() + "]";
        }     
        System.out.println(cad);
    }
    
    
    public static void main(String[] args) {
        Lista_enlazada list = new Lista_enlazada();
        list.StringTo();
        //list.pushFront(-1);
        list.pushBack(2);
        list.pushBack(3);
        list.StringTo();
        list.pushFront(1);
        list.StringTo();
        list.getAt(0);
        list.StringTo();
        
        /* BUSCAR
            System.out.println("Buscando: 6");
            System.out.println(list.buscar(6));
        */

        /*LIMPIAR LA LISTA
            list.clean();
            list.StringTo();
        */
        /*UNIR LISTAS
             Lista_enlazada list2 = new Lista_enlazada();
            //list2.pushBack(4);
            //list2.pushBack(5);
            System.out.print("Lista 1: ");
            System.out.println("+" + list.size());
            list.clean();
            System.out.println("-" + list.size());
            System.out.println(list.size());
            list.StringTo();
            System.out.print("Lista 2: " );
            list2.StringTo();
            System.out.print("Union: ");
            list2.unir(list);
            list2.StringTo();       
            list.popBack();
            list2.StringTo();
        */
       
        /*
        list.popBack();
        list.StringTo();
        list.popFront();
        list.StringTo();
        //list.popFront();
        list.popBack();
        list.StringTo();*/
    }

}


