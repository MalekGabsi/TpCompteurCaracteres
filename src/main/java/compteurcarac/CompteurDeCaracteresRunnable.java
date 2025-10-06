package compteurcarac;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

/**
 * Cette classe télécharge une page Web et compte le nombre de caractères.
 * Elle implémente Runnable (pas Callable).
 */
public class CompteurDeCaracteresRunnable implements Runnable {

    private final String urlATraiter;
    private ResultatDuCompte resultat; // stockera le résultat une fois calculé

    public CompteurDeCaracteresRunnable(String urlATraiter) {
        this.urlATraiter = urlATraiter;
    }

    @Override
    public void run() {
        try {
            Instant start = Instant.now();

            // Téléchargement du contenu
            String contenu = "";
            // Formule magique pour lire le contenu d'un URL dans une chaine de caractères
            try (Scanner scanner = new Scanner(new URL(urlATraiter).openStream(), StandardCharsets.UTF_8)) {
                contenu = scanner.useDelimiter("\\A").next();
            }

            int nombreDeCaracteres = contenu.length();
            // Combien de temps ça a pris pour calculer le résultat
            Duration tempsDeCalcul = Duration.between(start, Instant.now());

            System.out.printf("Il y a %d caractères dans l'URL %s (%s ms) %n", nombreDeCaracteres, urlATraiter,
                    tempsDeCalcul.toMillis());

            this.resultat = new ResultatDuCompte(nombreDeCaracteres, tempsDeCalcul);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupère le résultat du calcul (après exécution du thread).
     */
    public ResultatDuCompte getResultat() {
        return resultat;
    }
}
