package esempi.comparator;

import java.util.Comparator;

public class TeamInClassificaComparator implements Comparator<Team> {

    @Override
    public int compare(Team t1, Team t2) {
        if (t1.getPunteggio() == t2.getPunteggio()) {
            return -((t1.getGolFatti()-t1.getGolSubiti()) - (t2.getGolFatti() - t2.getGolSubiti()));
        }
        return -(t1.getGolFatti() - t2.getPunteggio());
    }
}
