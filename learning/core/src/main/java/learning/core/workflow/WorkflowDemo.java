package learning.core.workflow;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(service = WorkflowProcess.class,immediate = true,property = {"process.label"+"=Learning Workflow Process",
            Constants.SERVICE_VENDOR+"=Learning",Constants.SERVICE_DESCRIPTION+"=Custom Learning workflow step."})
public class WorkflowDemo implements WorkflowProcess {
    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {


    }
}
