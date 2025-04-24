package streaming;

public class StreamingDemo {
    public static void main(String[] args) {
        Series series = new Series();

        Season s1 = new Season();
        s1.addEpisode(new Episode("S1E1 - Start", 1200));
        s1.addEpisode(new Episode("S1E2 - Conflict", 1300));

        Season s2 = new Season();
        s2.addEpisode(new Episode("S2E1 - Twist", 1400));
        s2.addEpisode(new Episode("S2E2 - Finale", 1500));

        series.addSeason(s1);
        series.addSeason(s2);

        System.out.println("Normal:");
        EpisodeIterator it = s1.createIterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nReverse:");
        it = s1.createReverseIterator();
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nShuffle:");
        it = s1.createShuffleIterator(42);
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nBinge Mode:");
        it = series.createBingeIterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}
