package dinesh.learning.core.workflows;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(property = {
        Constants.SERVICE_DESCRIPTION + "=Write Adaptive Form Attachments to File System",
        Constants.SERVICE_VENDOR + "=Adobe Systems",
        "process.label" + "=Save Adaptive Form Attachments to File System"
})
public class WorkflowTest implements WorkflowProcess {

    private static final Logger log = LoggerFactory.getLogger(WorkflowTest.class);
    @Reference
    QueryBuilder queryBuilder;
    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap processArguments)
            throws WorkflowException {
        // TODO Auto-generated method stub
        log.debug("The string I got was ..." + processArguments.get("PROCESS_ARGS", "string").toString());
        String[] params = processArguments.get("PROCESS_ARGS", "string").toString().split(",");

        Map<String, String> map = new HashMap<String, String>();
        map.put("path","/content");
        map.put("1_property", "jcr:title");
        map.put("1_property.1_value", params[0]);
        map.put("1_property.operation", "like");
        map.put("p.guessTotal", "true");
        map.put("orderby", "path");

        Query query = queryBuilder.createQuery(PredicateGroup.create(map), workflowSession.adaptTo(Session.class));
        SearchResult searchResult = query.getResult();

        List<String> page  = new ArrayList<>();

        searchResult.getHits().stream().forEach(hit -> {
            try {
                page.add(hit.getPath());
            } catch (RepositoryException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
