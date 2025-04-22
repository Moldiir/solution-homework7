package streaming;

import java.util.*;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public EpisodeIterator createIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator createShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }
}
