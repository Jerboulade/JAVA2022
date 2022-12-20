package be.technifutur.decouverte.testRecord;

import be.technifutur.decouverte.collection.data.Personne;
import be.technifutur.decouverte.testEnum.JourSemaine;

public record Cours(JourSemaine j, String label, Personne teacher) {
}
