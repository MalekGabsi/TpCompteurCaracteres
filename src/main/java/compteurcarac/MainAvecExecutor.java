package compteurcarac;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

public class MainAvecExecutor {

    public static final int MAX_THREADS_SIMULT = 3;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // La liste des tâches à exécuter (chaque tâche est un Callable)

        // TODO : décommenter lorsque la classe CompteurDeCaracteresCallable est prête
        // List<CompteurDeCaracteresCallable> taches = List.of(
        // new CompteurDeCaracteresCallable("http://www.univ-jfc.fr"),
        // new CompteurDeCaracteresCallable("https://www.irit.fr/"),
        // new CompteurDeCaracteresCallable("http://www.google.fr"),
        // new CompteurDeCaracteresCallable("https://www.netflix.com/browse"),
        // new CompteurDeCaracteresCallable("https://nodejs.org/fr"));

        // TODO : Création d’un pool de threads fixe (ExecutorService). Utiliser
        // la classe Executors et la variable MAX_THREADS_SIMULT.
        // Tip : choisir la bonne méthode statique parmi celles qui sont fournies par
        // Executors

        try {
            Instant start = Instant.now();
            long totalCaracteres = 0;
            Duration sommeDesTemps = Duration.ZERO;

            // TODO : Soumission des tâches au pool avec "invokeAll"
            // l'invocation est bloquante et renvoie une liste de Futures qu'il faut
            // conserver dans une variable locale pour les ré-utiliser plus tard
            // List<Future<xxx>> resultatsFuturs = ...;

            // TODO : récupérer le résultat de chaque future avec get() (bloquant) et
            // exploiter-le. Pour cela utiliser une boucle for
            // for (Future<xxx> futur : resultatsFuturs) {
            // // Récupération des résultats via Future.get()
            // // ResultatDuCompte resultat = ...;
            // // etc.
            // }

            System.out.printf("Nombre total d'octets : %d %n", totalCaracteres);
            System.out.printf("Temps effectif de calcul ~ %d secondes %n",
                    Duration.between(start, Instant.now()).toSeconds());
            System.out.printf("Somme des temps individuels ~ %d secondes %n",
                    sommeDesTemps.toSeconds());

        } finally {
            // TODO : Fermeture du pool
        }
    }
}
