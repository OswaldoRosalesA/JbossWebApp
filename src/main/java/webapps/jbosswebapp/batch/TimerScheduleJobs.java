package webapps.jbosswebapp.batch;

import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author oswaldo
 */
@Startup
@Singleton
public class TimerScheduleJobs {

    @Schedule(hour = "*", minute = "*/5", info = "exampleJob every 5 minutes", persistent = false)
    public void exampleJob() {
        BatchRuntime.getJobOperator().start("exampleJob", new java.util.Properties());
    }

}
