package compteurcarac;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Cette classe télécharge une page Web et compte le nombre de caractères.
 * Elle implémente Callable pour retourner le résultat.
 */
public class CompteurDeCaracteresCallable implements Callable<ResultatDuCompte> {

    private final String urlATraiter;

    public CompteurDeCaracteresCallable(String urlATraiter) {
        this.urlATraiter = urlATraiter;
    }

    @Override
    public ResultatDuCompte call() throws Exception {
        Instant start = Instant.now();

        // Téléchargement du contenu
        String contenu;
        try (Scanner scanner = new Scanner(new URL(urlATraiter).openStream(), StandardCharsets.UTF_8)) {
            contenu = scanner.useDelimiter("\\A").next();
        }

        int nombreDeCaracteres = contenu.length();
        Duration tempsDeCalcul = Duration.between(start, Instant.now());

        System.out.printf("Il y a %d caractères dans l'URL %s (%s ms)%n",
                nombreDeCaracteres, urlATraiter, tempsDeCalcul.toMillis());

        // Retourne directement le résultat
        return new ResultatDuCompte(nombreDeCaracteres, tempsDeCalcul);
    }
}
