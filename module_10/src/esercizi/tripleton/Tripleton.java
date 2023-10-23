package esercizi.tripleton;

public class Tripleton
{
    public static final int MAX_INSTANCES = 3;

    private static Tripleton[] internalInstances = new Tripleton[MAX_INSTANCES];

    private static int instanceIndex = 0;

    private Tripleton() { /* ... */ }

    public static Tripleton getInstance()
    {
        if (instanceIndex < MAX_INSTANCES)
            internalInstances[instanceIndex] = new Tripleton();

        return internalInstances[(instanceIndex++ % MAX_INSTANCES)];
    }
}
