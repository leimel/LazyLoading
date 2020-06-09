package co.com.magudel.orchestrator.mudanza;

import co.com.magudel.model.mudanza.dto.WorkReport;

public abstract class Mudanza<I, O> {
    private Mudanza next;

    public Mudanza linkWith(Mudanza next) {
        this.next = next;
        return next;
    }

    public abstract WorkReport execute(I input);

    protected WorkReport checkNext(O output) {
        if (next == null) {
            return (WorkReport) output;
        }
        return next.execute(output);
    }
}