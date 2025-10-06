package compteurcarac;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class MainSansExecutor {

        public static void main(String[] args) throws InterruptedException {
                // Liste des tâches (les URLs à analyser)
                List<CompteurDeCaracteresRunnable> taches = List.of(
                                new CompteurDeCaracteresRunnable("http://www.univ-jfc.fr"),
                                new CompteurDeCaracteresRunnable("https://www.irit.fr/"),
                                new CompteurDeCaracteresRunnable("http://www.google.fr"),
                                new CompteurDeCaracteresRunnable("https://www.netflix.com/browse"),
                                new CompteurDeCaracteresRunnable("https://nodejs.org/fr"));

                Instant start = Instant.now();

                // TODO : créer et démarrer un Thread pour chaque tâche

                // TODO : attendre la fin de tous les threads avec join()
                // Tip : vous pouvez au préalable stocker les threads dans une liste

                int totalCaracteres = 0;
                Duration sommeDesTemps = Duration.ZERO;

                // TODO : récupérer les résultats de chaque tâche et accumuler
                // - nombre total de caractères
                // - somme des temps individuels
                // - pour faire une somme de Duration, utiliser la méthode plus()

                System.out.printf("Nombre total d'octets : %d %n", totalCaracteres);
                System.out.printf("Temps effectif de calcul ~ %d secondes %n",
                                Duration.between(start, Instant.now()).toSeconds());
                System.out.printf("Somme des temps individuels ~ %d secondes %n",
                                sommeDesTemps.toSeconds());
        }
}
