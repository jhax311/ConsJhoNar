package consjhonar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jhoel Alexander Narváez Valarezo
 */
public class EdiJhoNar {

    //atributos, algunos estaticos para usarlos 
    //sin tener que inicializar nada
    private String direccion, poblacion;
    private int numero, codPostal;
    //array declarado
    private static PiJhoNar pisos[];
    //controlar array con contador
    private static int cont = -1;
    private int maxPi;

    public EdiJhoNar() {

    }

    //constructor de edificio, inicaliza pisos
    /**
     *
     * @param dire especifica la direccion del edificio
     * @param num especifical el numero del edificio
     * @param postal especifica codigo postal del edificio
     * @param pobla especifica la poblacion
     * @param nPisos especifica el numero de pisos del edificio
     * @param cont se inicaliza a 0 cuando se crea el edificio
     */
    public EdiJhoNar(String dire, int num, int postal, String pobla, int nPisos) {
        pisos = new PiJhoNar[nPisos];
        this.direccion = dire;
        this.numero = num;
        this.codPostal = postal;
        this.poblacion = pobla;
        this.maxPi = nPisos;
        this.cont = 0;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public PiJhoNar[] getPisos() {

        return pisos;
    }

    public void setPisos(PiJhoNar[] pisos) {
        this.pisos = pisos;
    }

    public int getContador() {
        return cont;
    }

    public void setContador(int contador) {
        this.cont = contador;
    }

    /**
     *
     * @param valLetra valida si la letra es correcta (A|B)
     * @return true si coincide, false si no coincide
     *
     */
    public static Boolean valLetra(String valLetra) {
        Pattern pat = Pattern.compile("[A|B]");
        Matcher mat = pat.matcher(valLetra);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    //si esta creado devuelve true y si no false
    /**
     *
     * @param nPlanta hace referencia a la planta del edificio
     * @param lPuerta hace referencia a la puerta
     * @return -1 si no existe o la posicion del piso en el array
     */
    public static int buscaPiso(int nPlanta, String lPuerta) {
        int pos = -1;
        for (int i = 0; i < cont; i++) {
            if (pisos[i].getPuerta().equals(lPuerta) && pisos[i].getPlanta() == nPlanta) {
                pos = i;
            }
        }
        return pos;
    }

    /**
     *
     * @param owner dueñ@ del piso
     * @param door puerta del piso
     * @param plant planta del edificio
     * @param metrs metros cuadrados del piso
     * @param nHabi numero de habiatciones del piso
     */
    //cada vez que inserta un piso suma 1 al contador
    public void insertarPiso(String owner, String door, int plant, int metrs, int nHabi) {
        if (buscaPiso(plant, door) == -1) {
            pisos[cont] = new PiJhoNar(owner, door, plant, metrs, nHabi);
            this.cont++;
        }
    }

    //para saber si el edificio no esta lleno
    /**
     *
     * @return devuelte -3 si esta vacio el edificio -1 si esta lleno 0 si se
     * puede insertar otro piso
     */
    public static int arrLLeno() {
        if (pisos == null) {
            return -3; //array null
        } else if (cont > 0 && pisos[pisos.length - 1] != null) {
            return -1; //array lleno
        } else {
            return 0; //se puede isnertar
        }

    }

    //actualizar propietario
    /**
     *
     * @param plant especifica la planta
     * @param puert especifica la puerta
     * @param propie especifica el propietario
     * @return
     */
    //llama a buscar piso, este o devueleve -1 que significa que no existe devolveria falso
    //si por el contrario si existe sera diferente a -1 , sera la posicion en array
    //hacemos un set propietario para actualizarlo, devuelve true si se hace
    public static boolean actualizaPro(int plant, String puert, String propie) {
        int posic = buscaPiso(plant, puert);
        if (posic != -1) {
            pisos[posic].setPropietario(propie);
            return true;
        }
        return false;
    }

    /**
     * Lista todos los pisos que existen
     */
    //bucle for para recorrera array y el tostring para sacar 
    //datos de los pisos
    public static void listaPisos() {
        for (int i = 0; i < cont; i++) {
            System.out.println(pisos[i].toString());
        }
    }

    //para una posible busqueda de un piso en concreto
    /**
     *
     * @param i especifica la posicion del piso en ela rray
     * @return devuelve los datos del piso
     */
    //muestra los datos de un piso en especifico
    public static String toString(int i) {
        String e = pisos[i].toString();
        return e;
    }

    //borrar piso dado puerta y planta
    /**
     *
     * @param puerta especifica la puerta para borrar piso
     * @param planta especifica la planta para borrar piso
     * @return
     */
    //se dan losa valores de puerta y planta, se usa buscapiso para sacar 
    //la posicion del piso para borrarlo, se borrara poniendo el
    //siguiente en la posicion actual pisos[i]=pisos[i+1]
    //se consiguien con un for, donde i es la posicion adquirida del piso
    //en el array, mientras que esto sea menor al numero de pisos -1 se suma 1 a i
    //asi no se consigue que se salga del array.
    //para que el ultimo sitio del array se vacie, ya que no se puede sumar +1,
    //lo pongo directamnete a null;
    //cada vez que se borrar un piso se quitara 1 al conatdor.
    
    public static boolean borrarPiso(String puerta, int planta) {
        int pos = buscaPiso(planta, puerta);
        if (pos != -1) {
            for (int i = pos; i < cont - 1; i++) {
                pisos[i] = pisos[i + 1];
            }
            pisos[cont - 1] = null;
            cont--;
            return true;
        }
        return false;
    }

    //solo saca los datos del edificio 
    @Override
    public String toString() {

        return "Edificio " + "\n dirección=" + direccion + "\n población=" + poblacion + "\n número=" + numero
                + "\n codPostal=" + codPostal + "\n numpisos " + maxPi;

    }
}
