package webapps.jbosswebapp.batch;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;

/**
 *
 * @author oswaldo
 */
public class ExampleBachelet extends AbstractBatchlet {

    @Override
    public String process() throws Exception {
        System.out.println("BacheletExample");
        return BatchStatus.COMPLETED.toString();
    }

}
