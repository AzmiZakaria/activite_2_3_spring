package ma.enset.gestionpatient.entities;

import java.util.Collection;

public class Medecin {
    private Long id;
    private String nom;
    private String email;
    private String specialité;
    private Collection<RenderVous> renderVous;

}
