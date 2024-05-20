package WordBank;

import java.util.Random;

public class WordBank {
    public String selectWord () {
        String[] wordList = {
                "building", "ocean", "nic",
                "supercalifragilisticexpialidocious",
                "behave", "goose", "yuma", "rubbish",
                "confident", "osmosis", "mitochondria",
                "aviation", "bear", "gift", "three",
                "zimbabwe", "engineer", "forgotten",
                "hello", "world", "hero", "pokemon",
                "adventure", "balloon", "crystal", "dinosaur",
                "elephant", "fantastic", "galaxy", "harvest",
                "illusion", "jungle", "knowledge", "lightning",
                "mountain", "nebula", "octopus", "puzzle",
                "quest", "rainbow", "sunshine", "treasure",
                "universe", "victory", "whisper", "xylophone",
                "yesterday", "zodiac", "butterfly", "champion",
                "dream", "enchanted", "festival", "garden",
                "harmony", "imagine", "journey", "kingdom",
                "legend", "mystery", "nightfall", "oasis",
                "paradise", "quicksilver", "radiance", "serendipity",
                "tranquility", "uplift", "voyage", "wonderland",
                "wilderness", "json", "horizon", "miracle",
                "crescent", "glimmer", "labyrinth", "echo",
                "reverie", "ephemeral", "brilliance", "ethereal",
                "sanctuary", "silhouette", "eclipse", "solitude",
                "infinity", "aurora", "kaleidoscope", "zenith",
                "whimsy", "serenade", "phantom", "cascade",
                "eloquence", "renaissance", "luminescence", "paragon",
                "symphony", "alchemy", "chivalry", "enigma",
                "algorithm", "binary", "cache", "database", "debug",
                "development", "encryption", "frontend", "backend", "framework",
                "function", "iteration", "loop", "compile", "syntax",
                "variable", "object", "class", "inheritance", "polymorphism",
                "abstraction", "encapsulation", "interface", "module", "network",
                "protocol", "repository", "server", "client", "java", "bamboozle",
                "tomfoolery", "humbug", "jabberwocky", "skedaddle", "shenanigans",
                "nonsensical", "absurdity", "fantastical", "whimsical", "dillydally",
                "malarkey", "clown", "paris", "london", "moscow", "australia"};

        Random random = new Random();

        int randomIndex = random.nextInt(wordList.length);
        return wordList[randomIndex];
    }
}
