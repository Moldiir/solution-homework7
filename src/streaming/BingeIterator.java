package streaming;

import java.util.*;

public class BingeIterator implements EpisodeIterator {
    private final Iterator<Season> seasonIterator;
    private EpisodeIterator currentEpisodeIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasonIterator = seasons.iterator();
        if (seasonIterator.hasNext()) {
            currentEpisodeIterator = seasonIterator.next().createIterator();
        }
    }

    public boolean hasNext() {
        while ((currentEpisodeIterator == null || !currentEpisodeIterator.hasNext()) && seasonIterator.hasNext()) {
            currentEpisodeIterator = seasonIterator.next().createIterator();
        }
        return currentEpisodeIterator != null && currentEpisodeIterator.hasNext();
    }

    public Episode next() {
        return currentEpisodeIterator.next();
    }
}
