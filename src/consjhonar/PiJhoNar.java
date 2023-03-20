package consjhonar;
/**
 *
 * @author Jhoel Alexander Narváez Valarezo
 */
public class PiJhoNar {
    //atributos
    private String propietario, puerta;
    private int planta, metros, nHabi;
    //constructor por defecto
    public PiJhoNar() {

    }
    //constructor de piso
    public PiJhoNar(String owner, String door, int plant, int metrs, int nHabita) {
        this.propietario = owner;
        this.puerta = door;
        this.planta = plant;
        this.metros = metrs;
        this.nHabi= nHabita;

    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public int getnHabi() {
        return nHabi;
    }

    public void setnHabi(int nHabi) {
        this.nHabi = nHabi;
    }

    @Override
    public String toString() {

        return "Pisos: " + "\npropietario=" + propietario + "\npuerta="
                + puerta + "\nplanta=" + planta + "\nmetros=" + metros + "\nnHabi=" + nHabi ;
    }

    @Override
    public int hashCode() {
        int hash = 22 * propietario.hashCode() * puerta.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj !=null)&& (obj instanceof PiJhoNar)) {
            PiJhoNar a = (PiJhoNar) obj;
            return a.planta == this.planta && a.metros == this.metros
                    && a.nHabi == this.nHabi && a.propietario.equals(this.propietario)
                    && a.puerta.equals(this.puerta);
        } else {
            return false;
        }
    }
}
