import com.packages.arrays.*;
import com.packages.game.TriquiTaller;
import com.packages.linked_list.*;
import com.packages.strings.*;
import java.util.Scanner;

public class Main 
{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        String resp;
        do {
            System.out.println("Menú de opciones");
            System.out.println("0. Salir");
            System.out.println("1. Cadenas de caracteres");
            System.out.println("2. Vectores");
            System.out.println("3. Matrices");
            System.out.println("4. Registros");
            System.out.println("5. Lista Simplemente Ligada");
            System.out.println("6. Lista Simplemente Ligada Taller 1");
            System.out.println("7. Juego Triqui");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    System.out.println("Hasta pronto");
                    break;
                case "1":
                    menuString();
                    break;
                case "2":
                    menuVector();
                    break;
                case "3":
                    menuMatrix();
                    break;
                case "4":
                    menuRecords();
                    break;
                case "5":
                    menuLSL();
                    break;
                case "6":
                    menuLSLTaller();
                    break;
                case "7":
                    menuTriqui();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuString()
    {
        String resp;
        StringChar str = new StringChar();
        do {
            System.out.println("Menú Cadenas de Caracteres");
            System.out.println("0. Regresar");
            System.out.println("1. Ingresar texto");
            System.out.println("2. Mostrar texto");
            System.out.println("3. Longitud texto");
            System.out.println("4. Texto mayúscula");
            System.out.println("5. Texto minúscula");
            System.out.println("6. Palíndromo");
            System.out.println("7. Ejemplos cadenas");
            System.out.println("8. Contar carácter del usuario");
            System.out.println("9. Convertir cadena a ASCII");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Ingrese un texto: ");
                    str.setText(input.nextLine());
                    break;
                case "2":
                    System.out.println("Texto ingresado: " + str.getText());
                    break;
                case "3":
                    System.out.println("Longitud texto: " + str.lengthString());
                    break;
                case "4":
                    System.out.println("Texto en mayúscula: " + str.upperString());
                    break;
                case "5":
                    System.out.println("Texto en minúscula: " + str.lowerString());
                    break;
                case "6":
                    str.palindrome();
                    break;
                case "7":
                    ExampleStrings es = new ExampleStrings();
                    break;
                case "8":
                    char charUser;
                    System.out.println("Carácter a contar: ");
                    charUser = input.next().charAt(0);
                    input.nextLine();
                    System.out.println("El carácter " + charUser + " se encuentra " + str.countChar(charUser));
                    break;
                case "9":
                    System.out.println("Cadena ASCII: " + str.stringASCII());
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuVector()
    {
        String resp;
        int datum, pos;
        Vector v = new Vector();
        
        do {
            System.out.println("\n-------Menú Vectores------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar (secuencial)");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar");
            System.out.println("8. Ordenar (burbuja)");
            System.out.println("9. Suma datos");
            System.out.println("10. Promedio datos");
            System.out.println("11. Mayor dato");
            System.out.println("12. Menor dato");
            System.out.println("13. Varianza");
            System.out.println("14. Desviación");
            System.out.println("15. Intercambio");
            System.out.println("16. Producto punto");
            System.out.println("17. Eliminar ocurrencias");
            System.out.println("18. Verificar orden ascendente");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato vector: ");
                    datum = input.nextInt();
                    input.nextLine();
                    if (v.getN() < v.getT()) {
                        v.addVector(datum);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    // v.addVector(input.nextInt());
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + v.getN());
                    break;
                case "3":
                    v.showVector();
                    break;
                case "4":
                    if (v.getN() > 0) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.println(datum + " encontrado en posición " + pos);
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "5":
                    if (v.getN() > 0) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.updateVector(datum, pos);
                            System.out.println("Dato actualizado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "6":
                    if (v.getN() > 0) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            v.deleteVector(pos);
                            System.out.println("Dato eliminado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "7":
                    if (v.getN() < v.getT()) {
                        System.out.print("Dato referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.insertVector(pos, datum);
                            System.out.println("Dato insertado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "8":
                    if (v.getN() > 0) {
                        v.sortBubble();
                        System.out.println("Vector ordenado correctamente");
                    } else {
                        System.out.println("Vector vacío");
                    }
                case "9":
                    if (v.getN() > 0) {
                        System.out.println("Suma datos vector: " + v.sumVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "10":
                    if (v.getN() > 0) {
                        System.out.println("Promedio datos vector: " + v.avgVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "11":
                    if (v.getN() > 0) {
                        System.out.println("Mayor dato vector: " + v.maxVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "12":
                    if (v.getN() > 0) {
                        System.out.println("Menor dato vector: " + v.minVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "13":
                    if (v.getN() > 1) {
                        System.out.println("Varianza: " + v.variance());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "14":
                    if (v.getN() > 1) {
                        System.out.println("Desviación estándar: " + v.desviation());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "15":
                    if (v.getN() > 0) {
                        v.interchange();
                        System.out.println("Se intercambiaron los datos del vector");
                    } else {
                        System.out.println("No hay datos");
                    }
                    break;
                case "16":
                    int [] v1 = {2, 5 ,-6};
                    int [] v2 = {1, 8 , 4};
                    System.out.println("Producto punto: " + v.productPoint(v1, v2, 3));
                    break;
                case "17":
                    if (v.getN() > 0) {
                        v.deleteOcurrencies();
                        v.showVector();
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "18":
                    if (v.getN() > 0) {
                        if (v.sortAsc()) {
                            System.out.println("Vector ordenado ascendentemente");
                        } else {
                            System.out.println("El vector no está ordenado ascendentemente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuMatrix()
    {
        String resp;
        int rows, cols;
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        rows = 0;
        cols = 0;
        
        do {
            System.out.println("\n-------Menú Matrices------");
            System.out.println("0. Regresar");
            System.out.println("1. Crear matriz");
            System.out.println("2. Tamaño (orden)");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma matrices");
            System.out.println("5. Diagonal principal");
            System.out.println("6. Diagonal secundaria");
            System.out.println("7. Triángulo arriba");
            System.out.println("8. Triángulo izquierdo");
            System.out.println("9. Triángulo derecho");
            System.out.println("10. Triangular inferior");
            System.out.println("11. Triangular inferior secundaria");
            System.out.println("12. Mayor dato por fila");
            System.out.println("13. Promedio por columna");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Número filas: ");
                    rows = input.nextInt();
                    input.nextLine();
                    System.out.print("Número columnas: ");
                    cols = input.nextInt();
                    input.nextLine();
                    if (rows > 0 && rows <= 50 && cols > 0 && cols <= 50) {
                        matrix.setM(rows);
                        matrix.setN(cols);
                        matrix.createMatrix();
                        System.out.println("Matriz creada correctamente");
                    } else {
                        System.out.println("Tamaño no válido para la matriz");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño matriz: " + matrix.getM() + " x " + matrix.getN());
                    break;
                case "3":
                    matrix.showMatrix(matrix.getMat());
                    break;
                case "4":
                    matrix2.setM(rows);
                    matrix2.setN(cols);
                    matrix2.createMatrix();
                    matrix.sumMatrix(matrix.getMat(), matrix2.getMat());
                    matrix.showMatrix(matrix.getMat());
                    System.out.println();
                    matrix2.showMatrix(matrix2.getMat());
                    System.out.println();
                    matrix.showMatrix(matrix.getMatSum());
                    break;
                case "5":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.mainDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "6":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.secondaryDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "7":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.upTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "8":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.leftTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "9":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.rightTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "10":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangular();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "11":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangularSecondary();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "12":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.maxRow();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                case "13":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.averageColumn();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuRecords()
    {
        String name, resp;
        byte age;
        Persons per = new Persons();
        
        do {
            System.out.println("\n-------Menú Registros------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Persona joven");
            System.out.println("5. Porcentaje mayores");
            // System.out.println("5. Promedio datos");
            // System.out.println("6. Mayor dato");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nombre: ");
                    name = input.nextLine();
                    System.out.print("Edad: ");
                    age = input.nextByte();
                    input.nextLine();
                    if (per.getN() < per.getT()) {
                        per.createPerson(name, age);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + per.getN());
                    break;
                case "3":
                    per.showPerson();
                    break;
                case "4":
                    if (per.getN() > 0) {
                        per.youngPerson();
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                case "5":
                    if (per.getN() > 0) {
                        System.out.println("Porcentaje mayores de edad: " + per.percentageMax18());
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                
                // case "9":
                //     if (v.getN() > 0) {
                //         System.out.println("Suma datos vector: " + v.sumVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "10":
                //     if (v.getN() > 0) {
                //         System.out.println("Promedio datos vector: " + v.avgVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "11":
                //     if (v.getN() > 0) {
                //         System.out.println("Mayor dato vector: " + v.maxVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuLSL()
    {
        int datum;
        String resp;
        LSL list = new LSL();
        Node r;
        do {
            System.out.println("\n-------Menú LSL------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma");
            System.out.println("5. Promedio");
            System.out.println("6. Buscar");
            System.out.println("7. Modificar");
            System.out.println("8. Eliminar");
            System.out.println("9. Insertar (antes de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    list.createBeginLSL(datum);
                    System.out.println("Dato agregado en la LSL");
                    break;
                case "2":
                    System.out.println("Tamaño lista: " + list.countNodesLSL() + " nodos");
                    break;
                case "3":
                    list.showLSL();
                    break;
                case "4":
                    System.out.println("Suma lista: " + list.sumNodesLSL());
                    break;
                case "5":
                    if (list.head != null) {
                        System.out.println(
                            "Promedio lista: " + 
                            list.sumNodesLSL() / list.countNodesLSL()
                        );
                    } else {
                        System.out.println("Lista vacía");
                    }
                    break;
                case "6":
                    if (list.head != null) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.println(datum + " encontrado en dirección " + r);
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "7":
                    if (list.head != null) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.updateNode(r, datum);
                            System.out.println("Se actualizó el dato correctamente");
                            
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "8":
                    if (list.head != null) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        list.deleteNodeLSL(datum);
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "9":
                    if (list.head != null) {
                        System.out.print("Dato de referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        Node dirRef = list.findReferenceLSL(datum);
                        if (dirRef != null) {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.insertBeforeLSL(dirRef, datum);
                            System.out.println(datum + " se insertó correctamente");
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuLSLTaller()
    {
        String resp;
        int coeficiente, exponente;
        LSLTaller f = new LSLTaller();
        LSLTaller g = new LSLTaller();
        do {
            System.out.println("\n-------Menú LSL Taller------");
            System.out.println("0. Regresar");
            System.out.println("1. Crear polinomio f(x): ");
            System.out.println("2. Crear polinomio g(x): ");
            System.out.println("3. Mostrar polinomios: ");
            System.out.println("4. Ordenar polinomios: ");
            System.out.println("5. Modificar término: ");
            System.out.println("6. Eliminar término: ");
            System.out.println("7. Añadir término: ");
            System.out.println("8. Sumar polinomios: ");
            System.out.println("9. Restar polinomios: ");
            System.out.println("10. Calcular f(a) y g(a): ");

            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            String opcionPolinomio;
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Coeficiente: ");
                    coeficiente = input.nextInt();
                    input.nextLine();

                    System.out.print("Exponente: ");
                    exponente = input.nextInt();
                    input.nextLine();

                    f.createBeginLSL(coeficiente, exponente);
                    break;

                case "2":
                    System.out.print("Coeficiente: ");
                    coeficiente = input.nextInt();
                    input.nextLine();

                    System.out.print("Exponente: ");
                    exponente = input.nextInt();
                    input.nextLine();

                    g.createBeginLSL(coeficiente, exponente);
                    break;

                case "3":
                    System.out.print("f(x) = ");
                    f.showLSLTaller();

                    System.out.print("g(x) = ");
                    g.showLSLTaller();
                    break;

                case "4":
                    if (f.getHead() == null && g.getHead() == null) {
                        System.out.println("No hay polinomios creados para ordenar.");
                    } else {
                        if (f.getHead() != null) {
                            f.organizeLSLTaller();
                        }

                        if (g.getHead() != null) {
                            g.organizeLSLTaller();
                        }

                        System.out.println("Polinomios ordenados correctamente.");

                        System.out.print("f(x) = ");
                        f.showLSLTaller();

                        System.out.print("g(x) = ");
                        g.showLSLTaller();
                    }
                    break;
                case "5":
                    System.out.println("¿Qué polinomio desea modificar?");
                    System.out.println("1. f(x)");
                    System.out.println("2. g(x)");
                    System.out.print("Ingrese una opción: ");
                    opcionPolinomio = input.nextLine();

                    LSLTaller polinomioSeleccionado = null;

                    if (opcionPolinomio.equals("1")) {
                        polinomioSeleccionado = f;
                    } else if (opcionPolinomio.equals("2")) {
                        polinomioSeleccionado = g;
                    } else {
                        System.out.println("Opción no válida");
                        break;
                    }

                    if (polinomioSeleccionado.getHead() == null) {
                        System.out.println("El polinomio está vacío. No hay términos para modificar.");
                        break;
                    }

                    System.out.print("Ingrese el exponente a modificar: ");
                    exponente = input.nextInt();
                    input.nextLine();

                    NodeTaller termino = polinomioSeleccionado.findExponentLSL(exponente);
                    if (termino == null) {
                        System.out.println("El exponente " + exponente + " no se encuentra en el polinomio");
                        break;
                    }

                    System.out.print("Ingrese el nuevo coeficiente: ");
                    coeficiente = input.nextInt();
                    input.nextLine();

                    polinomioSeleccionado.modifyPolinomio(coeficiente, exponente);
                    break;
                case "6":
                    System.out.println("¿De qué polinomio desea eliminar un término?");
                    System.out.println("1. f(x)");
                    System.out.println("2. g(x)");
                    System.out.print("Ingrese una opción: ");
                    opcionPolinomio = input.nextLine();

                    LSLTaller polinomioEliminar = null;

                    if (opcionPolinomio.equals("1")) {
                        polinomioEliminar = f;
                    } else if (opcionPolinomio.equals("2")) {
                        polinomioEliminar = g;
                    } else {
                        System.out.println("Opción no válida");
                        break;
                    }

                    if (polinomioEliminar.getHead() == null) {
                        System.out.println("El polinomio está vacío. No hay términos para eliminar.");
                        break;
                    }

                    System.out.print("Ingrese el exponente del término a eliminar: ");
                    exponente = input.nextInt();
                    input.nextLine();

                    NodeTaller terminoEliminar = polinomioEliminar.findExponentLSL(exponente);
                    if (terminoEliminar == null) {
                        System.out.println("El exponente " + exponente + " no se encuentra en el polinomio");
                        break;
                    }
                    polinomioEliminar.deletePolinomio(exponente);
                    break;       
                case "7":
                    System.out.println("¿A qué polinomio desea añadir un término?");
                    System.out.println("1. f(x)");
                    System.out.println("2. g(x)");
                    System.out.println("Ingrese una opción: ");
                    opcionPolinomio = input.nextLine();

                    LSLTaller polinomioAgregar = null;

                    if (opcionPolinomio.equalsIgnoreCase("1")) {
                        polinomioAgregar = f;
                    } else if (opcionPolinomio.equals("2"))
                        polinomioAgregar = g;
                    else {
                        System.out.println("Opción no válida");
                        break;
                    }

                    System.out.print("Ingrese el coeficiente del nuevo término: ");
                    coeficiente = input.nextInt();
                    input.nextLine();

                    System.out.print("Ingrese el exponente del nuevo término: ");
                    exponente = input.nextInt();
                    input.nextLine();

                    polinomioAgregar.addTermOrdered(coeficiente, exponente);
                    System.out.println("Término agregado conservando el orden.");
                    break;
                case "8":
                    if (f.getHead() == null && g.getHead() == null) {
                        System.out.println("No hay polinomios creados para sumar.");
                    } else {
                        LSLTaller suma = f.addPolinomios(g);

                        System.out.print("f(x) = ");
                        f.showLSLTaller();

                        System.out.print("g(x) = ");
                        g.showLSLTaller();

                        System.out.print("Suma f(x) + g(x) = ");
                        suma.showLSLTaller();
                    }
                    break;
                case "9":
                    if (f.getHead() == null && g.getHead() == null) {
                        System.out.println("No hay polinomios creados para restar.");
                    } else {
                        LSLTaller resta = f.subtractPolinomios(g);

                        System.out.print("f(x) = ");
                        f.showLSLTaller();

                        System.out.print("g(x) = ");
                        g.showLSLTaller();

                        System.out.print("Resta f(x) - g(x) = ");
                        resta.showLSLTaller();
                    }      
                    break;                                                          
                case "10":
                    if (f.getHead() == null && g.getHead() == null) {
                        System.out.println("No hay polinomios creados para evaluar.");
                    } else {
                        System.out.print("Ingrese el valor de a: ");
                        int a = input.nextInt();
                        input.nextLine();

                        if (f.getHead() != null) {
                            System.out.println("f(" + a + ") = " + f.evaluatePolinomio(a));
                        } else {
                            System.out.println("f(x) No ha sido creado.");
                        }

                        if (g.getHead() != null) {
                            System.out.println("g(" + a + ") = " + g.evaluatePolinomio(a));
                        } else {
                            System.out.println("g(x) No ha sido creado.");
                        }
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuTriqui(){
        String resp;
        String jugador1, jugador2;
        char simbolo1, simbolo2;

        TriquiTaller juego = new TriquiTaller();

        do {
            System.out.println("\n-------Menú Triqui Taller------");
            System.out.println("0. Regresar: ");
            System.out.println("1. Ingresar usuarios: ");
            System.out.println("2. Sortear inicio: ");
            System.out.println("3. Mostrar estado del juego: ");
            System.out.println("4. Modificar nombres: ");
            System.out.println("5. Jugar turno: ");
            System.out.println("6. Cancelar juego: ");
            System.out.println("7. Pausar juego: ");
            System.out.println("8. Reanudar juego: ");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;

                case "1":
                    System.out.print("Ingrese nombre del jugador 1: ");
                    jugador1 = input.nextLine();

                    System.out.print("Ingrese símbolo del jugador 1: ");
                    simbolo1 = input.nextLine().charAt(0);

                    System.out.print("Ingrese nombre del jugador 2: ");
                    jugador2 = input.nextLine();

                    do {
                        System.out.print("Ingrese símbolo del jugador 2: ");
                        simbolo2 = input.nextLine().charAt(0);

                        if (simbolo1 == simbolo2) {
                            System.out.println("Los símbolos no pueden ser iguales. Por favor, ingrese un símbolo diferente para el jugador 2.");
                        }

                    } while (simbolo2 == simbolo1);

                    juego.ingresarUsuarios(jugador1, simbolo1, jugador2, simbolo2);
                    break;

                case "2":
                    juego.sortearInicio();
                    break;

                case "3":
                    juego.mostrarEstadoJuego();
                    break;

                case "4":
                    if (!juego.triqui.usuariosIngresados) {
                        System.out.println("Primero debe ingresar los usuarios.");
                        break;
                    }

                    System.out.println("¿Qué jugador desea modificar?");
                    System.out.println("1. Jugador 1: " + juego.triqui.jugador1);
                    System.out.println("2. Jugador 2: " + juego.triqui.jugador2);
                    System.out.print("Ingrese una opcion: ");
                    int numeroJugador = input.nextInt();
                    input.nextLine();

                    System.out.print("Ingrese el nuevo nombre del jugador " + numeroJugador + ": ");
                    String nuevoNombre = input.nextLine();

                    char nuevoSimbolo;

                    do {
                        System.out.print("Ingrese el nuevo símbolo del jugador " + numeroJugador + ": ");
                        nuevoSimbolo = input.nextLine().charAt(0);

                        if (numeroJugador == 1 && nuevoSimbolo == juego.triqui.simbolo2) {
                            System.out.println("El símbolo no puede ser igual al del jugador 2. Por favor, ingrese un símbolo diferente.");
                        } else if (numeroJugador ==2 && nuevoSimbolo == juego.triqui.simbolo1) {
                            System.out.println("El símbolo no puede ser igual al del jugador 1. Por favor, ingrese un símbolo diferente.");
                        }

                    } while ((numeroJugador == 1 && nuevoSimbolo == juego.triqui.simbolo2) || (numeroJugador == 2 && nuevoSimbolo == juego.triqui.simbolo1));

                    juego.modificarNombres(numeroJugador, nuevoNombre, nuevoSimbolo);
                    
                    break;

                case "5":
                    if (!juego.triqui.usuariosIngresados) {
                        System.out.println("Primero debe ingresar los usuarios.");
                        break;
                    } else if (!juego.triqui.juegoIniciado) {
                        System.out.println("Primero debe realizar el sorteo de inicio.");
                        break;
                    } else if (juego.triqui.juegoPausado) {
                        System.out.println("El juego está pausado.");
                        break;
                    }

                    int fila, columna;

                        do {
                        System.out.print("Ingrese la fila (0-2): ");
                        fila = input.nextInt();
                        input.nextLine();

                        System.out.print("Ingrese la columna (0-2): ");
                        columna = input.nextInt();
                        input.nextLine();

                        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                            System.out.println("Coordenada inválida. Intente de nuevo.");
                        } else if (juego.triqui.tablero[fila][columna] != ' ') {
                            System.out.println("Esa casilla ya está ocupada. Intente de nuevo.");
                        }

                    } while ((fila < 0 || fila > 2 || columna < 0 || columna > 2) ||
                            juego.triqui.tablero[fila][columna] != ' ');
                            
                    juego.jugarTurno(fila, columna);
                    break;

                case "6":
                    juego.cancelarJuego();
                    break;

                case "7":
                    juego.pausarJuego();
                    break;

                case "8":
                    juego.reanudarJuego();
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!resp.equals("0"));
    }

}
