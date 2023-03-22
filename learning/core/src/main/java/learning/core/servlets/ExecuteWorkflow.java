package learning.core.servlets;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.model.WorkflowModel;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = "/bin/executeWorkflow"
)
public class ExecuteWorkflow extends SlingSafeMethodsServlet {

    @Override
    protected void doGet( SlingHttpServletRequest request,  SlingHttpServletResponse response) throws ServletException, IOException {

        final ResourceResolver resourceResolver = request.getResourceResolver();
        String status = "starting";

        String payload = request.getRequestParameter("page").getString();

        try{

            if(StringUtils.isNotBlank(payload)){
                WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
                WorkflowModel workflowModel= workflowSession.getModel("/var/workflow/models/Demo-Workflow");
                WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH",payload);
               status =  workflowSession.startWorkflow(workflowModel,workflowData).getState();
            }
        } catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/Json");
        response.getWriter().write(status);
    }
}
