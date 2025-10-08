package compteurcarac;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

public class MainAvecExecutor {

    public static final int MAX_THREADS_SIMULT = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Liste des tâches
        List<CompteurDeCaracteresCallable> taches = List.of(
                new CompteurDeCaracteresCallable("http://www.univ-jfc.fr"),
                new CompteurDeCaracteresCallable("https://www.irit.fr/"),
                new CompteurDeCaracteresCallable("http://www.google.fr"),
                new CompteurDeCaracteresCallable("https://www.netflix.com/browse"),
                new CompteurDeCaracteresCallable("https://nodejs.org/fr"));

        // Création d'un pool de threads fixe
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS_SIMULT);

        try {
            Instant start = Instant.now();
            long totalCaracteres = 0;
            Duration sommeDesTemps = Duration.ZERO;

            // Soumission des tâches au pool avec invokeAll
            List<Future<ResultatDuCompte>> resultatsFuturs = executor.invokeAll(taches);

            // Récupération des résultats
            for (Future<ResultatDuCompte> futur : resultatsFuturs) {
                ResultatDuCompte resultat = futur.get(); // get() est bloquant
                totalCaracteres += resultat.nombreDeCaracteres;
                sommeDesTemps = sommeDesTemps.plus(sommeDesTemps);
            }

            System.out.printf("Nombre total d'octets : %d %n", totalCaracteres);
            System.out.printf("Temps effectif de calcul ~ %d secondes %n",
                    Duration.between(start, Instant.now()).toSeconds());
            System.out.printf("Somme des temps individuels ~ %d secondes %n",
                    sommeDesTemps.toSeconds());

        } finally {
            // Fermeture du pool
            executor.shutdown();
        }
    }

    // avec future , on a plus besoin de join 
}

